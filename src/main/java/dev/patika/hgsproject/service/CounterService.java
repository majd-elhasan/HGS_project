package dev.patika.hgsproject.service;

import dev.patika.hgsproject.entities.Counter;
import dev.patika.hgsproject.entities.Record;
import dev.patika.hgsproject.repository.CounterRepository;
import dev.patika.hgsproject.entities.vehicles.Bus;
import dev.patika.hgsproject.entities.vehicles.Car;
import dev.patika.hgsproject.entities.vehicles.Minibus;
import dev.patika.hgsproject.entities.vehicles.Vehicle;
import dev.patika.hgsproject.repository.RecordRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CounterService {
    private final CounterRepository counterRepository;
    private final RecordRepository recordRepository;

    public CounterService(CounterRepository counterRepository, RecordRepository recordRepository) {
        this.counterRepository = counterRepository;
        this.recordRepository = recordRepository;
    }
    public List<Counter> getAllCounters(){
        return this.counterRepository.findAll();

    }
    public Counter findById(long id){
        return counterRepository.findById(id).get();
    }
    public Counter setCounter(Counter counter){
       return counterRepository.save(counter);
    }

    public void deleteCounter(Counter counter){
        this.counterRepository.delete(counter);
    }
    public void payForToll(Counter counter, Vehicle vehicle){
        double fee =0;
        if (vehicle instanceof Car){
            fee = counter.getCAR_PAYMENT();
            vehicle.setBalance(vehicle.getBalance()-fee);
        }
        if (vehicle instanceof Minibus){
            fee = counter.getMINIBUS_PAYMENT();
            vehicle.setBalance(vehicle.getBalance()-fee);
        }
        if (vehicle instanceof Bus){
            fee = counter.getBUS_PAYMENT();
            vehicle.setBalance(vehicle.getBalance()-fee);
        }
        Record record = new Record(LocalDateTime.now(),fee,vehicle.getHGSnumber(),counter);
        recordRepository.save(record);
        counter.getRecords().add(record);
    }

}
