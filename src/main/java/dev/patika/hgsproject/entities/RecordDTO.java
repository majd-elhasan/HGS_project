package dev.patika.hgsproject.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Builder
@Getter
@Setter
public class RecordDTO {
    private long id;
    private long counter_id;
    private LocalDateTime date;
    private double income;
    private long vehicleHGS;
}
