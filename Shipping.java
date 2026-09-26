/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author [lamees & sadeel]
 */
import java.util.*;

public class Shipping {

    //Attributes
    private String destination_address;
    protected double base_shipping_cost;
    private Date order_date;

    //Constructors
    public Shipping() {
        this.order_date = new Date();        // Default to current date
    }

    public Shipping(String destination_address, double base_shipping_cost, Date order_date) {
        this.destination_address = destination_address;
        this.base_shipping_cost = base_shipping_cost;
         this.order_date = order_date;
    }

    //Getters && Setters
    public String getDestination_address() {
        return destination_address;
    }

    public void setDestination_address(String destination_address) {
        this.destination_address = destination_address;
    }

    public double getBase_shipping_cost() {
        return base_shipping_cost;
    }

    public void setBase_shipping_cost(double base_shipping_cost) {
        this.base_shipping_cost = base_shipping_cost;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    // Calculate cost Default method
    public double calculate_cost(double weight) {
        return 0;
    }

    // Calculat delivary time Default method 
    public String calculate_delivery_time() {
        return "";
    }
}
