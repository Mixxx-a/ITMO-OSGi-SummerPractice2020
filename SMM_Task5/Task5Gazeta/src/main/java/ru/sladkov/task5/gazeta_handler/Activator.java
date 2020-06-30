package ru.sladkov.task5.gazeta_handler;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import ru.sladkov.task5.gazeta_handler.implementation.GazetaXMLHandler;
import ru.sladkov.task5.utility.TitleHandler;

public class Activator implements BundleActivator {

    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Gazeta XML title handler service STARTED!");
    }

    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Gazeta XML title handler service STOPPED!");
    }

}
