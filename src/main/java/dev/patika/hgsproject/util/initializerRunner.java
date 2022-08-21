package dev.patika.hgsproject.util;

import dev.patika.hgsproject.Printer;
import dev.patika.hgsproject.entities.Lane;
import dev.patika.hgsproject.repository.*;
import dev.patika.hgsproject.entities.vehicles.*;
import dev.patika.hgsproject.repository.VehicleRepository;
import dev.patika.hgsproject.service.LaneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class initializerRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(initializerRunner.class);
    private final LaneRepository laneRepository;
    private final RecordRepository recordRepository;
    private final VehicleRepository vehicleRepository;
    private final LaneService laneService;

    public initializerRunner(LaneRepository laneRepository, RecordRepository recordRepository, VehicleRepository vehicleRepository, LaneService laneService) {
        this.laneRepository = laneRepository;
        this.recordRepository = recordRepository;
        this.vehicleRepository = vehicleRepository;
        this.laneService = laneService;
    }

    @Override
    public void run(String... args) throws Exception {
        /*
        if(laneRepository.findAll().isEmpty()){

            Vehicle bus1 = new Bus(5487965231L,"Mecid elhasan");
            Vehicle car1 = new Car(9865329751L,"Esra yıldız");
            Vehicle car2 = new Car(5498746321L,"zeynep bitar");
            Vehicle car3 = new Car(9287436855L,"yemin elhasan");
            Vehicle car4 = new Car(2039784140L,"ibrahim zaza");
            Vehicle minibus1 = new Minibus(1579865234L,"berat demirci");
            Vehicle minibus2 = new Minibus(9856325623L,"alp arslan");


            Lane lane = new Lane("Osmangazi Köprüsü");
            laneRepository.save(lane);
            laneService.payForToll(lane,bus1);
            laneService.payForToll(lane,car1);
            laneService.payForToll(lane,car2);
            laneService.payForToll(lane,minibus1);
            laneService.payForToll(lane,car3);
            laneService.payForToll(lane,minibus2);
            laneService.payForToll(lane,car1);
            laneService.payForToll(lane,bus1);
            laneService.payForToll(lane,car4);
            laneService.payForToll(lane,minibus1);

            vehicleRepository.save(bus1);
            vehicleRepository.save(car1);
            vehicleRepository.save(car2);
            vehicleRepository.save(car3);
            vehicleRepository.save(car4);
            vehicleRepository.save(minibus1);
            vehicleRepository.save(minibus2);

            Printer.printTodayBalance(lane.getRecords());
        }
        laneRepository.findAll().forEach(lane -> logger.info("{}", lane));
        recordRepository.findAll().forEach(record -> logger.info("{}", record));
    */
    }
}
