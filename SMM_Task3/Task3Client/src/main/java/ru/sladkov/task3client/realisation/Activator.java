package ru.sladkov.task3client.realisation;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import org.osgi.framework.ServiceReference;
import ru.sladkov.task3service.interfaces.*;

public class Activator implements BundleActivator {


    public void start(BundleContext bundleContext) throws Exception {
        ServiceReference CountReference = bundleContext.getServiceReference(Count.class.getName());
        ServiceReference CurrentDateReference = bundleContext.getServiceReference(CurrentDate.class.getName());
        Count count = (Count)bundleContext.getService(CountReference);
        CurrentDate currentDate = (CurrentDate)bundleContext.getService(CurrentDateReference);
        System.out.println("Client started");

        currentDate.printDate();
        RandomNumber.printRandom();
        count.addSecond();
        count.printSeconds();

    }

    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Client stopped");
    }

}
