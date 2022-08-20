package dev.patika.hgsproject.service;

import dev.patika.hgsproject.entities.Record;
import dev.patika.hgsproject.repository.RecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {
    private final RecordRepository repository;

    public RecordService(RecordRepository repository) {
        this.repository = repository;
    }
    public void saveRecord(Record record){
        repository.save(record);
    }
    public List<Record> getAllRecords(){
        return this.repository.findAll();
    }
    public Record getRecordByHGS_Number(long HGS_number){
        return this.repository.findByVehicleHGS(HGS_number);
    }
}
