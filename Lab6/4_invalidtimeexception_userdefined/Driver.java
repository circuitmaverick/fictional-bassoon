class HoursException extends Exception {
    public HoursException(String msg) { super(msg); }
}

class MinutesException extends Exception {
    public MinutesException(String msg) { super(msg); }
}

class SecondsException extends Exception {
    public SecondsException(String msg) { super(msg); }
}

class Time {
    int hours=0, mins=0, secs=0;

    public void setTime(int hours, int mins, int secs) throws HoursException, MinutesException, SecondsException {
        if(hours > 24 || hours < 0) throw new HoursException("Invalid hours provided. It should be in range 0-24");
        if(mins < 0 || mins > 59) throw new MinutesException("Invalid minutes provided. It should be in range 0-59");
        if(secs < 0 || secs > 59) throw new SecondsException("Invalid seconds provided. It should be in range 0-59");
        this.hours = hours; this.mins = mins; this.secs = secs;
    }

    public void display() {
        System.out.println(hours+":"+mins+":"+secs);
    }
}

public class Driver {
    public static void main(String[] args) {
        Time t = new Time();
        try {
            t.setTime( 18, 19, -8);
        } catch(Exception e) {
            System.out.println(e);
        } finally {
            t.display();
        }
    }
}