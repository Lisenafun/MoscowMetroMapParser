import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

public class AirportMain {
    public static void main(String[] args) {

        SimpleDateFormat HourFormat = new SimpleDateFormat("HH:mm");

        Airport airport = Airport.getInstance();
        List<Terminal> terminals = airport.getTerminals();
        terminals.forEach(term -> {
            System.out.println("Терминал " + term.getName() + ":");
            term.getFlights().stream()
                    .filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE))
                    .filter(flight -> {
                Calendar timeNow = Calendar.getInstance();
                Calendar timeFlight = Calendar.getInstance();
                timeFlight.setTime(flight.getDate());
                Calendar timePlusTwoHours = Calendar.getInstance();
                timePlusTwoHours.add(Calendar.HOUR, +2);
                return timeFlight.compareTo(timePlusTwoHours) <= 0 & timeFlight.compareTo(timeNow) >= 0;
            })
                    .sorted(Comparator.comparing(Flight::getDate))
                    .forEach(flight -> System.out.println(HourFormat.format(flight.getDate()) + " / " + flight.getAircraft().getModel()));
        });
    }
}
