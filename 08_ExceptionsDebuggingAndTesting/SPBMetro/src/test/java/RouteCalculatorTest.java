import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {

    List<Station> route;
    StationIndex stationIndex;
    List<Station> stations;
    Line redLine;
    Line whiteLine;
    Line blueLine;

    @Override
    protected void setUp(){
        route = new ArrayList<>();

        redLine = new Line(1,"Красная");
        whiteLine = new Line(2, "Белая");
        blueLine = new Line(3, "Синяя");

        route.add(new Station("Дынная", redLine));
        route.add(new Station("Арбузная", redLine));
        route.add(new Station("Квадратная", whiteLine));
        route.add(new Station("Овальная", whiteLine));

        stations = new LinkedList<>();
        stations.add(new Station("Дынная", redLine));
        stations.add(new Station("Арбузная", redLine));
        stations.add(new Station("Квадратная", redLine));
        stations.add(new Station("Квадратная", whiteLine));
        stations.add(new Station("Овальная", whiteLine));
        stations.add(new Station("Прямоугольная", whiteLine));
        stations.add(new Station("Прямоугольная", blueLine));
        stations.add(new Station("Березовая", blueLine));
        stations.add(new Station("Ивовая", blueLine));

        for(int i = 0; i < 3; i++) {
            redLine.addStation(stations.get(i));
        }
        for(int i = 3; i < 6; i++) {
            whiteLine.addStation(stations.get(i));
        }
        for(int i = 6; i < 9; i++) {
            blueLine.addStation(stations.get(i));
        }
        stationIndex = new StationIndex();

        stationIndex.addLine(redLine);
        stationIndex.addLine(whiteLine);
        stationIndex.addLine(blueLine);
        stationIndex.addConnection(stations);
    }

    @Override
    protected void tearDown(){
        route.clear();
        stations.clear();
    }

    public void testCalculateDuration (){
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 8.5;
        assertEquals(expected, actual);
    }

    public void testGetShortestRoute_OnTheLine(){
        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        List<Station> routeActual = routeCalculator.getShortestRoute(stations.get(0), stations.get(2));
        List<Station> routeExpected = new LinkedList<>();
        routeExpected.add(new Station("Дынная", redLine));
        routeExpected.add(new Station("Арбузная", redLine));
        routeExpected.add(new Station("Квадратная", redLine));
        assertEquals(routeExpected,routeActual);
    }

    public void testGetShortestRoute_WithOneConnection(){
        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        List<Station> routeActual = routeCalculator.getShortestRoute(stations.get(1), stations.get(4));
        List<Station> routeExpected = new LinkedList<>();
        routeExpected.add(new Station("Арбузная", redLine));
        routeExpected.add(new Station("Квадратная", redLine));
        routeExpected.add(new Station("Квадратная", whiteLine));
        routeExpected.add(new Station("Овальная", whiteLine));
        assertEquals(routeExpected,routeActual);
    }

    public void testGetShortestRoute_WithTwoConnection(){
        RouteCalculator routeCalculator = new RouteCalculator(stationIndex);
        List<Station> routeActual = routeCalculator.getShortestRoute(stations.get(1), stations.get(7));
        List<Station> routeExpected = new LinkedList<>();
        routeExpected.add(new Station("Арбузная", redLine));
        routeExpected.add(new Station("Квадратная", redLine));
        routeExpected.add(new Station("Квадратная", whiteLine));
        routeExpected.add(new Station("Овальная", whiteLine));
        routeExpected.add(new Station("Прямоугольная", whiteLine));
        routeExpected.add(new Station("Прямоугольная", blueLine));
        routeExpected.add(new Station("Березовая", blueLine));
        assertEquals(routeExpected,routeActual);
    }
}
