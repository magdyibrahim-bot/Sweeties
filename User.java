package org.example;

public class User{
    private String UserName ;
    private String Email;
    private String Password;

    public User(){}

    public User(String UserName , String Email ,String Password){
        this.Email = Email;
        this.Password = Password;
        this.UserName = UserName;
    }

    
    public String getEmail() {
        return Email;
    }
    
    public String getPassword() {
        return Password;
    }
    
    public String getName() {
        return UserName;
    }
}