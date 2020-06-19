package task2.hello;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {


	public void start(BundleContext bundleContext) throws Exception {
		HelloService hello = new HelloServiceImpl();
		hello.sayHello();
}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Goodbye");
	}

}
