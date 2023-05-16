package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello to Sweety Website." +
                "\n Please,login if you have Account or Register for new Account.");

        second(first());
    }

    public static boolean first() {
        RegLogUser system = new RegLogUser();
        boolean flag;
        if(system.Run()){
            flag = true;
        }
        else{
            flag = false;
        }
        return flag;
    }


    public static void second(boolean flag) {
        Scanner input = new Scanner(System.in);

        Manager store = new Manager();
        Cart cart = new Cart();

        int choice, orderID=0, quantity,q;
        float orderTotal=0, taxPercentage=0, cash_1;
        String address="", productCode,c;

        if(flag) {
            System.out.println("""
                    1.View Catalog.\s
                    2.Search on Product.
                    3.Make Order and Pay for it.
                    Choice what you want to do:\s""");
            choice = input.nextInt();


            if (choice == 1) {
                store.viewCatalog();
            } else if (choice == 2) {
                String code;
                code = input.nextLine();
                System.out.println(store.searchOnProduct(code));
            } else if (choice == 3) {
                
                //add item to cart
                Integer addMore = 1;
                float price;
                while (addMore == 1) {
                    System.out.print("product id : ");
                    c = input.next();

                    System.out.print("Quantity : ");
                    q = input.nextInt();
                    System.out.println("To add more items press 1 \nIf not, press 0 ");
                    addMore = input.nextInt();


                    cart.addItemDetail(store.searchOnProduct(c), q);

                    orderID = store.createOrder(taxPercentage, address);
                    store.addProductToOrder(orderID, c, q);
                    orderTotal += store.getOrder(orderID).calculateOrderTotal();

                }
                cart.viewCart();
                System.out.println("Enter The address to deliver to : ");
                address = input.next();
                System.out.println("Enter the tax Percentage: ");
                taxPercentage = input.nextInt();

                orderID = store.createOrder(taxPercentage, address);
                System.out.println("The cash you must pay = " + orderTotal);
                System.out.println("Please enter cash to pay for your order: ");
                cash_1 = input.nextFloat();

                Payment payment1_1 = new Cash(orderTotal, cash_1);
                store.getOrder(orderID).payOrder(payment1_1);

            } else {
                System.out.println("Invalid Choice" +
                        "please, enter Again.");
                second(first());

            }
            int repeat;
            System.out.println("Do you want to do other thing");
            System.out.println("1.yes " +
                    "2.no ");
            repeat = input.nextInt();
            if (repeat == 1) {
                second(first());
            }
        }
    }
}
