package ru.sladkov.task3service.implementation;


import org.osgi.service.component.annotations.Component;
import ru.sladkov.task3service.Greeting;

@Component
public class GreetingImpl implements Greeting {
    private String name = "123";

    public GreetingImpl() {
        this.name = "Mikhail";
    }

    public GreetingImpl(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Hello " + name + "!");
    }

}
