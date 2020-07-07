package metroMap;

import java.util.*;

public class ContainerStations {

    private List<Station> stations;
    private TreeSet<StationsConnection> connections;

    public ContainerStations() {
        stations = new ArrayList<>();
        connections = new TreeSet<>();
    }

    public List<Station> getStations() {
        return stations;
    }

    public TreeSet<StationsConnection> getConnections() {
        return connections;
    }

    public void addStation(Station station){
        stations.add(station);
    }

    public void addConnection(StationsConnection stationsCon){
        connections.add(stationsCon);
    }
}
