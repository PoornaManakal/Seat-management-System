import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("""
                -----------------------------------------------------
                -    Welcome to the Plane Management application    -
                -----------------------------------------------------""");
        menu();
    }
    static String[] array = {"A","B","C","D"};
    static int[] A = new int[14];
    static int[] B = new int[12];
    static int[] C = new int[12];
    static int[] D = new int[14];
    static Ticket[] tickets = new Ticket[52];
    static double totalSales = 0d;
    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            try{
                System.out.print("""
                        *****************************************************
                        *                   MENU OPTIONS                    *
                        *****************************************************
                           01. Buy a Seat
                           02. Cancel a Seat
                           03. Find First Available Seat
                           04. Show Seat Planning
                           05. Print ticket information and total sales
                           06. Search ticket
                           00. Quit
                        *****************************************************
                        Please select an option :""");
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        buySeat();
                        break;
                    case 2:
                        cancelSeat();
                        break;
                    case 3:
                        firstAvailable();
                        break;
                    case 4:
                        seatPlan();
                        break;
                    case 5:
                        printTicketInfo();
                        break;
                    case 6:
                        searchTicket();
                        break;
                    case 0:
                        System.out.println("Thanks for choosing us");
                        break;
                    default:
                        System.out.println("Invalid option !");
                }
            }catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid option.(a number between 0 and 6)");
                scanner.next();
                option = -1; // Set option to an invalid value to continue the loop
            }
        } while (option!=0);
    }

    public static void buySeat(){

        Scanner scanner = new Scanner(System.in);

        String rowLetter = null;
        boolean isRow = false ;

        while (!isRow){
            System.out.print("Enter the Row (A-D) : ");
            rowLetter = scanner.next().toUpperCase();

            for (String i : array){
                if(rowLetter.equals(i)) {
                    isRow = true;
                    break;
                }
            }

            if (!isRow){
            System.out.println("invalid input");
            }

        }


        System.out.print("Enter the seat number : ");
        int seatNumber;
        try {
            seatNumber = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid seat number (an integer).");
            scanner.next(); // Clear the invalid input
            return;
        }

        int[] seat;

        switch (rowLetter){
            case "A":
                seat=A;
                break;
            case "B":
                seat=B;
                break;
            case "C":
                seat=C;
                break;
            case "D":
                seat=D;
                break;
            default:
                System.out.println("Invalid Row letter !");
                return;
        }

        if(seatNumber>=1 && seatNumber<= seat.length){
            if (seat[seatNumber-1]==0){

                System.out.print("Enter your name: ");
                String name = scanner.next();
                System.out.print("Enter your surname: ");
                String surname = scanner.next();
                System.out.print("Enter your email: ");
                String email = scanner.next();

                // Create a Person object
                Person person = new Person(name, surname, email);

                person.setName(name);
                person.setSurname(surname);
                person.setEmail(email);

                // Calculate price
                double price = price(seatNumber);

                // Create a Ticket object
                Ticket ticket = new Ticket(rowLetter, seatNumber, price, person);

                ticket.setRow(rowLetter);
                ticket.setSeat(seatNumber);
                ticket.setPrice(price);
                ticket.setPerson(person);

                totalSales += price;

                for( int i = 0; i < tickets.length; i++) {
                    if(tickets[i] == null) {
                        tickets[i] = ticket;
                        break;
                    }
                }

                seat[seatNumber-1]=1;
                System.out.println("Seat booked successfully!");

                person.printInfo();

            }else {
                System.out.println("This seat is already booked.");
            }
        }else {
            System.out.println("Invalid seat number !");
        }

    }

    public static void cancelSeat(){

        Scanner scanner = new Scanner(System.in);

        String rowLetter = null;
        boolean isRow = false ;

        while (!isRow){
            System.out.print("Enter the Row (A-D) : ");
            rowLetter = scanner.next().toUpperCase();

            for (String i : array){
                if(rowLetter.equals(i)) {
                    isRow = true;
                    break;
                }
            }

            if (!isRow){
                System.out.println("invalid input");
            }

        }

        System.out.print("Enter the seat number : ");
        int seatNumber;
        try {
            seatNumber = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid seat number (an integer).");
            scanner.next(); // Clear the invalid input
            return;
        }

        int[] seat;

        switch (rowLetter){
            case "A":
                seat=A;
                break;
            case "B":
                seat=B;
                break;
            case "C":
                seat=C;
                break;
            case "D":
                seat=D;
                break;
            default:
                System.out.println("Invalid Row letter !");
                return;
        }

        if (seatNumber >= 1 && seatNumber <= seat.length) {
            if (seat[seatNumber - 1] == 1) {
                seat[seatNumber - 1] = 0;


                for (int i = 0; i < tickets.length; i++) {
                    Ticket ticket = tickets[i];
                    if (ticket != null && rowLetter.equals(ticket.getRow()) && seatNumber == ticket.getSeat()) {
                        tickets[i] = null;
                        break;
                    }
                }

                double price = price(seatNumber);
                totalSales -= price;

                System.out.println(" Seat has canceled successfully");
            } else {
                System.out.println("This seat is not taken");
            }
        } else {
            System.out.println("Invalid seat number !");
        }

    }

    public static void seatPlan(){
        for (String row : array) {
            switch (row) {
                case "A":
                    System.out.print("A :");
                    printSeatRow(A);
                    break;
                case "B":
                    System.out.print("B :");
                    printSeatRow(B);
                    System.out.println();
                    break;
                case "C":
                    System.out.print("C :");
                    printSeatRow(C);
                    break;
                case "D":
                    System.out.print("D :");
                    printSeatRow(D);
                    break;
            }
        }
    }
    private static void printSeatRow(int[] seat) {
        for (int j : seat) {
            System.out.print(((j == 0) ? " O" : " X"));
        }
        System.out.println();
    }
    public static void firstAvailable() {
        int findSeat = 0;
        for (String row : array) {
            int[] currentRow = switch (row) {
                case "A" -> A;
                case "B" -> B;
                case "C" -> C;
                case "D" -> D;
                default -> null;
            };
            int i = 0;
            while (true) {
                assert currentRow != null;
                if (!(i < currentRow.length)) break;
                if (currentRow[i] == findSeat) {
                    System.out.println("Row " + row + ", seat " + (i + 1) + " is Available");
                    return;
                }
                i++;
            }
        }
        System.out.println("No available seat found.");
    }
    public static double price(int seatNumber) {
        if (seatNumber <= 5) {
            return 200.00;
        } else if (seatNumber <= 9) {
            return 150.00;
        }
       else {
            return 180.00;
        }
    }
    public static void printTicketInfo(){
        for (Ticket ticket : tickets) {
            if (ticket != null) {
                ticket.printTicketInfo();
            }
        }
        System.out.println();

        System.out.println(" Total sales : " + totalSales );
    }
    public static void searchTicket(){

        Scanner scanner = new Scanner(System.in);

        String rowLetter = null;
        boolean isRow = false ;

        while (!isRow){
            System.out.print("Enter the Row (A-D) : ");
            rowLetter = scanner.next().toUpperCase();

            for (String i : array){
                if(rowLetter.equals(i)) {
                    isRow = true;
                    break;
                }
            }

            if (!isRow){
                System.out.println("invalid input");
            }

        }

        System.out.print("Enter the seat number : ");
        int seatNumber;
        try {
            seatNumber = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid seat number (an integer).");
            scanner.next();
            return;
        }

        int i = 0;
        boolean found = false;
        while (i < tickets.length) {
            Ticket ticket = tickets[i];
            if (ticket != null && rowLetter.equals(ticket.getRow()) && seatNumber == ticket.getSeat()) {
                ticket.printTicketInfo();
                found = true;
                break;
            }
            i++;
        }

        if (!found) {
            System.out.println("Seat is available");
        }

    }

}