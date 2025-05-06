public class Tickets {
    private int id;
    private int session_id;
    private int seat_id;
    private double price;
    private boolean is_sold;

    public Tickets(int id, int session_id, int seat_id, double price, boolean is_sold) {
        this.id = id;
        this.session_id = session_id;
        this.seat_id = seat_id;
        this.price = price;
        this.is_sold = is_sold;
    }
    @Override
    public String toString(){
        return "Ticket Id: "+id+", " +
                "Session Id: "+session_id+", " +
                "Seat Id: "+seat_id+", " +
                "Price: "+price+", " +
                "Sold: "+is_sold;
    }
}

