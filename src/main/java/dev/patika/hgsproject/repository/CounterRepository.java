package dev.patika.hgsproject.repository;

import dev.patika.hgsproject.entities.Counter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounterRepository extends JpaRepository<Counter,Long> {
}
