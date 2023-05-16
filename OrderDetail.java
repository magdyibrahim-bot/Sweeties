package org.example;

public class OrderDetail {
    private Product product;        //the kind of product purchased
    private double productTotal;    //cached value of this order detail
    private int quantity;

    
    public OrderDetail(Product product, int quantity) {
        this.product  = product;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString () {
        return product + "Quantity: " + quantity + "\n"; 
    }
}
