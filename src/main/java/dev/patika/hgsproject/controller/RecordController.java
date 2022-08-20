package dev.patika.hgsproject.controller;

import dev.patika.hgsproject.entities.Record;
import dev.patika.hgsproject.entities.RecordDTO;
import dev.patika.hgsproject.service.RecordService;
import lombok.Builder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {
    private final RecordService service;

    public RecordController(RecordService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<RecordDTO>> getAllRecords(){
        List<RecordDTO> records = new ArrayList<>();
        for(Record record : this.service.getAllRecords()){
            records.add(RecordDTO.builder()
                    .id(record.getId())
                    .counter_id(record.getCounter().getId())
                    .date(record.getDate())
                    .income(record.getIncome())
                    .vehicleHGS(record.getVehicleHGS())
                    .build());
        }
        return ResponseEntity.ok(records);
    }
    @GetMapping("/{HGS_Number}")
    public ResponseEntity<Record> getRecordByHGS_number(@PathVariable long HGS_Number){
        return ResponseEntity.ok(this.service.getRecordByHGS_Number(HGS_Number));
    }
}
