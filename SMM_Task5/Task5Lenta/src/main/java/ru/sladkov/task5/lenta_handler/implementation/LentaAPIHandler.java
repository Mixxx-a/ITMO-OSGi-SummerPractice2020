package ru.sladkov.task5.lenta_handler.implementation;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
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

    public LentaAPIHandler() throws Exception {
        this.url = new URL("https://api.lenta.ru/lists/latest");
    }

    public void parse() throws Exception {
        try {
            System.out.println(1);
            Map<String, Integer> hashMapOfWords = new HashMap();
            //URL url = new URL("https://api.lenta.ru/lists/latest");
            URLConnection con = url.openConnection();
            InputStream is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String jsonString = br.readLine();

            Object obj = new JSONParser().parse(jsonString);
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray headlinesArr = (JSONArray) jsonObject.get("headlines");
            Iterator itr = headlinesArr.iterator();

            while (itr.hasNext()) {
                JSONObject next = (JSONObject) itr.next();
                JSONObject info = (JSONObject) next.get("info");
                String title = info.get("title").toString();
                HandlersUtility.putWordsInMap(hashMapOfWords, title);
            }

            HandlersUtility.sortAndPrint(hashMapOfWords);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
