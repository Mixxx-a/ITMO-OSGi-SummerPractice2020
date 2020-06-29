package ru.sladkov.task3service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Hello service started");
        // System.out.println("CurrentDate-service started");
    }

    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Hello service stopped");
        //System.out.println("CurrentDate-service stopped");
    }

}