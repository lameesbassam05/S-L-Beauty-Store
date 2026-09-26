/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author [lamees & sadeel]
 */
public class Order {

    // Attributes
    private Cart cart;                  // Shopping cart with customer items
    private Shipping shipping_method;   // Chosen shipping method

    // Constructors
    public Order() {
        // Empty constructor for flexibility
    }

    /**
     * Creates order with specific cart and shipping
     *
     * @param cart Customer's shopping cart
     * @param shipping_method Chosen shipping method
     */
    public Order(Cart cart, Shipping shipping_method) {
        this.cart = cart;
        this.shipping_method = shipping_method;
    }

    /**
     * Completes purchase by validating order details
     *
     * @return true if checkout successful, false otherwise
     */
    public boolean Checkout() {

        if (cart == null) {
            System.out.println("There is no cart!");
            return false;
        }

        if (cart.getItemCount() == 0) {
            System.out.println("The cart is empty");
            return false;
        }

        if (shipping_method == null) {
            System.out.println("You did not enter a shipping method");
            return false;
        }

        // Weight validation for each shipping type
        double totalWeight = cart.calculate_total_weight();
        // 1. Check Ground Shipping
        if (shipping_method instanceof GroundShipping) {
            if (totalWeight <= 7) {
                System.out.println(totalWeight + "KG, The weight is ideal for ground shipping");
            } else {
                System.out.println(totalWeight + "KG, The weight is too heavy for ground shipping");
                System.out.println("Suggested solutions:");
                System.out.println("   - Choose air shipping (up to 50KG)");
                System.out.println("   - Choose express shipping (any weight)");
                return false;
            }
        } // 2. Check Air Shipping
        else if (shipping_method instanceof AirShipping) {
            if (totalWeight <= 50) {
                System.out.println(totalWeight + "KG, The weight is suitable for air shipping");
            } else {
                System.out.println(totalWeight + "KG, The weight is too heavy for air shipping");
                System.out.println("Solution: Choose express shipping (accepts any weight)");
                return false;
            }
        } // 3. Check Express Shipping
        else if (shipping_method instanceof ExpressShipping) {
            System.out.println("You chose express shipping (fastest delivery)");

            if (totalWeight <= 7) {
                System.out.println("Note: Weight " + totalWeight + "KG, could use cheaper ground shipping");
            } else if (totalWeight <= 50) {
                System.out.println("Note: Weight " + totalWeight + "KG, could use cheaper air shipping");
            } else {
                System.out.println("Weight " + totalWeight + "KG, - Express shipping is the only option");
            }
        }

        System.out.println("Check out Sucessful");

        cart.updateStockAfterPurchase();
        cart.clearCart();

        return true;
    }

    /**
     * Generates final invoice with all costs and delivery information
     *
     * @return Formatted invoice as string
     */
    public String generate_invoice() {

        if (cart == null) {
            return "There is no cart!";
        }

        if (shipping_method == null) {
            return "You did not enter a shipping method";
        }

        double grandTotal = cart.calculate_total_cost()
                + shipping_method.calculate_cost(cart.calculate_total_weight());

        return "The Subtotal is : " + cart.calculate_total_cost()
                + "\nThe Shipping fee is : " + shipping_method.calculate_cost(cart.calculate_total_weight())
                + "\nThe Grand Total is : " + grandTotal
                + "\nThe Delivery Time is : " + shipping_method.calculate_delivery_time()
                + "\nHAPPY SHOPPING!";

    }

    //Getters && Setters
    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Shipping getShipping_method() {
        return shipping_method;
    }

    public void setShipping_method(Shipping shipping_method) {
        this.shipping_method = shipping_method;
    }

}
