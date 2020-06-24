package ru.sladkov.task2service.realisation;

import ru.sladkov.task2service.interfaces.HelloService;

public class HelloServiceImpl implements HelloService {
    public void sayHello() {
        System.out.println("Hello OSGi World!");
    }
}