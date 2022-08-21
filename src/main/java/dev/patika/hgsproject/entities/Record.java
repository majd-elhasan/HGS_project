package dev.patika.hgsproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
@Getter
@Setter
@Entity
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    private TollBooth tollBooth;
    private LocalDateTime date;
    private double income;
    @Column(name = "hgs_number")
    private long vehicleHGS;

    public Record(LocalDateTime date, double income, Long vehicle_HGS, TollBooth tollBooth) {
        this.date = date;
        this.income = income;
        this.vehicleHGS = vehicle_HGS;
        this.tollBooth = tollBooth;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Record record = (Record) o;
        return id != null && Objects.equals(id, record.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
