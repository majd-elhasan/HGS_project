package dev.patika.hgsproject.repository;

import dev.patika.hgsproject.entities.Lane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaneRepository extends JpaRepository<Lane,Long> {
    boolean existsByAddress(String address);
}
