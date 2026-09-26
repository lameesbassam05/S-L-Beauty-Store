/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author [lamees & sadeel]
 */
public class CartItem {

    // Private attributes to encapsulate CartItem data
    private Product product;
    private int quantity;

    //Default constructor
    public CartItem() {
        // Initializes an empty CertItem object
    }

    // Attributes
    public CartItem(Product product, int quantity) {
        this.product = product;         // Association with Product class - holds a complete Product object
        if (quantity > product.getStock_quantity()) {
            throw new IllegalArgumentException("...");
        }
        this.quantity = quantity;       // The numerical amount the customer wishes to purchase
    }

    // Gettars && Setters
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > product.getStock_quantity()) {
            throw new IllegalArgumentException("...");
        }
        this.quantity = quantity;
    }

    /**
     * Calculates the total monetary value for this specific item in the cart
     * Formula: Subtotal = product.price * quantity
     *
     * @return The subtotal for this cart item
     */
    public double get_subtotal() {
        return product.getPrice() * quantity;
    }

    /**
     * Calculates the total weight for this specific item in the cart Formula:
     * ItemTotalWeight = product.weight * quantity
     *
     * @return The total weight for this cart item
     */
    public double get_ItemTotalWeight() {
        return product.getWeight() * quantity;
    }
}
