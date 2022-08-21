package dev.patika.hgsproject.service;

import dev.patika.hgsproject.entities.TollBooth;
import dev.patika.hgsproject.entities.Record;
import dev.patika.hgsproject.exception.AlreadyExistException;
import dev.patika.hgsproject.exception.NotFoundException;
import dev.patika.hgsproject.repository.TollBoothRepository;
import dev.patika.hgsproject.entities.vehicles.Bus;
import dev.patika.hgsproject.entities.vehicles.Car;
import dev.patika.hgsproject.entities.vehicles.Minibus;
import dev.patika.hgsproject.entities.vehicles.Vehicle;
import dev.patika.hgsproject.repository.RecordRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TollBoothService {
    private final TollBoothRepository laneRepository;
    private final RecordRepository recordRepository;

    public TollBoothService(TollBoothRepository laneRepository, RecordRepository recordRepository) {
        this.laneRepository = laneRepository;
        this.recordRepository = recordRepository;
    }
    public List<TollBooth> getAllCounters(){
        return this.laneRepository.findAll();

    }
    public TollBooth findById(long id){
        return laneRepository.findById(id).orElseThrow(()->new NotFoundException("a lane with identity number: "+id+" NOT FOUND."));
    }
    public TollBooth setTollBooth(TollBooth lane){
        if(laneRepository.existsByAddress(lane.getAddress())) throw new AlreadyExistException("a lane in "+lane.getAddress()+" already Exist.");
        else if(laneRepository.existsById(lane.getId())) throw new AlreadyExistException("a lane with id "+lane.getId()+" already exist.");
       return laneRepository.save(lane);
    }

    public void deleteTollBooth(TollBooth lane){
        if(this.laneRepository.existsById(lane.getId()))
            this.laneRepository.delete(lane);
        else throw new NotFoundException("a lane with identity number: "+lane.getId()+" NOT FOUND.");
    }
    public void payForToll(TollBooth lane, Vehicle vehicle){
        double fee =0;
        if (vehicle instanceof Car){
            fee = lane.getCAR_PAYMENT();
            vehicle.setBalance(vehicle.getBalance()-fee);
        }
        if (vehicle instanceof Minibus){
            fee = lane.getMINIBUS_PAYMENT();
            vehicle.setBalance(vehicle.getBalance()-fee);
        }
        if (vehicle instanceof Bus){
            fee = lane.getBUS_PAYMENT();
            vehicle.setBalance(vehicle.getBalance()-fee);
        }
        Record record = new Record(LocalDateTime.now(),fee,vehicle.getHGSnumber() , lane);
        recordRepository.save(record);
        lane.getRecords().add(record);
    }
}
