package dev.patika.hgsproject.service;

import dev.patika.hgsproject.entities.Record;
import dev.patika.hgsproject.exception.NotFoundException;
import dev.patika.hgsproject.repository.LaneRepository;
import dev.patika.hgsproject.repository.RecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {
    private final RecordRepository recordRepository;
    private final LaneRepository laneRepository;

    public RecordService(RecordRepository recordRepository,LaneRepository laneRepository) {
        this.recordRepository = recordRepository;
        this.laneRepository = laneRepository;
    }
    public void saveRecord(Record record){
        recordRepository.save(record);
    }
    public List<Record> getAllRecords(){
        return this.recordRepository.findAll();
    }
    public List<Record> getAllRecordsByLaneId(long id) throws Exception{
         if(!this.laneRepository.findById(id).isPresent()) throw new NotFoundException("a lane with id number "+id +" is NOT FOUND.");
        return this.recordRepository.findAllByLaneId(id);
    }
    public List<Record> getRecordsByHGS_Number(long HGS_number){
        return this.recordRepository.findAllByVehicleHGS(HGS_number);
    }
}
