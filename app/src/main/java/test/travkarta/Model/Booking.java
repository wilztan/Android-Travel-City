package test.travkarta.Model;

public class Booking {

    private String
        location;

    private int TotalTicket;

    public Booking(String location, int totalTicket) {
        this.location = location;
        TotalTicket = totalTicket;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTotalTicket() {
        return TotalTicket;
    }

    public void setTotalTicket(int totalTicket) {
        TotalTicket = totalTicket;
    }
}
