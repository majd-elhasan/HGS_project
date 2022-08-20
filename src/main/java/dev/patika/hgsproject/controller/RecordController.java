package dev.patika.hgsproject.controller;

import dev.patika.hgsproject.entities.Record;
import dev.patika.hgsproject.service.RecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Records")
public class RecordController {
    private final RecordService service;

    public RecordController(RecordService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Record>> getAllRecords(){
        return ResponseEntity.ok(this.service.getAllRecords());
    }
    @GetMapping("/{HGS_Number}")
    public ResponseEntity<Record> getRecordByHGS_number(@PathVariable long HGS_Number){
        return ResponseEntity.ok(this.service.getRecordByHGS_Number(HGS_Number));
    }
}
