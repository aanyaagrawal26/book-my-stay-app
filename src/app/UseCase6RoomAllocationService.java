package app;

import java.util.*;

/*
=========================================================
CLASS - RoomAllocationService
=========================================================
Handles confirmation of booking requests and assigns rooms
while preventing duplicate room allocation.
*/

class RoomAllocationService {

    /* Stores all allocated room IDs */
    private Set<String> allocatedRoomIds;

    /* Maps room type -> assigned room IDs */
    private Map<String, Set<String>> assignedRoomsByType;

    /* Counter to generate unique room numbers */
    private Map<String, Integer> roomCounters;

    public RoomAllocationService() {

        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
        roomCounters = new HashMap<>();

        roomCounters.put("Single", 0);
        roomCounters.put("Double", 0);
        roomCounters.put("Suite", 0);
    }

    /*
     Confirms booking request and allocates room
    */

    public void allocateRoom(Reservation reservation, RoomInventory inventory) {

        String roomType = reservation.getRoomType();

        int available = inventory.getRoomAvailability().getOrDefault(roomType, 0);

        if (available <= 0) {
            System.out.println("No rooms available for " + roomType);
            return;
        }

        String roomId = generateRoomId(roomType);

        allocatedRoomIds.add(roomId);

        assignedRoomsByType
                .computeIfAbsent(roomType, k -> new HashSet<>())
                .add(roomId);

        inventory.getRoomAvailability()
                .put(roomType, available - 1);

        System.out.println(
                "Booking confirmed for Guest: "
                        + reservation.getGuestName()
                        + ", Room ID: "
                        + roomId
        );
    }

    /*
     Generates unique room ID
    */

    private String generateRoomId(String roomType) {

        int count = roomCounters.get(roomType) + 1;
        roomCounters.put(roomType, count);

        return roomType + "-" + count;
    }
}


/*
=========================================================
MAIN CLASS
=========================================================
*/

public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        System.out.println("Room Allocation Processing");

        RoomInventory inventory = new RoomInventory();

        RoomAllocationService allocationService = new RoomAllocationService();

        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Single");
        Reservation r3 = new Reservation("Vanmathi", "Suite");

        allocationService.allocateRoom(r1, inventory);
        allocationService.allocateRoom(r2, inventory);
        allocationService.allocateRoom(r3, inventory);
    }
}