package ru.sladkov.task3service.realisation;

import java.util.Date;

import org.apache.felix.scr.annotations.Component;
import ru.sladkov.task3service.interfaces.CurrentDate;

@Component
public class CurrentDateImpl implements CurrentDate {

    final private Date currDate;

    public CurrentDateImpl() {
        this.currDate = new Date();
    }

    public void printDate() {
        System.out.println("Today is " + currDate.toString());
    }

}
