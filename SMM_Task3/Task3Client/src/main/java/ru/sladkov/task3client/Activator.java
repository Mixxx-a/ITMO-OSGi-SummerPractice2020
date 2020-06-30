package ru.sladkov.task3client;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Client started");
    }

    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Client stopped");
    }
}