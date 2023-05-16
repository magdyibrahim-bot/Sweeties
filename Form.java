package org.example;

public abstract class Form{
    private String UserEmail ;
    private String UserPassword ;
    private Database database ;
    public Form(String UserEmail , String UserPassword){
        this.UserEmail = UserEmail;
        this.UserPassword = UserPassword;
        database = new Database();
    }
    public String getUserPassword(){
        return UserPassword;
    }
    public String getUserEmail(){
        return UserEmail;
    }
    public Database getDatabase(){
        return database;
    }
    public abstract void execution();
}