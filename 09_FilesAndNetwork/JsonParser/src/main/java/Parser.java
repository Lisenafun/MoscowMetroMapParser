import metroMap.*;
import org.apache.commons.lang3.StringEscapeUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    private Document document;
    private List<Line> lines;
    private ContainerStations containerStations;

    public Parser(String url) throws Exception{
        document = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").maxBodySize(0).get();
        lines = new ArrayList<>();
        containerStations = new ContainerStations();
    }

    public List<Line> getLines() {
        return lines;
    }

    public ContainerStations getContainerStations() {
        return containerStations;
    }

    public JSONArray parseLine(){
        Elements linesList = document.getElementsByAttributeValueStarting("class", "js-metro-line t-metrostation-list-header t-icon-metroln ln");
        JSONArray linesObjectArray = new JSONArray();
        for(Element element : linesList) {
            Line line = new Line(element.attr("data-line"),element.ownText());
            linesObjectArray.add(line.getJsonLine());
            lines.add(line);
        }
        return linesObjectArray;
    }

    public JSONObject parseStation(){
        Elements dataList = document.getElementsByClass("js-metro-stations t-metrostation-list-table");
        JSONObject stationsObject = new JSONObject();
        for(Element element : dataList) {
            JSONArray stationsArray = new JSONArray();
            Elements stationsList = element.getElementsByClass("name");
            for(Element stationElement : stationsList) {
                stationsArray.add(stationElement.text());
                stationsObject.put(element.attr("data-line"), stationsArray);
                containerStations.addStation(new Station(stationElement.text(),element.attr("data-line")));
            }
        }
        return stationsObject;
    }

    public void parseConnection(){
        Elements dataList = document.getElementsByClass("js-metro-stations t-metrostation-list-table");
        JSONArray connectionsListArray = new JSONArray();
        for(Element element : dataList) {
            Elements connectionsList = element.select("a:has(span[title])");
            for(Element connectionElement : connectionsList) {
                String station = connectionElement.text();
                String stationNorm = StringEscapeUtils.escapeHtml4(station);
                int indexSpace = stationNorm.lastIndexOf(";");
                String stationName = stationNorm.substring(indexSpace + 1).trim();

                StationsConnection stationsConnection = new StationsConnection();
                stationsConnection.addStation(new Station(stationName, element.attr("data-line")));

                Elements connectionsSpanList = connectionElement.select("span[title]");
                for(Element conSpanElement : connectionsSpanList) {
                    String line = conSpanElement.attr("class");
                    int indexDash = line.lastIndexOf("-");
                    String numberLine = line.substring(indexDash + 1);

                    String text = conSpanElement.attr("title");
                    int indexQuote = text.indexOf("«");
                    int lastIndexQuote = text.lastIndexOf("»");
                    String station1 = text.substring(indexQuote + 1, lastIndexQuote);

                    stationsConnection.addStation(new Station(station1, numberLine));
                }
                containerStations.addConnection(stationsConnection);
            }
        }
    }

//    public JSONArray parseConnection(){
//        Elements dataList = document.getElementsByClass("js-metro-stations t-metrostation-list-table");
//        JSONArray connectionsListArray = new JSONArray();
//        for(Element element : dataList) {
//            Elements connectionsList = element.select("a:has(span[title])");
//            for(Element connectionElement : connectionsList) {
//                JSONArray connectionsArray = new JSONArray();
//                JSONObject connectionStation = new JSONObject();
//                connectionStation.put("line", element.attr("data-line"));
//
//                String station = connectionElement.text();
//                String stationNorm = StringEscapeUtils.escapeHtml4(station);
//                int indexSpace = stationNorm.lastIndexOf(";");
//                String stationName = stationNorm.substring(indexSpace + 1);
//
//                connectionStation.put("station", stationName.trim());
//                connectionsArray.add(connectionStation);
//                StationsConnection stationsConnection = new StationsConnection();
//                stationsConnection.addStation(new Station(stationName.trim(), element.attr("data-line")));
//
//                Elements connectionsSpanList = connectionElement.select("span[title]");
//                for(Element conSpanElement : connectionsSpanList) {
//                    String line = conSpanElement.attr("class");
//                    int indexDash = line.lastIndexOf("-");
//                    String numberLine = line.substring(indexDash + 1);
//
//                    String text = conSpanElement.attr("title");
//                    int indexQuote = text.indexOf("«");
//                    int lastIndexQuote = text.lastIndexOf("»");
//                    String station1 = text.substring(indexQuote + 1, lastIndexQuote);
//
//                    JSONObject stationCon = new JSONObject();
//                    stationCon.put("line", numberLine);
//                    stationCon.put("station", station1);
//                    connectionsArray.add(stationCon);
//                    stationsConnection.addStation(new Station(station1, numberLine));
//                }
//                connectionsListArray.add(connectionsArray);
//                containerStations.addConnection(stationsConnection);
//            }
//        }
//        return connectionsListArray;
//    }
}
