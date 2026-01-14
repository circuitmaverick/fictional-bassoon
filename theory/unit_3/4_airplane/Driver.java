import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Airplane {
    private String flight_number, destination, flight_status;
    private LocalTime departure_time_original, departure_time_scheduled;
    private Duration delay;

    public Airplane(String flightNum, String destination, String departureTimeOriginal, String departureTimeScheduled) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.flight_number = flightNum;
        this.destination = destination;
        this.departure_time_original = LocalTime.parse(departureTimeOriginal, formatter);
        this.departure_time_scheduled = LocalTime.parse(departureTimeScheduled, formatter);
        this.delay = Duration.between(departure_time_original, departure_time_scheduled);
        if(this.delay.isZero()) this.flight_status = "ON TIME";
        else if(LocalTime.now().isAfter(departure_time_scheduled)) this.flight_status="DEPARTED";
        else this.flight_status="DELAYED";
   }

   public String getFlightNumber() { return flight_number; }

   public String getFlightStatus() {
        return flight_status;
   }
}

public class Driver {
    public static void main(String[] args) {
        Airplane plane1 = new Airplane("FX0921", "LAX", "02:10:00", "02:10:00");
        System.out.println(plane1.getFlightStatus());
        Airplane plane2 = new Airplane("UL8932", "BOM", "01:45:00", "01:50:00");
        System.out.println(plane2.getFlightStatus());
    }
}