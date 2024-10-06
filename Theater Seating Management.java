import java.util.Scanner;

public class TheaterSeatingManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        char[][] seats = new char[5][6]; 
        
        
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = 'A';
            }
        }
        
        int option = 0;
        while (option != 4) {
           
            System.out.println("--- Theater Seating Management ---");
            System.out.println("1. Display Seating Chart");
            System.out.println("2. Book a Seat");
            System.out.println("3. Cancel a Booking");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            
            switch (option) {
                case 1: // Display seating chart
                    displaySeatingChart(seats);
                    break;
                case 2: // Book a seat
                    bookSeat(seats, scanner);
                    break;
                case 3: // Cancel a booking
                    cancelBooking(seats, scanner);
                    break;
                case 4: // Exit
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option, please choose again.");
                    break;
            }
        }
        
        scanner.close();
    }
    
   
    public static void displaySeatingChart(char[][] seats) {
        System.out.println("Seating Chart:");
        
       
        System.out.print("      "); 
        for (int j = 0; j < seats[0].length; j++) {
            System.out.print("Seat " + (j + 1) + " ");
        }
        System.out.println();
        
       
        for (int i = 0; i < seats.length; i++) {
            System.out.print("Row " + (i + 1) + ": ");
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print("  " + seats[i][j] + "   ");
            }
            System.out.println(); // Move to the next line after each row
        }
    }
    
    
    public static void bookSeat(char[][] seats, Scanner scanner) {
        System.out.print("Enter Row Number to book (1-5): ");
        int row = scanner.nextInt() - 1; 
        System.out.print("Enter Seat Number to book (1-6): ");
        int seat = scanner.nextInt() - 1; 
      
        if (row < 0 || row >= seats.length || seat < 0 || seat >= seats[row].length) {
            System.out.println("Invalid row or seat number. Please try again.");
            return;
        }
        
        if (seats[row][seat] == 'A') {
            seats[row][seat] = 'B'; 
            System.out.println("Seat booked successfully.");
        } else {
            System.out.println("Seat already booked. Please choose another seat.");
        }
    }
  
    public static void cancelBooking(char[][] seats, Scanner scanner) {
        System.out.print("Enter Row Number to cancel (1-5): ");
        int row = scanner.nextInt() - 1; 
        System.out.print("Enter Seat Number to cancel (1-6): ");
        int seat = scanner.nextInt() - 1; 
      
        if (row < 0 || row >= seats.length || seat < 0 || seat >= seats[row].length) {
            System.out.println("Invalid row or seat number. Please try again.");
            return;
        }
        
        if (seats[row][seat] == 'B') {
            seats[row][seat] = 'A'; 
            System.out.println("Booking cancelled successfully.");
        } else {
            System.out.println("Seat was not booked. Cannot cancel.");
        }
    }
}
