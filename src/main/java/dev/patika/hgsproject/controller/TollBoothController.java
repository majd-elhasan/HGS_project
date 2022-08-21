package dev.patika.hgsproject.controller;

import dev.patika.hgsproject.entities.TollBooth;
import dev.patika.hgsproject.exception.AlreadyExistException;
import dev.patika.hgsproject.exception.NotFoundException;
import dev.patika.hgsproject.service.TollBoothService;
import dev.patika.hgsproject.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tollBooths")
public class TollBoothController {
    private final TollBoothService tollBoothService;
    private final VehicleService vehicleService;

    public TollBoothController(TollBoothService tollBoothService, VehicleService vehicleService) {
        this.tollBoothService = tollBoothService;
        this.vehicleService = vehicleService;
    }
    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<List<TollBooth>> getAllCounters(){
        return ResponseEntity.ok(this.tollBoothService.getAllCounters());
    }

    @PostMapping
    @Transactional
    public ResponseEntity saveTollBooth(@RequestBody TollBooth tollBooth){
        try {
            return ResponseEntity.ok(tollBoothService.setTollBooth(tollBooth));
        }catch (Exception e){
            return (e instanceof AlreadyExistException)? ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage())
                    :(e instanceof NotFoundException)? ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage())
            : ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }

    }
    @DeleteMapping
    public ResponseEntity<String> deleteTollBooth(@RequestBody TollBooth tollBooth){
        try {
            this.tollBoothService.deleteTollBooth(tollBooth);
            return ResponseEntity.ok("the counter has been deleted successfully.");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
    @PostMapping("getPayment/{tollbooth_id}/{HGS_num}")
    @Transactional
    public ResponseEntity<String> getPayment(@PathVariable long tollbooth_id, @PathVariable long HGS_num){
        try {
            this.tollBoothService.payForToll(
                    tollBoothService.findById(tollbooth_id),vehicleService.getVehicleByHGS_number(HGS_num));
            return ResponseEntity.ok("the payment has been received successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}
