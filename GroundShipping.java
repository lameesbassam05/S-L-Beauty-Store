/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author [lamees & sadeel]
 */
import java.util.*;

public class GroundShipping extends Shipping {

    // Default constructor
    public GroundShipping() {
        super();
    }

    // Constructor with parameters
    public GroundShipping(String destination_address, double base_shipping_cost, Date order_date) {
        super(destination_address, base_shipping_cost, order_date);
    }

    // Calculate cost - 5% extra, max 7KG
    @Override
    public double calculate_cost(double weight) {

        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be greater than 0");
        }

        if (weight > 7) {
            throw new IllegalArgumentException("Too heavy! We cannot ship by land if the weight is more than 7 kg.");
        } else {
            return base_shipping_cost + (base_shipping_cost * 0.05);
        }
    }

    // Delivery time for ground
    @Override
    public String calculate_delivery_time() {
        return "Land shipping takes 7 to 10 days";
    }
}
