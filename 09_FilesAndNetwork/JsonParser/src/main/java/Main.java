import metroMap.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws Exception {
        Parser parser = new Parser("https://www.moscowmap.ru/metro.html#lines");
        JSONArray linesArray = parser.parseLine();
        ArrayList<Line> lines = new ArrayList<>(parser.getLines());

        JSONObject stationsObject = parser.parseStation();
        List<Station> stations = parser.getContainerStations().getStations();

        Metro metro = new Metro(stationsObject, linesArray);

//        JSONWriter jsonWriter = new JSONWriter();
//        jsonWriter.writeInJSONFile(metro.getMetroObject(), "src/main/resources/metroUpdate.json");

//        JSONReader jsonReader = new JSONReader();
//        jsonReader.getNumberOfStations("src/main/resources/metroUpdate.json");

        parser.parseConnection();
        TreeSet<StationsConnection> connections = parser.getContainerStations().getConnections();

        for(StationsConnection connection: connections) {
            TreeSet<Station> set = connection.getStationsCon();
            System.out.println("Переход:");
            for(Station station: set) {
                System.out.println("\t" + station + "(Линия " + station.getNumberLine() + ")");
            }
        }
    }
}
