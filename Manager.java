package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    Scanner input = new Scanner(System.in);
    //Catalog.
    private static final ArrayList<Product> ArrayOfProducts = new ArrayList<Product>();
    //List with All orders.
    private static ArrayList<Order>  ArrayOforders = new ArrayList<Order>();
    private static ArrayList<Cart> arrayOfCarts = new ArrayList<Cart>();
    private int orderIDGenerator;
    private int cartIDGenerator;
    //Put Default products in Store.
    static{
        ArrayOfProducts.add(new Product("1" , "Cupcake  ", 15));
        ArrayOfProducts.add(new Product("2" , "Cake     ", 200));
        ArrayOfProducts.add(new Product("3" , "Cinnamon ", 100));

    }
    //Constructor
    public Manager(){

    }
    //add Product to Catalog.
    public void addToStore(Product product){
        ArrayOfProducts.add(product);
    }
    //Search for a product by Specific ID.
    public Product searchOnProduct(String productCode){
        Product prd = new Product();
        for(Product i :ArrayOfProducts) {
            if(i.getCode().contentEquals(productCode)) {
                prd = i;
                break;
            }
        }
        return prd;
    }
    //Display All product in Catalog.
    public void viewCatalog(){
        System.out.println("\t<<Toffee Catalog>>");
        System.out.println(" ");
        for(Product product :ArrayOfProducts){
            System.out.println("\t" +product.getName() + " " +product.getCode() +" " +product.getUnitPrice());
        }
    }
    //Remove a product with a specific ID.
    public void removeProduct(String productCode){
        int choice;
        System.out.println(searchOnProduct(productCode));
        Product obj = searchOnProduct(productCode);

        System.out.println("1.Confirm Remove.\n2.Dis-confirm Remove.\nSelect what you want: ");
        choice = input.nextInt();

        switch(choice){
            case 1:
                if(obj!=null){
                    ArrayOfProducts.remove(obj);
                    System.out.println("This is the New Catalog\n");
                    viewCatalog();
                }
                break;
            case 2:
                break;
            default:
                System.out.println("Wrong Choice");
                removeProduct(productCode);
        }
    }
    public void addProductToOrder (int orderID, String productCode, int quantity) {
        Order order = getOrder(orderID);
        order.addOrderDetail(searchOnProduct(productCode), quantity);
    }
    public int createOrder (float taxPercentage, String deliveryAddress) {
        ++orderIDGenerator;
        Order order = new Order(taxPercentage , deliveryAddress , orderIDGenerator);
        ArrayOforders.add(order);
        return orderIDGenerator;
    }
    public Order getOrder(int orderID){
        Order newOrder = new Order();
        for(Order i :ArrayOforders){
            if(i.getOrderID() == orderID){
                newOrder = i;
                break;
            }
        }
        return newOrder;
    }

}