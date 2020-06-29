package ru.sladkov.task4command.implementation;

import ru.sladkov.task4command.Hello;

public class HelloImpl implements Hello {

    public void hello(String text) {
        System.out.println("Hello, " + text);
    }
}
