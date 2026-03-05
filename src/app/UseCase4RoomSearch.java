import java.util.HashMap;
import java.util.Map;

/*
 * Use Case 4: Room Search & Availability Check
 * Displays only rooms that have availability > 0
 */

// Room Domain Model
class Room {
    private String type;
    private int beds;
    private int size;
    private double price;

    public Room(String type, int beds, int size, double price) {
        this.type = type;
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    public String getType() { return type; }
    public int getBeds() { return beds; }
    public int getSize() { return size; }
    public double getPrice() { return price; }
}


// Inventory Class
class RoomInventory {

    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();

        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }
}


// Search Service
class RoomSearchService {

    public void searchAvailableRooms(
            RoomInventory inventory,
            Room singleRoom,
            Room doubleRoom,
            Room suiteRoom) {

        Map<String, Integer> availability = inventory.getRoomAvailability();

        System.out.println("Room Search\n");

        if (availability.get("Single") > 0) {
            System.out.println("Single Room:");
            System.out.println("Beds: " + singleRoom.getBeds());
            System.out.println("Size: " + singleRoom.getSize() + " sqft");
            System.out.println("Price per night: " + singleRoom.getPrice());
            System.out.println("Available: " + availability.get("Single"));
            System.out.println();
        }

        if (availability.get("Double") > 0) {
            System.out.println("Double Room:");
            System.out.println("Beds: " + doubleRoom.getBeds());
            System.out.println("Size: " + doubleRoom.getSize() + " sqft");
            System.out.println("Price per night: " + doubleRoom.getPrice());
            System.out.println("Available: " + availability.get("Double"));
            System.out.println();
        }

        if (availability.get("Suite") > 0) {
            System.out.println("Suite Room:");
            System.out.println("Beds: " + suiteRoom.getBeds());
            System.out.println("Size: " + suiteRoom.getSize() + " sqft");
            System.out.println("Price per night: " + suiteRoom.getPrice());
            System.out.println("Available: " + availability.get("Suite"));
        }
    }
}


// Main Class
public class UseCase4RoomSearch {

    public static void main(String[] args) {

        Room singleRoom = new Room("Single",1, 250, 1500.0);
        Room doubleRoom = new Room("Double",2, 400, 2500.0);
        Room suiteRoom = new Room("Suite",3, 750, 5000.0);

        RoomInventory inventory = new RoomInventory();

        RoomSearchService searchService = new RoomSearchService();

        searchService.searchAvailableRooms(
                inventory,
                singleRoom,
                doubleRoom,
                suiteRoom
        );
    }
}