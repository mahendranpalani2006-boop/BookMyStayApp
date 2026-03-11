import java.util.*;

public class BookMyStay{

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();
        BookingHistory history = new BookingHistory();
        CancellationService cancellationService = new CancellationService();

        // Create reservations
        Reservation r1 = new Reservation("Alice", "Single", "SI-1");
        Reservation r2 = new Reservation("Bob", "Double", "DO-1");

        // Add to history (confirmed bookings)
        history.addReservation(r1);
        history.addReservation(r2);

        System.out.println("Initial Inventory:");
        inventory.displayInventory();

        // Cancel reservation
        cancellationService.cancelReservation("SI-1", history, inventory);

        System.out.println("\nInventory After Cancellation:");
        inventory.displayInventory();
    }
}

class CancellationService {

    private Stack<String> rollbackStack;

    public CancellationService() {
        rollbackStack = new Stack<>();
    }

    public void cancelReservation(String roomId, BookingHistory history, RoomInventory inventory) {

        Reservation reservation = history.findReservationByRoomId(roomId);

        if (reservation == null) {
            System.out.println("Cancellation failed: Reservation not found.");
            return;
        }

        // Push roomId to rollback stack
        rollbackStack.push(roomId);

        // Restore inventory
        inventory.restoreRoom(reservation.getRoomType());

        // Remove from booking history
        history.removeReservation(reservation);

        System.out.println("Reservation cancelled successfully.");
        System.out.println("Guest: " + reservation.getGuestName());
        System.out.println("Room Type: " + reservation.getRoomType());
        System.out.println("Released Room ID: " + roomId);
    }
}

class BookingHistory {

    private List<Reservation> reservations;

    public BookingHistory() {
        reservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
    }

    public Reservation findReservationByRoomId(String roomId) {

        for (Reservation r : reservations) {
            if (r.getRoomId().equals(roomId)) {
                return r;
            }
        }

        return null;
    }
}

class RoomInventory {

    private Map<String, Integer> inventory;

    public RoomInventory() {

        inventory = new HashMap<>();

        inventory.put("Single", 1);
        inventory.put("Double", 1);
        inventory.put("Suite", 1);
    }

    public void restoreRoom(String roomType) {
        inventory.put(roomType, inventory.get(roomType) + 1);
    }

    public void displayInventory() {

        for (String type : inventory.keySet()) {
            System.out.println(type + " : " + inventory.get(type));
        }
    }
}

class Reservation {

    private String guestName;
    private String roomType;
    private String roomId;

    public Reservation(String guestName, String roomType, String roomId) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.roomId = roomId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getRoomId() {
        return roomId;
    }
}