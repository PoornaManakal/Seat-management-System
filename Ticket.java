public class Ticket {
    private String row;
    private int seat;
    private double price;
    private Person person;
    public Ticket(String row, int seat, double price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }
    public String getRow() {
        return row;
    }
    public void setRow(String row) {
        this.row = row;
    }
    public int getSeat() {
        return seat;
    }
    public void setSeat(int seat) {
        this.seat = seat;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    public void printTicketInfo() {
        System.out.println("Ticket Information:");
        System.out.println("Row: " + getRow());
        System.out.println("Seat: " + getSeat());
        System.out.println("Price: " + getPrice());
        System.out.println("Person Information:");
        System.out.println("Name : " + getPerson().getName());
        System.out.println("Surname : " + getPerson().getSurname());
        System.out.println("Name : " + getPerson().getEmail());
        System.out.println();
    }
}

