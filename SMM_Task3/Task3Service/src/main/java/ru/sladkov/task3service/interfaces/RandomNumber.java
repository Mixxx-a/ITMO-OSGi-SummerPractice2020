package ru.sladkov.task3service.interfaces;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

import java.util.Random;

@Service
public abstract class RandomNumber {

    static void printRandom() {
        System.out.println("Please input positive integer: ");
        int randomTo = Integer.parseInt(System.console().readLine());
        Random random = new Random();
        System.out.println("Your random number from 0 to " + randomTo + " is " + random.nextInt(randomTo));
    }
}
