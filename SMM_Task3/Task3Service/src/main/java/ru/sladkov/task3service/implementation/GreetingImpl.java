package ru.sladkov.task3service.implementation;

import org.osgi.service.component.annotations.Component;

import ru.sladkov.task3service.Greeting;

@Component
public class GreetingImpl implements Greeting {

    private String name;

    public GreetingImpl() {
        this.name = "Mikhail";
    }

    public void sayHello() {
        System.out.println("Hello " + name + "!");
    }

}
