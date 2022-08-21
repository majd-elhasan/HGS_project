package dev.patika.hgsproject.repository;

import dev.patika.hgsproject.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record,Long> {
    List<Record> findAllByVehicleHGS(long HGS_number);
    List<Record> findAllByLaneId(long id);
}
