/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author [lamees & sadeel]
 */
import java.util.*;

public class StoreMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Welcoming message for our beauty store
        System.out.println("==================================================");
        System.out.println("           WELCOME TO S&L BEAUTY STORE            ");
        System.out.println("==================================================");
        System.out.println();
        System.out.println("Your premier destination for luxurious international");
        System.out.println("cosmetisc at competitive prices. We offer an exquisite");
        System.out.println("collection of authentic products that combine superior");
        System.out.println("quality with the luxury you deserve.");
        System.out.println();
        System.out.println("We strive to make beauty accessible with exclusive offers");
        System.out.println("and premium service, ensuring safe shopping and fast,");
        System.out.println("secure delivery to your doorstep.");
        System.out.println("===================================================");

        //Our beautiful collection of products
        Product[] products = new Product[10];
        products[0] = new Product(1, "Luxury Matte Lipstick", 29.99, 50, 0.1);
        products[1] = new Product(2, "12-Color Eyeshadow Palette", 45.50, 30, 0.3);
        products[2] = new Product(3, "Vitamin C Serum", 39.99, 40, 0.2);
        products[3] = new Product(4, "Lengthening Mascara", 24.99, 60, 0.15);
        products[4] = new Product(5, "Hyaluronic Acid Cream", 49.99, 35, 0.25);
        products[5] = new Product(6, "24-Color Eyeshadow Palette", 99.99, 30, 0.6);
        products[6] = new Product(7, "Niacinamide Serum", 34.99, 45, 0.18);
        products[7] = new Product(8, "Volumizing Mascara", 27.99, 55, 0.17);
        products[8] = new Product(9, "Brow Defining Palette", 19.99, 30, 0.2);
        products[9] = new Product(10, "Retinol Night Serum", 59.99, 25, 0.22);

        //Customer's shopping cart - starts empty
        Cart cart = new Cart();

        //Infinite shopping loop - shop till you drop!
        do {
            System.out.println("==================================================");
            System.out.println("=================== MAIN MENU ====================");
            System.out.println("1. View Best Sellers");
            System.out.println("2. View All Products");
            System.out.println("3. View Cart");
            System.out.println("4. Add/Update Item");
            System.out.println("5. Remove Item");
            System.out.print("Enter your choice (1-5) : ");
            int num = sc.nextInt();

            switch (num) {
                case 1:
                    System.out.println("Our Best Sellers!!");
                    System.out.println("==================================================");
                    printProducts(products, 4);
                    System.out.println("==================================================");
                    break;

                case 2:
                    System.out.println("ALL PRODUCTS CATALOG️");
                    System.out.println("==================================================");
                    printProducts(products, products.length);
                    System.out.println("==================================================");
                    break;

                case 3:
                    System.out.println("YOUR SHOPPING CART");
                    System.out.println("==================================================");
                    cart.printCart();
                    if (cart.getCount() != 0) {
                        System.out.println("==================================================");
                        System.out.println("Do you want to confirm your purchases? (1 for YES / 0 for NO)");
                        int x = sc.nextInt();
                        if (x == 0) {
                            break;
                        } else {
                            System.out.println("Please enter your destination address : ");
                            String destination_address = sc.next();
                            Shipping shipping;
                            Order order;

                            System.out.println("The available shipping method according to the wieght : ");
                            if (cart.calculate_total_weight() <= 7) {
                                System.out.println(cart.calculate_total_weight() + "KG, could use\n[1] Ground Shipping\n[2] Air Shipping\n[3] Express Shipping");
                                System.out.println("Please choose the shipping method (USE NUMBERS) : ");
                                int sh = sc.nextInt();
                                switch (sh) {
                                    case 1:
                                        shipping = new GroundShipping(destination_address, 10);
                                        order = new Order(cart, shipping);
                                        order.Checkout();
                                        System.out.println(order.genrate_invoice());
                                        cart.clearCart();
                                        cart.updateStockAfterPurchase();
                                        break;

                                    case 2:
                                        shipping = new AirShipping(destination_address, 10);
                                        order = new Order(cart, shipping);
                                        order.Checkout();
                                        System.out.println(order.genrate_invoice());
                                        cart.clearCart();
                                        cart.updateStockAfterPurchase();
                                        break;

                                    case 3:
                                        shipping = new ExpressShipping(destination_address, 10);
                                        order = new Order(cart, shipping);
                                        order.Checkout();
                                        System.out.println(order.genrate_invoice());
                                        cart.clearCart();
                                        cart.updateStockAfterPurchase();
                                        break;

                                    default:
                                        System.out.println("Invalid Value!");

                                }
                            } else if (cart.calculate_total_weight() > 7 && cart.calculate_total_weight() < 50) {
                                System.out.println(cart.calculate_total_weight() + "KG, could use\n[1] Air Shipping\n[2] Express Shipping");
                                System.out.println("Please choose the shipping method (USE NUMBERS) : ");
                                int sh = sc.nextInt();
                                switch (sh) {

                                    case 1:
                                        shipping = new AirShipping(destination_address, 10);
                                        order = new Order(cart, shipping);
                                        order.Checkout();
                                        System.out.println(order.genrate_invoice());
                                        cart.clearCart();
                                        cart.updateStockAfterPurchase();
                                        break;

                                    case 2:
                                        shipping = new ExpressShipping(destination_address, 10);
                                        order = new Order(cart, shipping);
                                        order.Checkout();
                                        System.out.println(order.genrate_invoice());
                                        cart.clearCart();
                                        cart.updateStockAfterPurchase();
                                        break;

                                    default:
                                        System.out.println("Invalid Value!");

                                }
                            } else {
                                System.out.println(cart.calculate_total_weight() + "KG, Express Shipping");
                                shipping = new ExpressShipping(destination_address, 10);
                                order = new Order(cart, shipping);
                                order.Checkout();
                                System.out.println(order.genrate_invoice());
                                cart.clearCart();
                                cart.updateStockAfterPurchase();
                            }

                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.println("ADD/UPDATE ITEM");
                    System.out.println("==================================================");
                    printProducts(products, products.length);
                    System.out.println("Enter the ID to the product you want to add to your cart (Enter 0 to cancel) : ");
                    int id = sc.nextInt();
                    if (id == 0) {
                        break;
                    } else {
                        System.out.println("Enter the QUANTITY of the product you want to add to your cart : ");
                        int q = sc.nextInt();
                        Product p = products[id - 1];
                        cart.add_item(p, q);
                        System.out.println("DONE!");
                        System.out.println("==================================================");
                    }
                    break;

                case 5:
                    System.out.println("REMOVE ITEM");
                    System.out.println("==================================================");
                    cart.printCart();
                    if (cart.getCount() == 0) {
                        System.out.println("There is no products to remove!");
                    } else {
                        System.out.println("Enter the ID to the product you want to remove from your cart (Enter 0 to cancel) : ");
                        id = sc.nextInt();
                        if (id == 0) {
                            break;
                        } else {
                            System.out.print("Enter quantity to remove: ");
                            int q = sc.nextInt();
                            cart.remove_item(id, q);
                            System.out.println("DONE!");
                            System.out.println("==================================================");
                        }
                    }
                    break;

                default:
                    System.out.println("Invalid Value!");
            }
        } while (true);

    }

    public static void printProducts(Product[] list, int num) {
        for (int i = 0; i < num; i++) {
            System.out.println("[" + (i + 1) + "] " + list[i].getName() + " " + list[i].getPrice() + '$');
        }
    }
}
