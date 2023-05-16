package org.example;

public class Product {
    private String code;
    private String name;
    private float unitPrice;

    Product(){}

    public Product(String code, String name, float unitPrice) {
        this.code   = code;
        this.name   = name;
        this.unitPrice = unitPrice;
    }

    
    public double calcTotal(int quantity) {
        return (unitPrice * quantity);
    }

    public String getCode(){
        return code;
    }

    public String getName(){
        return name;
    }

    public float getUnitPrice(){
        return unitPrice;
    }

    public String toString () {
        return ("Name: " + name + " - Code: " 
                + code + " - Price: " + unitPrice + "  ");
    } 
}
