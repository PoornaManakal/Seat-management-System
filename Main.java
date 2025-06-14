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