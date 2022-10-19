import java.util.Scanner;

public class BankingApplication{
    public static void main(String[] args) {
        BankAccount ba=new BankAccount();
        ba.start();
    }
}
 class ShowOption {
    void showOption() {
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. previous transaction");
        System.out.println("5. Exit");
    }
}
 class BankAccount extends Thread {
     int balance;
     int previousTransaction;
     String customerName;
     String customerId;
     ShowOption so= new ShowOption();

     void deposit(int amount) {
         if ( amount > 0) {
             balance = balance + amount;
             previousTransaction = amount;
         }
         else {
             System.out.println("Invalid Input");
         }
     }

     void withdraw(int amount) {
         if (amount <= balance && amount > 0) {
             balance = balance - amount;
             previousTransaction = -amount;
         }
         else if (amount < 0){
             System.out.println("Enter a natural number");
         }
         else {
             System.out.println("Sorry your balance is low");
         }
     }

     void getPreviousTransaction() {
         if (previousTransaction > 0) {
             System.out.println("Deposit: " + previousTransaction);
         } else if (previousTransaction < 0) {
             System.out.println("Withdrawn: " + Math.abs(previousTransaction));
         } else {
             System.out.println("No transaction occured");
         }
     }

    public void run() {
         char option ;
         Scanner scanner = new Scanner(System.in);
         System.out.println("   ");
         System.out.println("Enter your name: ");
         customerName=scanner.nextLine();
         System.out.println("Enter your ID: ");
         customerId=scanner.next();

         try{
             System.out.println("   ");
             System.out.println("   ");
             System.out.print("Loading");
             Thread.sleep(1200);
             System.out.print(".");
             Thread.sleep(1200);
             System.out.print(".");
             Thread.sleep(1200);
             System.out.println(".");
             Thread.sleep(1200);

         }
         catch(Exception e){
             System.out.println();
         }

         System.out.println("Welcome " + customerName);
         System.out.println("your ID is " + customerId);
         System.out.println("\n");
         so.showOption();


         do {
             System.out.println("**********************************************");
             System.out.println("Enter an option");
             System.out.println("**********************************************");
             option = scanner.next().charAt(0);
             System.out.println("\n");

             switch (option) {
                 case '1' -> {
                     System.out.println("--------------------------------");
                     System.out.println("Balance = " + balance);
                     System.out.println("--------------------------------");
                     System.out.println("\n");
                     so.showOption();
                 }
                 case '2' -> {
                     System.out.println("--------------------------------");
                     System.out.println("Enter an amount to deposit");
                     System.out.println("--------------------------------");
                     int amount = scanner.nextInt();
                     deposit(amount);
                     System.out.println("\n");
                     so.showOption();
                 }
                 case '3' -> {
                     System.out.println("--------------------------------");
                     System.out.println("Enter an amount to withdraw");
                     System.out.println("--------------------------------");
                     int amount2 = scanner.nextInt();
                     withdraw(amount2);
                     System.out.println("\n");
                     so.showOption();
                 }
                 case '4' -> {
                     System.out.println("--------------------------------");
                     getPreviousTransaction();
                     System.out.println("--------------------------------");
                     System.out.println("\n");
                     so.showOption();
                 }
                 case '5' -> System.out.println("*****************************");
                 default -> System.out.println("Invalid option!!.Please enter again");
             }
         }while (option != '5');
         System.out.println("Thanks for using our service");
     }
 }