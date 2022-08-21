package dev.patika.hgsproject.repository;

import dev.patika.hgsproject.entities.TollBooth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TollBoothRepository extends JpaRepository<TollBooth,Long> {
    boolean existsByAddress(String address);
}
