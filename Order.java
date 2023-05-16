package org.example;

import java.util.*;
import java.util.ArrayList;

public class Order {
    private OrderStatus status = OrderStatus.OPEN;
    private float orderTotal;
    private String deliveryAddress;     //the address where order is delivered
    private Payment payment;           //Order payment can be in cash or credit
    private ArrayList<Cart> orderDetails = new ArrayList<Cart>();
    private float taxPercentage;    // Rate of tax applicable to this order as xx%
    private int orderID;

    public Order(){}

    public Order(float taxPercentage, String deliveryAddress, int ID) {     // requires tax rate applicabl to the order
        this.taxPercentage = taxPercentage;
        this.deliveryAddress = deliveryAddress;
        this.orderID = ID;
    }
    public int getOrderID () {
            return orderID;
        }
    public OrderStatus getStatus () {
            return status;
        }
    public float calculateOrderTotal() {    //calculates the total of the order from the order details
            orderTotal = 0;
            Iterator<Cart> i = orderDetails.iterator();
            while (i.hasNext())                                      //.hasNext : Returns true if the iteration has more elements
                orderTotal += (i.next()).getTotal(taxPercentage);   //.next : Returns the next element in the iteration.
            return orderTotal;
    }
    public void addOrderDetail (Product product, int quantity) {    //Add item to list
            if (status == OrderStatus.OPEN)
                orderDetails.add(new Cart(product, quantity));
            else
                System.out.println("You cannot added items to a closed order");
    }

    public boolean payOrder (Payment payment) {
        if (status == OrderStatus.CLOSED) {
            System.out.println("Order is already paid for");
            return true;
        }
        else {
            boolean paidOrder = payment.settlePayment ();
            if (paidOrder == true)
                status = OrderStatus.CLOSED;
            return paidOrder;
        }
    }

}
