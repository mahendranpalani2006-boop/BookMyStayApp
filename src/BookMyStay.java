import java.util.HashMap;
import java.util.Map;

/**
 * ============================================================
 * USE CASE 3 – Centralized Room Inventory Management
 * ============================================================
 *
 * Book My Stay Application
 * Version 3.1 (Refactored Version)
 *
 * Demonstrates centralized inventory management using HashMap.
 *
 * @author Yashawini
 * @version 3.1
 */

class RoomInventory {

    private HashMap<String, Integer> inventory;

    // Constructor initializes inventory
    public RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single Room", 10);
        inventory.put("Double Room", 7);
        inventory.put("Suite Room", 3);
    }

    // Get availability
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Update availability
    public void updateAvailability(String roomType, int newCount) {
        inventory.put(roomType, newCount);
    }

    // Display inventory
    public void displayInventory() {
        System.out.println("Current Room Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " → Available: " + entry.getValue());
        }
    }
}

public class BookMyStay{

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();

        System.out.println("=================================");
        System.out.println("     Room Inventory System       ");
        System.out.println("           Version 3.1           ");
        System.out.println("=================================");

        inventory.displayInventory();

        System.out.println("\nChecking availability of Single Room:");
        System.out.println("Available: " + inventory.getAvailability("Single Room"));

        System.out.println("\nUpdating Single Room availability...");
        inventory.updateAvailability("Single Room", 8);

        System.out.println("\nUpdated Inventory:");
        inventory.displayInventory();
    }
}