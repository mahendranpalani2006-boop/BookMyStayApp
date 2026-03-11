import java.util.*;

public class BookMyStay {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();

        Thread t1 = new Thread(new BookingTask("Alice", "Single", inventory));
        Thread t2 = new Thread(new BookingTask("Bob", "Single", inventory));
        Thread t3 = new Thread(new BookingTask("Charlie", "Double", inventory));
        Thread t4 = new Thread(new BookingTask("David", "Suite", inventory));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class BookingTask implements Runnable {

    private String guestName;
    private String roomType;
    private RoomInventory inventory;

    public BookingTask(String guestName, String roomType, RoomInventory inventory) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.inventory = inventory;
    }

    @Override
    public void run() {
        inventory.bookRoom(guestName, roomType);
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

    public synchronized void bookRoom(String guestName, String roomType) {

        if (inventory.getOrDefault(roomType, 0) > 0) {

            System.out.println(Thread.currentThread().getName() +
                    " processing booking for " + guestName);

            int remaining = inventory.get(roomType) - 1;
            inventory.put(roomType, remaining);

            System.out.println("Booking successful for " + guestName +
                    " | Room Type: " + roomType);

        } else {

            System.out.println("Booking failed for " + guestName +
                    " | No " + roomType + " rooms available");
        }
    }
}