package dev.patika.hgsproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Counter {  // gişe
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private double CAR_PAYMENT = 184.5;
    private double MINIBUS_PAYMENT = 295;
    private double BUS_PAYMENT = 350;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "counter")
    private List<Record> records = new ArrayList<>();

    public Counter(String address) {
        this.address = address;
    }

    public Counter() {}

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public double getCAR_PAYMENT() {
        return CAR_PAYMENT;
    }

    public void setCAR_PAYMENT(double CAR_PAYMENT) {
        this.CAR_PAYMENT = CAR_PAYMENT;
    }

    public double getMINIBUS_PAYMENT() {
        return MINIBUS_PAYMENT;
    }

    public void setMINIBUS_PAYMENT(double MINIBUS_PAYMENT) {
        this.MINIBUS_PAYMENT = MINIBUS_PAYMENT;
    }

    public double getBUS_PAYMENT() {
        return BUS_PAYMENT;
    }

    public void setBUS_PAYMENT(double BUS_PAYMENT) {
        this.BUS_PAYMENT = BUS_PAYMENT;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
