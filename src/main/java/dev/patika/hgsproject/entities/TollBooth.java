package dev.patika.hgsproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@Entity
public class TollBooth {  // in turkish : 'Gişe'
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private double CAR_PAYMENT = 184.5;
    private double MINIBUS_PAYMENT = 295;
    private double BUS_PAYMENT = 350;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "tollBooth")
    private List<Record> records = new ArrayList<>();

    public TollBooth(String address) {
        this.address = address;
    }

    public TollBooth() {}

    @Override
    public String toString() {
        return "Counter{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
