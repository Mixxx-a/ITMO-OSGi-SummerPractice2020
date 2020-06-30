package ru.sladkov.task5.aif_handler;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("AiF RSS title handler service STARTED!");
    }

    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("AiF RSS title handler service STOPPED!");
    }

}