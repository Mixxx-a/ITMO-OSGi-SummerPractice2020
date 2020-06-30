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


    public void stats(int option) throws Exception {
        switch (option) {
            case 1:
                try {
                    lentaHandler.parse();
                } catch (java.lang.reflect.InvocationTargetException e) {
                    System.out.println(e.getCause().getMessage() + e.getTargetException().getMessage());
                }

                break;
            case 2:
                aifHandler.parse();
                break;
            case 3:
                System.out.println("Trying to parse");
                gazetaHandler.parse();
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
            System.out.println("Here is invocationTargetException");
            handler.parse();
            System.out.println("WTF");
        } catch (InvocationTargetException exception) {
            System.out.println(exception.getCause() + "; " + exception.getTargetException());
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
