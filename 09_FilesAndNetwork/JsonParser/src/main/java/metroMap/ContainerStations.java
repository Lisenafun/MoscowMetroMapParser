package metroMap;

import java.util.*;

public class ContainerStations {

    private final List<Station> stations;
    private final TreeSet<StationsConnection> connections;

    public ContainerStations() {
        stations = new ArrayList<>();
        connections = new TreeSet<>();
    }

    public TreeSet<StationsConnection> getConnections() {
        return connections;
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public void addConnection(StationsConnection stationsCon) {
        if(!containsStation(stationsCon)) {
            connections.add(stationsCon);
        }
    }

    private boolean containsStation(StationsConnection stationsCon) {
        for(StationsConnection connection : connections) {
            //нужно сравнить два множества - станции в одном коннекшене и станции в другом
            for(Station station : connection.getStationsCon()) {
                for(Station stationInner : stationsCon.getStationsCon()) {
                    if(station.getName().equals(stationInner.getName()) && station.getNumberLine().equals(stationInner.getNumberLine())) {
                        //при первом же попадении заканчиваем проверять
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
