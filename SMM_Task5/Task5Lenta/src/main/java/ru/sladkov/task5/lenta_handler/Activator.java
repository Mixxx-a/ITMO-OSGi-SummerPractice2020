package ru.sladkov.task5.lenta_handler;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Lenta API title handler service STARTED!");
    }

    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Lenta API title handler service STOPPED!");
    }

}