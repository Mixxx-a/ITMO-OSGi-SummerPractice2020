package ru.sladkov.task2service.realisation;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import ru.sladkov.task2service.interfaces.*;

public class Activator implements BundleActivator {


	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Hello-service started");
		bundleContext.registerService(HelloService.class.getName(), new HelloServiceImpl(), null);

}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Hello-service stopped");
	}

}
