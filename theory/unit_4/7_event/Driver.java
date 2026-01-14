import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Event {
    private String name, location;
    private LocalDate date;

    public Event(String name, String location, String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("DD/MM/YYYY");
        this.date = LocalDate.parse(date, formatter);
        this.name = name;
        this.location = location;
    }

    public String toString() { return "Event(name="+name+",location="+location+",date="+date+")"; }
}

class Seminar extends Event {
    private int speakers;

    public Seminar(String name, String location, String date, int speakers) {
        super(name, location, date);
        this.speakers = speakers;
    }

    public 
}

public class Driver {
    
}
