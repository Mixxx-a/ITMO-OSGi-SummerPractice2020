package ru.sladkov.task5.command.implementation;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import ru.sladkov.task5.command.TitleExplorer;
import ru.sladkov.task5.utility.HandlersUtility;
import ru.sladkov.task5.utility.TitleHandler;

@Component(
        property = {
                "osgi.command.scope=news",
                "osgi.command.function=stats"
        },
        service=TitleExplorer.class
)
public class TitleExplorerImpl implements TitleExplorer {

    private TitleHandler lentaHandler;
    private TitleHandler aifHandler;
    private TitleHandler gazetaHandler;

    public TitleExplorerImpl() {

    }

    @Reference(target = "(service.name=LentaAPIHandler)")
    public void setLentaHandler(TitleHandler lentaHandler) {
        this.lentaHandler = lentaHandler;
    }

    @Reference(target = "(service.name=AiFRSSHandler)")
    public void setAifHandler(TitleHandler aifHandler) {
        this.aifHandler = aifHandler;
    }

    @Reference(target = "(service.name=GazetaXMLHandler)")
    public void setGazetaHandler(TitleHandler gazetaHandler) { ;
        this.gazetaHandler = gazetaHandler;
    }

    public void stats() {
        System.out.println("Передайте \"1\" в качестве параметра для получения информации с портала Lenta.ru");
        System.out.println("Передайте \"2\" в качестве параметра для получения информации с портала АиФ");
        System.out.println("Передайте \"3\" в качестве параметра для получения информации с портала Gazeta.ru");
        System.out.println("Передайте \"4\" в качестве параметра для получения информации со всех предыдущих порталов");
    }


    public void stats(int option) {
        switch (option) {
            case 1:
                System.out.println("10 самых встречающихся слов в заголовках на портале Lenta.ru");
                parse(lentaHandler);
                break;
            case 2:
                System.out.println("10 самых встречающихся слов в заголовках на портале АиФ");
                parse(aifHandler);
                break;
            case 3:
                System.out.println("10 самых встречающихся слов в заголовках на портале Gazeta.ru");
                parse(gazetaHandler);
                break;
            case 4:
                System.out.println("10 самых встречающихся слов в заголовках на порталах Lenta.ru, АиФ и Gazeta.ru");
                parseAll();
                break;
            default:
                System.out.println("Неправильный аргумета. Попробуйте 1, 2, 3 или 4");
                break;
        }
    }

    void parse(TitleHandler handler) {
        try {
            HandlersUtility.sortAndPrint(handler.parse());
        } catch (Exception e) {
            System.err.println("Exception at TitleExplorerImpl.parse() with message: " + e.getMessage());
            e.printStackTrace();
        }
    }

    void parseAll() {
        HandlersUtility.sortAndPrint(HandlersUtility.mergeMaps(HandlersUtility.mergeMaps(lentaHandler.parse(), aifHandler.parse()),
                gazetaHandler.parse()));
    }

}
