package ru.sladkov.task5.lenta_handler.implementation;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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

@Component(name = "LentaAPIHandler", immediate = true,
        property = {
                "service.name=LentaAPIHandler",
        },
        service = TitleHandler.class
)
public class LentaAPIHandler implements TitleHandler {

    private URL url;

    public LentaAPIHandler() {
        try {
            this.url = new URL("https://api.lenta.ru/lists/latest");
        } catch (Exception e) {
            System.err.println("Exception at public LentaAPIHandler() with message: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Map<String, Integer> parse()  {
        Map<String, Integer> hashMapOfWords = new HashMap();
        try {
            URLConnection con = url.openConnection();
            InputStream is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String jsonString = br.readLine();

            Object obj = new JSONParser().parse(jsonString);
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray headlinesArr = (JSONArray) jsonObject.get("headlines");

            for (Object o : headlinesArr) {
                JSONObject next = (JSONObject) o;
                JSONObject info = (JSONObject) next.get("info");
                String title = info.get("title").toString();
                HandlersUtility.putWordsInMap(hashMapOfWords, title);
            }
        } catch (Exception e) {
            System.err.println("Exception at LentaAPIHandler.parse() with message: " + e.getMessage());
            e.printStackTrace();
        }
        return hashMapOfWords;
    }

    public String getSiteName() {
        return "Lenta";
    }
}
