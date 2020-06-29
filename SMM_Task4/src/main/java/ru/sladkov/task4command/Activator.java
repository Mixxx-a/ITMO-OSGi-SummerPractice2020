/*
 * Activator.java
 *
 * @author: Sladkov M. M.
 *
 * Creates OSGi command "practice:hello"
 */

package ru.sladkov.task4command;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import java.util.Hashtable;
import ru.sladkov.task4command.implementation.HelloImpl;


public class Activator implements BundleActivator {

    public void start(BundleContext bundleContext) throws Exception {
        Hashtable props = new Hashtable();
        props.put("osgi.command.scope", "practice");
        props.put("osgi.command.function", new String[] {"hello"});

        bundleContext.registerService(Hello.class.getName(), new HelloImpl(), props);
        System.out.println("Command \"practice:hello\" started");
    }

    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Command \"practice:hello\" stopped");
    }

}
