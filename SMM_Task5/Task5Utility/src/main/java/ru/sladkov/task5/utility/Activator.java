package ru.sladkov.task5.utility;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Utility for title handler services STARTED!");
    }

    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Utility for title handler services STOPPED!");
    }

}
