package app;

/**
 * =====================================================
 * CLASS - BookingReportService
 * =====================================================
 * Generates reports from booking history.
 */

public class BookingReportService {

    public void generateReport(BookingHistory history) {

        System.out.println("\nBooking History and Reporting\n");
        System.out.println("Booking History Report");

        for (Reservation r : history.getConfirmedReservations()) {
            System.out.println("Guest: " + r.getGuestName() +
                    ", Room Type: " + r.getRoomType());
        }
    }
}