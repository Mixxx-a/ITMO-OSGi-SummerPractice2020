package ru.sladkov.task3service.realisation;

import java.util.Date;

import org.apache.felix.scr.annotations.*;
import ru.sladkov.task3service.interfaces.CurrentDate;

@Service(value=CurrentDate.class)
@Component(immediate=true)
@Properties({
        @Property(name="service.description", value="Current day class"),
        @Property(name="service.vendor", value="Sladkov M. M.")
})
public class CurrentDateImpl implements CurrentDate {

    final private Date currDate;

    public CurrentDateImpl() {
        this.currDate = new Date();
    }

    @Activate
    public void printDate() {
        System.out.println("Today is " + currDate.toString());
    }

}
