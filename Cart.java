package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    private Product product;
    private double productTotal;
    private int quantity;
    private ArrayList<Cart> itemDetails = new ArrayList<Cart>();
    private int cartId;
    public Cart(){}
    public Cart(Product product, int quantity) {
        this.product  = product;
        this.quantity = quantity;
    }
    public String getCart () {
        return product + "Quantity: " + quantity + "\n";
    }
    public Cart(int id){
        this.cartId = id;
    }
    
    // add items to cart
    public void addItemDetail (Product product, int quantity) {    
        Product p = new Product();
        itemDetails.add(new Cart(product, quantity));
    }


    public double getTotal(float taxPercentage) {   //calculates the cost of this amount of this product
        //taxPercentage is the applicable tax %
        if (product == null)
            productTotal = 0;
        else {
            productTotal = product.calcTotal(quantity); //calcTotal: qunatity * unit price
            productTotal *= (1 + (taxPercentage/100));
        }
        //return the cost of this amount of the product
        return productTotal;
    }


// view cart items
    public void viewCart(){
        System.out.println("----------The Cart------------");
        for(Cart item :itemDetails) {
            System.out.println(item.getCart());
        }
        System.out.println("--------------------------------");
    }

    public void removeItem(String productCode) {
        for (int i = 0; i < itemDetails.size(); i++) {
            if (itemDetails.get(i).product.getCode().equals(productCode)) {
                itemDetails.remove(i);
                System.out.println("Item removed from cart" );
            }
        }
        System.out.println("Item not found in cart\n");
    }


}
