package com.careerdevs;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

public class BankAccount {
    static int balance;
    static int previousTransaction;
    String customerName;
    int customerId;

    public BankAccount() {
    }


     BankAccount(String customerName, int customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }



    static void deposit(int amount){
        if(amount > 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }
    static void withdrawal(int amount){
        if (amount > 0 ){
            balance = balance - amount;
            previousTransaction =- amount;
        }else {
            System.out.println("Cant take out more than the amount that's in account.");
        }
    }

    static void getPreviousTransaction(){
        if(previousTransaction > 0){
            System.out.println("Deposited today: $"+ previousTransaction);
        }else{
            System.out.println("No transaction was placed.");
        }
    }

    static String menuDecor(){
        return "-_".repeat(15);
    }
   static String moneyFormatter(int balance)
    {
        String currencyInstance = NumberFormat.getCurrencyInstance(Locale.US).format(balance);
        return currencyInstance;
    }


   public static void showMenu() {

        // we set it to 0 to eventually
        char option = '\0';
        Scanner newScan = new Scanner(System.in);




        System.out.println("Welcome to People's Bank \n Enter your Name: " );
       String CustomerName = newScan.nextLine().toUpperCase();
       System.out.println("Enter your Id: ");
       int customerID = newScan.nextInt();


        System.out.println( "This is your Name: " + CustomerName);
        System.out.println("This is your Id: " + customerID );

        //BankAccount obj1 = new BankAccount(CustomerName,customerID);


        // how to access the char using Scanner class;




     do {
         System.out.println("A.) Check Balance");
         System.out.println("B.) Deposit Money");
         System.out.println("C.) Withdraw Money");
         System.out.println("D.)  Previous transaction");
         System.out.println("E.) Exit");

         System.out.println(menuDecor()+ " \n Choose an option , You want today \n"+ menuDecor());
         option = newScan.next().charAt(0);




         switch (option) {
             case 'A':
                 System.out.println(menuDecor() + "\n This is your bank Account Balance.");
                 System.out.printf("Balance:" + moneyFormatter(balance) + "\n");
                 System.out.println(menuDecor());
                 break;

             case 'B':
                 System.out.println(menuDecor());
                 System.out.println("Amount you would like to deposit: ");
                 long depositAmount = newScan.nextInt();
                 deposit((int) depositAmount);
                 System.out.println("This is your new amount: " +  moneyFormatter(balance));
                 System.out.println(menuDecor());
                 break;

             case 'C':
                 System.out.println(menuDecor() + "\n Amount you would like to withdraw: ");
                 int withdrawAmount = newScan.nextInt();
                 withdrawal(withdrawAmount);
                 System.out.println("You withdrew: "+ moneyFormatter(withdrawAmount));
                 System.out.println(menuDecor());
                 break;
             case 'D':
                 System.out.println(menuDecor() + "\nThis is your previous transaction: " +moneyFormatter(previousTransaction));
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
