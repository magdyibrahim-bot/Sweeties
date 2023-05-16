package org.example;

import java.util.ArrayList;
public class Database{
    private static ArrayList<User> ArrayOfUsers = new ArrayList<User>();
    static{
        ArrayOfUsers.add(new User("User1" , "User1@gmail.com","xx1"));
        ArrayOfUsers.add(new User("User2" , "User2@gmail.com","xx2"));
        ArrayOfUsers.add(new User("User3" , "User3@gmail.com","xx3"));
        ArrayOfUsers.add(new User("User4" , "User4@gmail.com","xx4"));
        ArrayOfUsers.add(new User("User5" , "User5@gmail.com","xx5"));
    }
    public boolean IsUserRegistered(String email , String password){
        boolean flag = false;
        for(User i : ArrayOfUsers){
            if(i.getEmail().equals(email) && i.getPassword().equals(password)){
                flag = true;
            }
        }
        return flag;
    }
    public User getUser(String email , String password){
        User newUser = new User();
        for(User i :ArrayOfUsers){
            if(i.getEmail().equals(email) && i.getPassword().equals(password)){
                newUser = i;
            }
        }
        return newUser;
    }
    public void AddToDatabase(User newUser){
        ArrayOfUsers.add(newUser);
    }
}