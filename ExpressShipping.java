/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author [lamees & sadeel]
 */
import java.util.*;

public class ExpressShipping extends Shipping {

    // Default constructor
    public ExpressShipping() {
        super();
    }

    // Constructor with parameters
    public ExpressShipping(String destination_address, double base_shipping_cost, Date order_date) {
        super(destination_address, base_shipping_cost, order_date);
    }

    // Calculate cost - 5% extra, max 7KG
    @Override
    public double calculate_cost(double weight) {

        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be greater than 0");
        }
        
        double base = getBase_shipping_cost();

        if (weight > 50) {
            return base + (base * 0.25);
        } else {
            return base + (base * 0.15);
        }
    }

    // Delivery time for ُExpress
    @Override
    public String calculate_delivery_time() {
        return "Fastest shipping takes 1 to 2 days";
    }
}
