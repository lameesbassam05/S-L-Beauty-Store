/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author [lamees & sadeel]
 */
import java.util.*;

public class Cart {

    // Private attributes to encapsulate Cart data
    private CartItem[] items = new CartItem[10];    // Array to hold CartItem objects
    private int itemCount = 0;                      // Counter for actual items in cart

    //Default constructor
    public Cart() {
        // Initializes an empty Cart object
    }

    // Parameterized constructor
    public Cart(CartItem[] item, int itemCount) {
        this.items = item;
        this.itemCount = itemCount;
    }

    //Getters && Setters
    public CartItem[] getItem() {
        return items;
    }

    public void setItem(CartItem[] item) {
        this.items = item;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    /**
     * Adds a new product or updates the quantity if the product is already in
     * the cart. This method now includes stock validation from Code 1.
     *
     * @param product The product to add
     * @param quantity The quantity to add
     * @throws IllegalArgumentException if requested quantity exceeds available
     * stock
     */
    public void add_item(Product product, int quantity) {

        if (quantity <= 0) {
            System.out.println("Invalid quantity! Quantity must be greater than 0.");
            return;
        }

        // Check if product already exists in cart - UPDATE: Added stock check
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getProduct().getProduct_id() == product.getProduct_id()) {
                int newQuantity = items[i].getQuantity() + quantity;

                // ⭐⭐ NEW FROM CODE 1: Stock validation when updating existing item
                if (newQuantity > product.getStock_quantity()) {
                    throw new IllegalArgumentException(
                            "\nThe required quantity does not exist\n"
                            + "The quantity currently available is: " + product.getStock_quantity()
                    );
                }

                items[i].setQuantity(newQuantity);
                return;     // Exit after update
            }
        }

        // Expand array if full - UPDATE: Using System.arraycopy instead of manual loop
        if (itemCount >= items.length) {
            CartItem[] newItems = new CartItem[items.length * 2];
            System.arraycopy(items, 0, newItems, 0, items.length);
            items = newItems;
        }

        // ⭐⭐ NEW FROM CODE 1: Stock validation for new product
        if (quantity > product.getStock_quantity()) {
            throw new IllegalArgumentException(
                    "\nThe required quantity does not exist\n"
                    + "The quantity currently available is: " + product.getStock_quantity()
            );
        }

        // Add new product
        items[itemCount] = new CartItem(product, quantity);
        itemCount++;
    }

    /**
     * Removes item from cart by product ID. NOTE: This removes the entire item.
     * For partial removal, see Code 1.
     *
     * @param product_id ID of product to remove
     */
    public void remove_item(int product_id) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getProduct().getProduct_id() == product_id) {
                // Shift elements left to fill gap
                for (int j = i; j < itemCount - 1; j++) {
                    items[j] = items[j + 1];
                }

                // Clean up and update count
                items[itemCount - 1] = null;
                itemCount--;
                return;     // Exit after removal
            }
        }
        System.out.println("Item not found in cart.");  // Optional: Add user feedback
    }

    /**
     * Calculates total cost of all cart items.
     *
     * @return Total cost (sum of all item subtotals)
     */
    public double calculate_total_cost() {
        double totalCost = 0.0;     // Initialize accumulator for total cost

        // Iterate through all valid CartItem objects in the items array
        // Loop runs from index 0 to itemCount-1 (inclusive)
        for (int i = 0; i < itemCount; i++) {
            // Accumulate the subtotal of each CartItem
            // get_subtotal() returns: product.getPrice() * quantity
            totalCost += items[i].get_subtotal();
        }
        return totalCost;       // Return the computed total cost
    }

    /**
     * Calculates total weight of all cart items.
     *
     * @return Total weight in KG (sum of all item weights)
     */
    public double calculate_total_weight() {
        double totalWeight = 0.0;       // Initialize accumulator for total weight

        // Iterate through all valid items in the cart (from index 0 to itemCount-1)
        for (int i = 0; i < itemCount; i++) {
            // Add the total weight of current CartItem to running total
            // get_ItemTotalWeight() returns: product.getWeight() * quantity
            totalWeight += items[i].get_ItemTotalWeight();
        }
        return totalWeight;     // Return the computed total weight
    }

    /**
     * Shows everything in the shopping cart UPDATE: Could be enhanced with more
     * details from Code 1
     */
    public void showCart() {
        if (itemCount == 0) {
            System.out.println("Empty cart");
            return;
        }

        System.out.println("Shopping Cart");
        for (int i = 0; i < itemCount; i++) {
            CartItem item = items[i];
            System.out.println((i + 1) + ". " + item.getProduct().getName()
                    + " x" + item.getQuantity()
                    + " = $" + String.format("%.2f", item.get_subtotal()));
        }
        System.out.println("");
        System.out.println("Total Items: " + itemCount);
        System.out.println("Total Cost: $" + String.format("%.2f", calculate_total_cost()));
        System.out.println("Total Weight: " + String.format("%.2f", calculate_total_weight()) + " kg");
        System.out.println("");
    }

    /**
     * Updates stock quantities after purchase. This ensures inventory
     * management is maintained.
     */
    public void updateStockAfterPurchase() {
        for (int i = 0; i < itemCount; i++) {
            CartItem currentItem = items[i];
            Product product = currentItem.getProduct();

            int quantityBought = currentItem.getQuantity();
            int currentStock = product.getStock_quantity();
            int newStock = currentStock - quantityBought;
            product.setStock_quantity(newStock);
        }
    }

    /**
     * Clears all items from the cart. Resets to initial state.
     */
    public void clearCart() {
        // Alternative: Could use Arrays.fill(items, null) for explicit clearing
        items = new CartItem[10];
        itemCount = 0;
        System.out.println("Cart cleared successfully.");
    }

    /**
     * NEW OPTIONAL METHOD: Enhanced remove with quantity (from Code 1) Allows
     * removing specific quantity instead of entire item.
     *
     * @param product_id ID of product to remove
     * @param quantity Quantity to remove (if less than cart quantity, reduces
     * it)
     */
    public void remove_item_with_quantity(int product_id, int quantity) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getProduct().getProduct_id() == product_id) {
                int currentQty = items[i].getQuantity();

                if (quantity >= currentQty) {
                    // Remove entire item
                    remove_item(product_id);
                    System.out.println("Item removed completely.");
                } else {
                    // Reduce quantity
                    items[i].setQuantity(currentQty - quantity);
                    System.out.println("Quantity reduced. Remaining: " + items[i].getQuantity());
                }
                return;
            }
        }
        System.out.println("Product not found in cart.");
    }
}
