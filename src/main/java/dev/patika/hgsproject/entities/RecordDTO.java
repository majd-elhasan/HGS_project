package dev.patika.hgsproject.entities;

import lombok.*;

import java.time.LocalDateTime;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecordDTO {
    private long id;
    private long counter_id;
    private LocalDateTime date;
    private double income;
    private long vehicleHGS;
}
