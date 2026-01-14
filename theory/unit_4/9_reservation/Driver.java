class Reservation {
    protected String reservationID, customerName, date;

    public Reservation(String reservationID, String customerName, String date) {
        this.reservationID = reservationID;
        this.customerName = customerName;
        this.date = date;
    }
}

class ResortReservation extends Reservation {
    private int room_number;

    public ResortReservation(String reservationID, String customerName, String date, int room_number) {
        super(reservationID, customerName, date);
        this.room_number = room_number;
    }

    public String checkStatus() {
        
    }

    public void modify(String customerName, String date, int room_number) {
        super.customerName = customerName;
        super.date = date;
        this.room_number = room_number;
    }
}

public class Driver {
    
}
