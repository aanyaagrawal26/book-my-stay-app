package app;

/**
 * =============================================================
 * MAIN CLASS - UseCase10BookingCancellation
 * =============================================================
 */

public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        System.out.println("Booking Cancellation\n");

        RoomInventory inventory = new RoomInventory();

        CancellationService cancellationService = new CancellationService();

        String reservationId = "Single-1";
        String roomType = "Single Room";

        cancellationService.registerBooking(reservationId, roomType);

        cancellationService.cancelBooking(reservationId, inventory);

        cancellationService.showRollbackHistory();

        System.out.println("\nUpdated Single Room Availability: "
                + inventory.getRoomAvailability().get("Single Room"));
    }
}