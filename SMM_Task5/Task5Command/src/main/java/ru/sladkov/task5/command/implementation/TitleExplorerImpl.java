package ru.sladkov.task5.command.implementation;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import ru.sladkov.task5.command.TitleExplorer;
import ru.sladkov.task5.gazeta_handler.implementation.GazetaXMLHandler;
import ru.sladkov.task5.utility.HandlersUtility;
import ru.sladkov.task5.utility.TitleHandler;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@Component(immediate = true)
public class TitleExplorerImpl implements TitleExplorer {

    private TitleHandler lentaHandler;
    private TitleHandler aifHandler;
    private TitleHandler gazetaHandler;

    public TitleExplorerImpl() {
        System.out.println("Constructor()");
    }

    @Reference(target = "(service.name=LentaAPIHandler)")
    public void setLentaHandler(TitleHandler lentaHandler) {
        System.out.println("Setting handler");
        this.lentaHandler = lentaHandler;
    }

    @Reference(target = "(service.name=AiFRSSHandler)")
    public void setAifHandler(TitleHandler aifHandler) {
        System.out.println("Setting handler");
        this.aifHandler = aifHandler;
    }

    @Reference(target = "(service.name=GazetaXMLHandler)")
    public void setGazetaHandler(TitleHandler gazetaHandler) {
        System.out.println("Setting handler");
        this.gazetaHandler = gazetaHandler;
    }


    public void stats(int option) {
        switch (option) {
            case 1:
                parse(lentaHandler);
                break;
            case 2:
                parse(aifHandler);
                break;
            case 3:
                System.out.println("Trying to parse");
                parse(gazetaHandler);
                break;
            case 4:
                //parseAll();
                break;
            default:
                System.out.println("Wrong argument. Try 1, 2, 3 or 4");
                break;
        }
    }

    void parse(TitleHandler handler) {
        System.out.println("Trying to parse()");
        try {
            handler.parse();
        } catch (Exception e) {
            System.out.println("Exception at handler.parse() with message: " +
                    e.getMessage());
            e.printStackTrace();
        }
       // Map<String, Integer> mapOfWords = new HashMap<>(handler.parse());
        System.out.println("After parse()");
        //HandlersUtility.sortAndPrint(handler.parse());
        System.out.println("Parsed");
    }

    /* void parseAll() throws Exception {
        Map<String, Integer> mapOfWords = lentaHandler.parse();
        mapOfWords.putAll(aifHandler.parse());
        mapOfWords.putAll(gazetaHandler.parse());
        HandlersUtility.sortAndPrint(mapOfWords);
    } */

}
