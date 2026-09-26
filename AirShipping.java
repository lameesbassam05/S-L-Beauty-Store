/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author [lamees & sadeel]
 */
import java.util.*;

public class AirShipping extends Shipping {

    // Default constructor
    public AirShipping() {
        super();
    }

    // Constructor with parameters
    public AirShipping(String destination_address, double base_shipping_cost, Date order_date) {
        super(destination_address, base_shipping_cost, order_date);
    }

    // Calculate cost - 5% extra, max 7KG
    @Override
    public double calculate_cost(double weight) {

        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be greater than 0");
        }
        
        if (weight > 50) {
            throw new IllegalArgumentException("Air Shipping unavailable: Weight exceeds 50KG."
                    + "Please use ExpressShipping for heavy items.");
        } else {
            return getBase_shipping_cost() + (getBase_shipping_cost() * 0.08);
        }
    }

    // Delivery time for ground
    @Override
    public String calculate_delivery_time() {
        return "ِAir shipping takes 4 to 7 days";
    }
}
