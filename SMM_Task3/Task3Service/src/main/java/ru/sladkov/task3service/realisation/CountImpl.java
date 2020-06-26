package ru.sladkov.task3service.realisation;

import org.apache.felix.scr.annotations.*;
import ru.sladkov.task3service.interfaces.Count;

@Service(value= Count.class)
@Component(immediate=true)
@Properties({
        @Property(name="service.description", value="Count"),
        @Property(name="service.vendor", value="Sladkov M. M.")
})
public class CountImpl implements Count {
    private int seconds = 0;

    public void addSecond() throws InterruptedException {
        Thread.sleep(1000);
        seconds++;
    }

    public void printSeconds() {
        System.out.println("Seconds passed since start: " + seconds);
    }

}
