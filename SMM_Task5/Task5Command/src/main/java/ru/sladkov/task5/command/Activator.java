package ru.sladkov.task5.command;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import ru.sladkov.task5.aif_handler.implementation.AiFRSSHandler;
import ru.sladkov.task5.command.implementation.TitleExplorerImpl;
import ru.sladkov.task5.gazeta_handler.implementation.GazetaXMLHandler;
import ru.sladkov.task5.lenta_handler.implementation.LentaAPIHandler;
import ru.sladkov.task5.utility.TitleHandler;

import java.util.Hashtable;

public class Activator implements BundleActivator {
    public void start(BundleContext bundleContext) throws Exception {

        Hashtable props = new Hashtable();
        props.put("osgi.command.scope", "news");
        props.put("osgi.command.function", new String[] {"stats"});
        bundleContext.registerService(TitleExplorer.class.getName(),
               new TitleExplorerImpl(), props);

        System.out.println("Command \"news:stats\" started");
    }

    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Command \"news:stats\" stopped");
    }
}
