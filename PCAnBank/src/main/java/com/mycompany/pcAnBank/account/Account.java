package com.mycompany.andresgarcia192229.account;
import com.mycompany.andresgarcia192229.logs.AccountLogs;

public class Account {
    String ID;
    double currentLoan;
    double money;
    double interestBenefit;

    public Account(String ID, double money) {
        this.ID = ID;
        this.money = money;
        this.currentLoan = 0;  //préstamo actual, inicializado en cero 
        this.interestBenefit = 0.05;
    }
    
    protected void approveLoan(double amount) {   //método para aprobar o no el crédito 
        this.currentLoan = amount;   //monto      
        System.out.println("Approved loan of $"+amount);
    }

    public void depositMoney(double amount) {
        if (amount > 0) {
            this.money = this.money + amount;
            System.out.println("Successfully deposited $"+amount);
            System.out.println("Your account now has $"+this.money);
            return;
        }
        System.out.println("Please enter a positive value");
    }
    
    public void withdrawMoney(double amount) throws Exception {   //método para retirar 
        if (amount > this.money) {
            throw new Exception("You are withdrawing more than you have");
        }
        else {
            if (amount > 0) {
                this.money = this.money - amount;
                System.out.println("Successfully withdrew $"+amount);
                System.out.println("Your account now has $"+this.money);
                return;
            }
            System.out.println("Please enter a positive value");
        }
    }

    protected void initializeAccount(String ID, double money, AccountLogs database) throws Exception {   //revisar 
        if (money < 10000) {
            throw new Exception("Not enough money to initialize an account. (money < 10000)");
        }
        else {
            this.ID = ID;
            this.money = money;
            System.out.println("Account "+ID+" initialized");
            database.addAccount(this);
        }
    }

    public String getID() {
        return ID;
    }
    
    public void interestEarnings() {
        System.out.println("Interest earnings: $"+this.money * this.interestBenefit);
    }
    
    protected void payFee(double amount) {
        this.money = this.money + amount*0.01;
    }

    @Override
    public String toString() {
        return "Account{" + "ID=" + ID + ", currentLoan=" + currentLoan + ", money=" + money + ", interestBenefit=" + interestBenefit + '}';
    }
    
}
