package org.example;

public class Cash extends Payment {
    private float cash; //Amount of cash given
    private float change; //Amount of change due

    public Cash (float amount, float cash) {    //amount : the mount that needs to be paid
        super (amount);
        this.cash = cash;
    }

    public boolean deductAmount() {
        change = cash - getAmount();
        return (change >=0);
    }

    public void displayMessage () {     //check cash larger than or equal due amount
        if (change >=0)
            {   System.out.println("You paid: " + cash + " and required amount is: " + getAmount() + " and the change is : "+ deductAmount());
                System.out.println("Successful Cash Payment");}
        else
            {  System.out.println("You paid: " + cash + " but required amount is: " + getAmount());
                System.out.println("Unsuccessful Cash Payment");}
        }
}
