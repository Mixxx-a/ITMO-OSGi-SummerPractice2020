package ru.sladkov.task3client;

import org.osgi.service.component.annotations.*;

import ru.sladkov.task3service.Greeting;

@Component
public class Client {

    @Activate
    protected void onActivate() {
        System.out.println("onActivate");
    }

    @Reference
    public void setGreeter(Greeting hello) {
        System.out.println("Calling Greeting.sayhello()");
        hello.sayHello();
    }
}
