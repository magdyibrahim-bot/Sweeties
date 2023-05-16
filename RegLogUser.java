package org.example;

import java.util.Scanner;
public class RegLogUser{
    private Scanner input = new Scanner(System.in);
    private String options ;
    private String name , email , password;


    public boolean Run()
    {
        boolean flag = true;
        while(flag)
        {
            System.out.println("Plz Enter (l) if u want to login and (r) if u want to regester..");
            options = input.next();
            if (options.contentEquals("l")){
                System.out.println("PLz Enter your email :");
                email = input.next();

                System.out.println("PLz Enter your password :");
                password = input.next();

                Login login = new Login(email, password);
                login.execution();
            }
            else if (options.contentEquals("r")){                
                System.out.println("PLz Enter your name :");
                name = input.next();

                System.out.println("PLz Enter your email :");
                email = input.next();

                System.out.println("PLz Enter your password :");
                password = input.next();

                Register register = new Register(name, email, password);
                register.execution();

            }
            else{
                int choice;
                System.out.println("""
                        you Enter Something Wrong
                        Please, try Again or Exit.
                        1.try Again
                        2.Exit""");
                choice = input.nextInt();
                switch (choice){
                    case 1:
                        Run();
                        break;
                    case 2:
                        flag =false;
                        break;
                }
            }
            break;
        }
        return flag;
    }
}