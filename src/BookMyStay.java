/**
 * ============================================================
 * USE CASE 2 – Basic Room Types & Static Availability
 * ============================================================
 *
 * Book My Stay Application
 * Version 2.1 (Refactored Version)
 *
 * This program demonstrates object-oriented modeling of
 * hotel rooms using abstraction and inheritance.
 *
 * Room types:
 *  - Single Room
 *  - Double Room
 *  - Suite Room
 *
 * @author Yashawini
 * @version 2.1
 */

abstract class Room {

    protected int numberOfBeds;
    protected int squareFeet;
    protected double pricePerNight;

    public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    public void displayRoomDetails() {
        System.out.println("Number of Beds: " + numberOfBeds);
        System.out.println("Square Feet: " + squareFeet);
        System.out.println("Price per Night: " + pricePerNight);
    }
}

/* Single Room */

class SingleRoom extends Room {

    public SingleRoom() {
        super(1, 250, 1500.0);
    }
}

/* Double Room */

class DoubleRoom extends Room {

    public DoubleRoom() {
        super(2, 400, 2500.0);
    }
}

/* Suite Room */

class SuiteRoom extends Room {

    public SuiteRoom() {
        super(3, 750, 5000.0);
    }
}

/* Main Application */

public class BookMyStay {

    public static void main(String[] args) {

        SingleRoom sR = new SingleRoom();
        DoubleRoom dR = new DoubleRoom();
        SuiteRoom suiteR = new SuiteRoom();

        System.out.println("=================================");
        System.out.println("      Hotel Room Initialization   ");
        System.out.println("           Version 2.1            ");
        System.out.println("=================================");

        System.out.println("\nSingle Room Details:");
        sR.displayRoomDetails();

        System.out.println("\nDouble Room Details:");
        dR.displayRoomDetails();

        System.out.println("\nSuite Room Details:");
        suiteR.displayRoomDetails();
    }
}