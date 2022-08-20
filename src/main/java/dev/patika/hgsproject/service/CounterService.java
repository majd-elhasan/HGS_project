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
    public Counter setCounter(Counter counter){
       return counterRepository.save(counter);
    }

    public void deleteCounter(Counter counter){
        this.counterRepository.delete(counter);
    }
    public void payForToll(Counter counter, Vehicle vehicle){
        double fee =0;
        if (vehicle instanceof Car){
            vehicle.balance -= fee = counter.getCAR_PAYMENT();
        }
        if (vehicle instanceof Minibus){
            vehicle.balance -= fee = counter.getMINIBUS_PAYMENT();
        }
        if (vehicle instanceof Bus){
            vehicle.balance -= fee = counter.getBUS_PAYMENT();
        }
        Record record = new Record(LocalDateTime.now(),fee,vehicle.HGSnumber,counter);
        recordRepository.save(record);
        counter.getRecords().add(record);
    }

}
