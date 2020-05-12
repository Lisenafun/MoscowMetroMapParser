import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance ();
        System.out.println (airport.getAllAircrafts ());
        System.out.println ("Количество самолетов: " + airport.getAllAircrafts ().size ());
//        System.out.println (airport.getTerminals ());
//        Aircraft aircraft = new Aircraft ("TU-134");
//        System.out.println (aircraft.getModel ());
//        System.out.println (aircraft.toString ());
//        Date date = new Date();
//        Flight flight = new Flight ("50", Flight.Type.ARRIVAL, date, aircraft);
//        Terminal terminal = new Terminal ("first");
//        terminal.addFlight (flight);
//        terminal.addParkingAircraft (aircraft);
    }
}
