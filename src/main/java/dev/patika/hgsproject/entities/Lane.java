package dev.patika.hgsproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@Entity
public class Lane {  // in turkish : 'Gişe'
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private double CAR_PAYMENT = 184.5;
    private double MINIBUS_PAYMENT = 295;
    private double BUS_PAYMENT = 350;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "lane")
    private List<Record> records = new ArrayList<>();

    public Lane(String address) {
        this.address = address;
    }

    public Lane() {}

    @Override
    public String toString() {
        return "Counter{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
