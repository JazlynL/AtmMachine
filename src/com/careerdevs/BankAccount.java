package com.careerdevs;

import java.util.Locale;
import java.util.Scanner;
import java.lang.Character;
public class BankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    public BankAccount() {
    }


     BankAccount(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }



    void deposit(int amount){
        if(amount > 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }
    void withdrawal(int amount){
        if (amount > 0 ){
            balance = balance - amount;
            previousTransaction =- amount;
        }else {
            System.out.println("Cant take out more than the amount that's in account.");
        }
    }

    void getPreviousTransaction(){
        if(previousTransaction > 0){
            System.out.println("Deposited today: $"+ previousTransaction);
        }else{
            System.out.println("No transaction was placed.");
        }
    }

    public String menuDecor(){
        return "-_".repeat(15);
    }
    void showMenu() {

        // we set it to 0 to eventually
        char option = '\0';
        Scanner newScan = new Scanner(System.in);



        System.out.println("Welcome to People's Bank \n Your id is: " + customerId);
        System.out.println("A.) Check Balance\n");
        System.out.println("B.) Deposit Money\n");
        System.out.println("C.) Withdraw Money\n");
        System.out.println("D.)  Previous transaction\n");
        System.out.println("E.) Exit");

        // how to access the char using Scanner class;

     do {
         System.out.println(" Choose an option , You want today\n");
         option = newScan.next().charAt(0);
         char c = Character.toLowerCase(option);



         switch (c) {
             case 'A':
                 System.out.println(menuDecor() + "\n This is your bank Account Balance.");
                 System.out.println("Balance: " + balance);
                 System.out.println(menuDecor());
                 break;

             case 'B':
                 System.out.println(menuDecor());
                 System.out.println("Amount you would like to deposit: ");
                 int depositAmount = newScan.nextInt();
                 deposit(Integer.parseInt(depositAmount + "\n"));
                 System.out.println(menuDecor());
                 break;

             case 'C':
                 System.out.println(menuDecor() + "\n Amount you would like to withdraw: ");
                 int withdrawAmount = newScan.nextInt();
                 withdrawal(withdrawAmount);
                 System.out.println(menuDecor());
                 break;
             case 'D':
                 System.out.println(menuDecor() + "\nThis is your previous transaction: ");
                 getPreviousTransaction();
                 System.out.println(menuDecor());
                 break;

             case 'E':
                 System.out.println("Goodbye");
         }

     }
     while (option != 'E') ;{
            System.out.println(" Thank you for Choosing the Peoples Bank");
        }
    }
}
