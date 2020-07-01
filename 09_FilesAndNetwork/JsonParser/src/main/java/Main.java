import org.apache.commons.lang3.StringEscapeUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Document doc = null;
        try {
            doc = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").maxBodySize(0).get();
        } catch(IOException e) {
            e.printStackTrace();
        }

        Elements dataList = doc.getElementsByClass("js-metro-stations t-metrostation-list-table");
        Elements linesList = doc.getElementsByAttributeValueStarting("class", "js-metro-line t-metrostation-list-header t-icon-metroln ln");

        //получаем линии с html-страницы
        JSONArray linesObjectArray = new JSONArray();
        for(Element element : linesList) {
            JSONObject lineObject = new JSONObject();
            lineObject.put("number", element.attr("data-line"));
            lineObject.put("name", element.ownText());
            linesObjectArray.add(lineObject);
        }

        //получаем станции с html-страницы
        JSONObject stationsObject = new JSONObject();
        for(Element element : dataList) {
            JSONArray stationsArray = new JSONArray();
            Elements stationsList = element.getElementsByClass("name");
            for(Element stationElement : stationsList) {
                stationsArray.add(stationElement.text());
                stationsObject.put(element.attr("data-line"), stationsArray);
            }
        }

        //записываем их с один json-объект
        JSONObject metroObject = new JSONObject();
        metroObject.put("stations", stationsObject);
        metroObject.put("lines", linesObjectArray);

        try {
            writeInJSONFile(metroObject, "data\\metro.json");//записываем данные в json-файл
            getNumberOfStations("data\\metro.json");
        } catch(Exception e) {
            e.printStackTrace();
        }

        //парсим переходы между станциями (записываем с дубликатами)
        JSONArray connectionsListArray = new JSONArray();
        for(Element element : dataList) {
            Elements connectionsList = element.select("a:has(span[title])");
            for(Element connectionElement : connectionsList) {
                JSONArray connectionsArray = new JSONArray();
                JSONObject connectionStation = new JSONObject();
                connectionStation.put("line", element.attr("data-line"));

                String station = connectionElement.text();
                String stationNorm = StringEscapeUtils.escapeHtml4(station);
                int indexSpace = stationNorm.lastIndexOf(";");
                String stationName = stationNorm.substring(indexSpace + 1);

                connectionStation.put("station", stationName.trim());
                connectionsArray.add(connectionStation);
                Elements connectionsSpanList = connectionElement.select("span[title]");
                for(Element conSpanElement : connectionsSpanList) {
                    String line = conSpanElement.attr("class");
                    int indexDash = line.lastIndexOf("-");
                    String numberLine = line.substring(indexDash + 1);

                    String text = conSpanElement.attr("title");
                    int indexQuote = text.indexOf("«");
                    int lastIndexQuote = text.lastIndexOf("»");
                    String station1 = text.substring(indexQuote + 1, lastIndexQuote);

                    JSONObject stationCon = new JSONObject();
                    stationCon.put("line", numberLine);
                    stationCon.put("station", station1);
                    connectionsArray.add(stationCon);
                }
                connectionsListArray.add(connectionsArray);
            }
        }

        //положила в отдельный Json файл, так как не собрала его без дубликатов.
        JSONObject connections = new JSONObject();
        connections.put("connections", connectionsListArray);
        try {
            writeInJSONFile(connections, "data\\connections.json");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeInJSONFile(JSONObject object, String path) throws Exception {
        FileWriter file = new FileWriter(path);
        file.write(object.toJSONString());
        file.flush();
        file.close();
    }

    public static void getNumberOfStations(String path) throws Exception {
        JSONParser parser = new JSONParser();
        Object object = parser.parse(new FileReader(path));
        JSONObject metroJsonObject = (JSONObject) object;
        JSONObject stationsObj = (JSONObject) metroJsonObject.get("stations");
        stationsObj.keySet().forEach(k -> {
            JSONArray stationsArray = (JSONArray) stationsObj.get(k);
            System.out.println("Линия " + k + ". Количество станций: " + stationsArray.size() + ".");
        });
    }

    //сортировка в попытках убрать дубликаты connection
    public static void sortJsonArray(JSONArray connectionsListArray) {
        connectionsListArray.forEach(connectionsObject -> {
            JSONArray connectionsObjectArray = (JSONArray) connectionsObject;
            connectionsObjectArray.sort((o1, o2) -> {
                JSONObject jsonObj1 = (JSONObject) o1;
                JSONObject jsonObj2 = (JSONObject) o2;
                String line1 = (String) jsonObj1.get("line");
                String line2 = (String) jsonObj2.get("line");
                return line1.compareTo(line2);
            });
        });
    }
}
