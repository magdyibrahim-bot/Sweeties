package org.example;

public class Login extends Form{
    public Login(String email , String Password)
    {
        super(email, Password);
    }
    @Override
    public void execution() {
            if(getDatabase().IsUserRegistered(getUserEmail(), getUserPassword())){
                User newUser = getDatabase().getUser(getUserEmail(), getUserPassword());
                System.out.println( "Logged in successfully !");
                System.out.println("hello " + newUser.getName() );
            }        
            else {
                System.out.println("User is not registered");
            }
    }
}