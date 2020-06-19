package task2.consumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import task2.hello.*;

public class Activator implements BundleActivator {


    public void start(BundleContext bundleContext) throws Exception {
        HelloService hello = new HelloServiceImpl();
        hello.sayHello();
    }

    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Goodbye consumer!");
    }

}
