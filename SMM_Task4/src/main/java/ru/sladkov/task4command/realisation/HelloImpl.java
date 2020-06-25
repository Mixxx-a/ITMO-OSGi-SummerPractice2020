package ru.sladkov.task4command.realisation;

import ru.sladkov.task4command.interfaces.Hello;

public class HelloImpl implements Hello {

    public void hello(String text) {
        System.out.println("Hello, " + text);
    }
}
