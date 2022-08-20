package dev.patika.hgsproject;

import dev.patika.hgsproject.entities.Record;

import java.time.LocalDate;
import java.util.List;

public class Printer {
    public static void printTodayBalance(List<Record> records){
        System.out.println("-----------------------");
        for(Record record : records){
            System.out.println(record);
        }
        System.out.println("-----------------------");
        System.out.print("Today income : ");
        double todayIncome=0;
        for(Record record : records)
        {
            if(record.date.getYear()== LocalDate.now().getYear() &&
                    record.date.getDayOfYear() == LocalDate.now().getDayOfYear() )
                todayIncome += record.income;
        }
        System.out.println(todayIncome);
        System.out.println(LocalDate.now());

    }
}
