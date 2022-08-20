package dev.patika.hgsproject.repository;

import dev.patika.hgsproject.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record,Long> {
    Record findByVehicleHGS(long HGS_number);
}
