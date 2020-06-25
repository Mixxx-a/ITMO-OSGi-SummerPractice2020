package ru.sladkov.task3service.realisation;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import ru.sladkov.task3service.interfaces.*;

public class Activator implements BundleActivator {

    private ServiceRegistration sr1;
    private ServiceRegistration sr2;

    public void start(BundleContext bundleContext) throws Exception {
        //bundleContext.registerService(count.getClass().getName(), count, null);
        sr1 = bundleContext.registerService(Count.class.getName(), new CountImpl(), null);
        System.out.println("Count-service started");
        sr2 = bundleContext.registerService(CurrentDate.class.getName(), new CurrentDateImpl(), null);
        System.out.println("CurrentDate-service started");
    }

    public void stop(BundleContext bundleContext) throws Exception {
        sr1.unregister();
        System.out.println("Count-service stopped");
        sr2.unregister();
        System.out.println("CurrentDate-service stopped");
    }

}
