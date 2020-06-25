package ru.sladkov.task3service.interfaces;

import org.apache.felix.scr.annotations.Service;

@Service
public interface Count {

    void addSecond() throws InterruptedException;
    void printSeconds();

}
