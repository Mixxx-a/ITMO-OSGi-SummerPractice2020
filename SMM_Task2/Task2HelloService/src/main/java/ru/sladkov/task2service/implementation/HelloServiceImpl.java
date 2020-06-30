package ru.sladkov.task2service.implementation;

import ru.sladkov.task2service.HelloService;

public class HelloServiceImpl implements HelloService {

    public void sayHello() {
        System.out.println("Hello OSGi World!");
    }
}