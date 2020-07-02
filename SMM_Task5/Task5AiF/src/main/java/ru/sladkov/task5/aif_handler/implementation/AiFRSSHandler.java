package ru.sladkov.task5.aif_handler.implementation;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

import ru.sladkov.task5.utility.HandlersUtility;
import ru.sladkov.task5.utility.TitleHandler;

@Component(name = "AiFRSSHandler", immediate = true,
        property = {
                "service.name=AiFRSSHandler",
        },
        service = TitleHandler.class
)
public class AiFRSSHandler implements TitleHandler {

    private URL url;

    public AiFRSSHandler() {
        try {
            this.url = new URL("https://aif.ru/rss/news.php");
        } catch (Exception e) {
            System.err.println("Exception at AiFRSSHandler() with message: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Map<String, Integer> parse() {
        Map<String, Integer> hashMapOfWords = new HashMap();
        try {
            URLConnection con = url.openConnection();
            InputStream is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String rssLine = br.readLine();
            while (rssLine != null) {
                if (rssLine.startsWith("                <h1>")) {
                    String title = rssLine
                            .trim()
                            .replace("<h1>", "")
                            .replace("</h1>", "");
                    HandlersUtility.putWordsInMap(hashMapOfWords, title);
                }
                rssLine = br.readLine();
            }
        } catch (Exception e) {
            System.err.println("Exception at AiFRSSHandler.parse() with message: " + e.getMessage());
            e.printStackTrace();
        }
        return hashMapOfWords;
    }

    public String getSiteName() {
        return "AiF";
    }
}
