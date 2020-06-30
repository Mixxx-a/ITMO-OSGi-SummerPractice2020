package ru.sladkov.task2client;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import ru.sladkov.task2service.HelloService;

public class Activator implements BundleActivator {

    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Hello-client started");
        ServiceReference reference =
                bundleContext.getServiceReference(HelloService.class.getName());
        HelloService helloService =
                (HelloService) bundleContext.getService(reference);
        helloService.sayHello();
    }

    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Hello-client stopped");
    }

}
