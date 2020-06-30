package ru.sladkov.task2service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import ru.sladkov.task2service.implementation.HelloServiceImpl;

public class Activator implements BundleActivator {

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Hello-service started");
		bundleContext.registerService(HelloService.class.getName(),
				new HelloServiceImpl(), null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Hello-service stopped");
	}

}
