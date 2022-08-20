package dev.patika.hgsproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    @JsonIgnore
    public Counter counter;
    public LocalDateTime date;
    public double income;
    @Column(name = "hgs_number")
    public long vehicleHGS;

    public Record(LocalDateTime date, double income,Long vehicle_HGS,Counter counter) {
        this.date = date;
        this.income = income;
        this.vehicleHGS = vehicle_HGS;
        this.counter = counter;
    }

    public Record() {

    }

    @Override
    public String toString() {
        return
                date.toLocalDate()+
                " " +date.toLocalTime() +
                " __ HGS ID number=" + vehicleHGS +
                " __ income=" + income;
    }
}
