package org.example;
import java.util.Scanner;
import java.util.Objects;

public class Register extends Form{
    private String name;
    private final OTPGenerator verfiy = new OTPGenerator();
    private String otp;
    private String input;

    Scanner in = new Scanner(System.in);
    public Register(String name, String email, String password) {
        super(email, password);
        this.name = name;
    }
    public String getName() {return this.name;}

    @Override
    public void execution() {
        if(getDatabase().IsUserRegistered(getUserEmail(), getUserPassword())){
            System.out.println( "Sorry ,This user already exists.");
        }
        else
        {
            User newUser = new User(getName(), getUserEmail(), getUserPassword());
            otp = verfiy.generateOTP();
            verfiy.sendOTPByEmail(getUserEmail(),otp);
            System.out.println("Please,Enter The OTP Number That Send to your Email: ");
            input = in.nextLine();
            if(Objects.equals(input, otp)){
                System.out.println( "successfully registered!");
            }else{
                System.out.println("Wrong OTP!");
                execution();
            }
            getDatabase().AddToDatabase(newUser);
            System.out.println("hello " + newUser.getName() );
        }
    }
}