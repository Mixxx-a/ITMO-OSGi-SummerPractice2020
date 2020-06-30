package ru.sladkov.task5.gazeta_handler.implementation;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

import ru.sladkov.task5.utility.HandlersUtility;
import ru.sladkov.task5.utility.TitleHandler;

@Component(name = "GazetaXMLHandler", immediate = true,
        property = {
                "service.name=GazetaXMLHandler",
        },
        service = TitleHandler.class
)
public class GazetaXMLHandler implements TitleHandler {

    private URL url;

    public GazetaXMLHandler() {
        try {
            this.url = new URL("https://www.gazeta.ru/export/rss/first.xml");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void parse() {
        try {
            Map<String, Integer> hashMapOfWords = new HashMap();
            //URL url = new URL("https://www.gazeta.ru/export/rss/first.xml");
            URLConnection con = url.openConnection();
            InputStream is = con.getInputStream();

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);

            NodeList itemList = doc.getElementsByTagName("item");
            for (int i = 0; i < itemList.getLength(); i++) {
                Node item = itemList.item(i);
                Element element = (Element)item;
                String title = element
                        .getElementsByTagName("title")
                        .item(0)
                        .getTextContent();
                HandlersUtility.putWordsInMap(hashMapOfWords, title);
            }
            HandlersUtility.sortAndPrint(hashMapOfWords);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
