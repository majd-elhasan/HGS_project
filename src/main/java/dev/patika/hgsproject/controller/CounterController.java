package dev.patika.hgsproject.controller;

import dev.patika.hgsproject.entities.Counter;
import dev.patika.hgsproject.service.CounterService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/counters")
public class CounterController {
    private final CounterService service;

    public CounterController(CounterService service) {
        this.service = service;
    }
    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<List<Counter>> getAllCounters(){
        return ResponseEntity.ok(this.service.getAllCounters());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Counter> saveCounter(@RequestBody Counter counter){
        return ResponseEntity.ok(service.setCounter(counter));
    }
    @DeleteMapping
    public ResponseEntity<String> deleteCounter(@RequestBody Counter counter){
        this.service.deleteCounter(counter);
        return ResponseEntity.ok("the counter has been deleted successfully.");
    }
}
