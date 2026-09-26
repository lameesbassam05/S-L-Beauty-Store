/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author [lamees & sadeel]
 */
public class Product {

    // Private attributes to encapsulate product data
    private int product_id;       // Unique identifier for the product
    private String name;          // Human-readable name of the product
    private double price;         // Unit cost of the product
    private int stock_quantity;   // Current number of units available in inventory
    private double weight;        // Weight of the product in kilograms (KG) 

    // Default constructor
    public Product() {
        // Initializes an empty product object
    }

    // Parameterized constructor to initialize all product attributes
    public Product(int product_id, String name, double price, int stock_quantity, double weight) {
        this.product_id = product_id;
        this.name = name;
        this.price = price;
        this.stock_quantity = stock_quantity;
        this.weight = weight;
    }

    //Gettars && Settars
    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Method to display or return all detailed information about the product
     * Implements the get_details() method as specified in the requirements
     *
     * @return A formatted string containing all product details
     */
    public String get_details() {
        return "Product{" + "product_id=" + product_id
                + ", name=" + name + ", price=" + price
                + ", stock_quantity=" + stock_quantity
                + ", weight=" + weight + '}';
    }

}
