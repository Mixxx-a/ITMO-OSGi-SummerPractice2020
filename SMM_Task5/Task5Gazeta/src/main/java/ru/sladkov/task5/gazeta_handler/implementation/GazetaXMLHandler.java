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

    private String[] tagWords = {"first", "lenta", "lastnews", "politics",
            "politics_news", "business", "busnews", "social", "social_more",
            "lifestyle", "lifestyle_news", "tech_articles", "tech_news",
            "army", "army_news", "comments", "culture", "culture_more",
            "science", "science_more", "sport", "sportnews", "auto",
            "autonews", "auto_testdrive", "kolonka", "video"};

    public GazetaXMLHandler() {

    }

    public Map<String, Integer> parse() {
        Map<String, Integer> hashMapOfWords = new HashMap();
        try {
            for (String tagWord: tagWords) {
                String site = "https://www.gazeta.ru/export/rss/" + tagWord + ".xml";
                URL url = new URL(site);
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
            }
        } catch (Exception e) {
            System.err.println("Exception at GazetaXMLHandler.parse() with message: " + e.getMessage());
            e.printStackTrace();
        }
        return hashMapOfWords;
    }

    public String getSiteName() {
        return "Gazeta";
    }
}
