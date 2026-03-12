package app;

/**
 * ======================================================
 * CLASS - AddOnService
 * ======================================================
 * Use Case 7: Add-On Service Selection
 *
 * This class represents an optional service that can be
 * added to a confirmed reservation.
 *
 * Examples:
 * - Breakfast
 * - Spa
 * - Airport Pickup
 */

public class AddOnService {

    private String serviceName;
    private double cost;

    public AddOnService(String serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getCost() {
        return cost;
    }
}