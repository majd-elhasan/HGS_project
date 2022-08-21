package dev.patika.hgsproject.controller;

import dev.patika.hgsproject.entities.Record;
import dev.patika.hgsproject.entities.RecordDTO;
import dev.patika.hgsproject.service.RecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {
    private final RecordService service;

    public RecordController(RecordService service) {
        this.service = service;
    }
    @GetMapping()
    public ResponseEntity<List<RecordDTO>> getAllRecords(){
        return ResponseEntity.ok(convertToday_s_RecordsToDTO(this.service.getAllRecords()));
    }
    @GetMapping("today")
    public ResponseEntity<List<RecordDTO>> getToday_s_Records(){
        return ResponseEntity.ok(convertToday_s_RecordsToDTO(this.service.getAllRecords()));
    }
    @GetMapping("/tollBooth_id/{tollBooth_id}")
    @Transactional
    public ResponseEntity getAllRecordsRelatedTo_ThisTollBooth(@PathVariable long tollBooth_id){
        try {
            return ResponseEntity.ok(convertToday_s_RecordsToDTO(this.service.getAllRecordsByTollBoothId(tollBooth_id)));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/tollBooth_id/{tollBooth_id}/today")
    @Transactional
    public ResponseEntity getToday_s_RecordsRelatedTo_ThisTollBooth(@PathVariable long tollBooth_id){
        try {
            return ResponseEntity.ok(convertToday_s_RecordsToDTO(this.service.getAllRecordsByTollBoothId(tollBooth_id)));
        }catch (Exception e){
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("today's_income")
    public ResponseEntity<String> getToday_s_income(){
        double todayIncome=0;
        for(Record record : this.service.getAllRecords()){
            if(record.getDate().getYear()== LocalDate.now().getYear() &&
                    record.getDate().getDayOfYear() == LocalDate.now().getDayOfYear() ) {
                todayIncome += record.getIncome();
            }
        }
        return ResponseEntity.ok(String.valueOf(todayIncome));
    }
    @GetMapping("/tollBooth_id/{tollBooth_id}/today's_income")
    public ResponseEntity<String> getToday_s_income_RelatedTo_ThisTollBooth(@PathVariable long tollBooth_id){
        try {
            double todayIncome=0;
            for(Record record : this.service.getAllRecordsByTollBoothId(tollBooth_id)){
                if(record.getDate().getYear()== LocalDate.now().getYear() &&
                        record.getDate().getDayOfYear() == LocalDate.now().getDayOfYear() ) {
                    todayIncome += record.getIncome();
                }
            }
            return ResponseEntity.ok(String.valueOf(todayIncome));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/vehicle_HGS/{HGS_Number}")
    public ResponseEntity<List<Record>> getRecordsByHGS_number(@PathVariable long HGS_Number){
        return ResponseEntity.ok(this.service.getRecordsByHGS_Number(HGS_Number));
    }
    private List<RecordDTO> convertToday_s_RecordsToDTO(List<Record> records){
        List<RecordDTO> recordDTOS = new ArrayList<>();
        for(Record record : records){
            if(record.getDate().getYear()== LocalDate.now().getYear() &&
                    record.getDate().getDayOfYear() == LocalDate.now().getDayOfYear() ) {
                RecordDTO new_record = new RecordDTO();
                new_record.setId(record.getId());
                new_record.setDate(record.getDate());
                new_record.setIncome(record.getIncome());
                new_record.setTollBooth_id(record.getTollBooth().getId());
                new_record.setVehicleHGS(record.getVehicleHGS());
                recordDTOS.add(new_record);
            }
        }
        return recordDTOS;
    }
}
