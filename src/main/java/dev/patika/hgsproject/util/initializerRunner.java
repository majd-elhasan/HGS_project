package dev.patika.hgsproject.util;

import dev.patika.hgsproject.Printer;
import dev.patika.hgsproject.entities.Counter;
import dev.patika.hgsproject.repository.*;
import dev.patika.hgsproject.entities.vehicles.*;
import dev.patika.hgsproject.repository.VehicleRepository;
import dev.patika.hgsproject.service.CounterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class initializerRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(initializerRunner.class);
    private final CounterRepository counterRepository;
    private final RecordRepository recordRepository;
    private final VehicleRepository vehicleRepository;
    private final CounterService counterService;

    public initializerRunner( CounterRepository counterRepository, RecordRepository recordRepository, VehicleRepository vehicleRepository, CounterService counterService) {
        this.counterRepository = counterRepository;
        this.recordRepository = recordRepository;
        this.vehicleRepository = vehicleRepository;
        this.counterService = counterService;
    }

    @Override
    public void run(String... args) throws Exception {
        if(counterRepository.findAll().isEmpty()){

            Vehicle bus1 = new Bus(5487965231L,"Mecid elhasan");
            Vehicle car1 = new Car(9865329751L,"Esra yıldız");
            Vehicle car2 = new Car(5498746321L,"zeynep bitar");
            Vehicle car3 = new Car(9287436855L,"yemin elhasan");
            Vehicle car4 = new Car(2039784140L,"ibrahim zaza");
            Vehicle minibus1 = new Minibus(1579865234L,"berat demirci");
            Vehicle minibus2 = new Minibus(9856325623L,"alp arslan");


            Counter counter = new Counter("Osmangazi Köprüsü");
            counterRepository.save(counter);
            counterService.payForToll(counter,bus1);
            counterService.payForToll(counter,car1);
            counterService.payForToll(counter,car2);
            counterService.payForToll(counter,minibus1);
            counterService.payForToll(counter,car3);
            counterService.payForToll(counter,minibus2);
            counterService.payForToll(counter,car1);
            counterService.payForToll(counter,bus1);
            counterService.payForToll(counter,car4);
            counterService.payForToll(counter,minibus1);

            vehicleRepository.save(bus1);
            vehicleRepository.save(car1);
            vehicleRepository.save(car2);
            vehicleRepository.save(car3);
            vehicleRepository.save(car4);
            vehicleRepository.save(minibus1);
            vehicleRepository.save(minibus2);

            Printer.printTodayBalance(counter.getRecords());
        }
        counterRepository.findAll().forEach(counter -> logger.info("{}", counter));
        recordRepository.findAll().forEach(record -> logger.info("{}", record));

    }
}
