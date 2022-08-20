package dev.patika.hgsproject.controller;

import dev.patika.hgsproject.entities.Counter;
import dev.patika.hgsproject.service.CounterService;
import dev.patika.hgsproject.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/counters")
public class CounterController {
    private final CounterService counterService;
    private final VehicleService vehicleService;

    public CounterController(CounterService counterService,VehicleService vehicleService) {
        this.counterService = counterService;
        this.vehicleService = vehicleService;
    }
    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<List<Counter>> getAllCounters(){
        return ResponseEntity.ok(this.counterService.getAllCounters());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Counter> saveCounter(@RequestBody Counter counter){
        List<Counter> fetchedCounters = counterService.getAllCounters();
        for (Counter counter1 : fetchedCounters){
            if (counter1.getAddress().equals(counter.getAddress())){
                return null;
            }
        }
        return ResponseEntity.ok(counterService.setCounter(counter));
    }
    @DeleteMapping
    public ResponseEntity<String> deleteCounter(@RequestBody Counter counter){
        this.counterService.deleteCounter(counter);
        return ResponseEntity.ok("the counter has been deleted successfully.");
    }
    @PostMapping("getPayment/{counter_id}/{HGS_num}")
    @Transactional
    public ResponseEntity<String> getPayment(@PathVariable long counter_id, @PathVariable long HGS_num){

        this.counterService.payForToll(
                counterService.findById(counter_id),vehicleService.getVehicleByHGS_number(HGS_num));
        return ResponseEntity.ok("");
    }
}
