package org.example;

public abstract class Payment {
    private float amount;   //the mount that needs to be paid

    public Payment (float amount) {
        this.amount = amount;
    }

    public float getAmount () {
        return amount;
    }

    //A template method for making a payment
    public boolean settlePayment (){
        boolean successfulPayment = deductAmount();
        displayMessage ();
        return successfulPayment;
    }

    public abstract boolean deductAmount ();
    public abstract void displayMessage ();
}