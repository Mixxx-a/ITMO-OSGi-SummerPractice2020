package ru.sladkov.task5.command;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Command \"news:stats\" started");
    }

    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Command \"news:stats\" stopped");
    }
}
