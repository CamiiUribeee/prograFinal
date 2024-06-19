package com.mycompany.andresgarcia192229.client;
import com.mycompany.andresgarcia192229.account.Account;
import com.mycompany.andresgarcia192229.logs.AccountLogs;
import com.mycompany.andresgarcia192229.logs.ClientLogs;

public class Client extends Account {
    String name;
    int age;
    ClientType personType;
    Account linkedAccount;
    boolean hasCodebtor;  //tiene codeudor 
    boolean hasBankStatement;  //estado bancario 

    public Client(String name, int age, ClientType personType, boolean hasBankStatement, boolean hasCodebtor, ClientLogs database) {
        super("", 0);
        this.name = name;
        this.age = age;
        this.personType = personType;
        this.hasCodebtor = hasCodebtor;
        this.hasBankStatement = hasBankStatement;
        database.addClient(this);
    }
    
    public void createAccount(String ID, double money, AccountLogs database) {
        if (age < 14) {
            if (linkedAccount != null) {
                System.out.println("You already have an account");
                return;
            }
            System.out.println("You have to link an account");
        }
        else {
            try {
                super.initializeAccount(ID, money, database);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void linkAccount(String ID, AccountLogs database) {
        for (Account account : database.getAccountLog()) {
            if (account.getID().equals(ID)) {
                this.linkedAccount = account;
                System.out.println("Linked with "+ID);
                break;
            }
        }
    }
    
    public void requestLoan(double amount) {
        if (age > 14 && (hasBankStatement || personType == ClientType.EMPLOYEE)) {
            super.approveLoan(amount);
        }
        else {
            System.out.println("This account doesn't meet the requirements for a loan");
        }
    }
    
    public void deposit(double amount) {
        
        if (linkedAccount != null) {
            linkedAccount.depositMoney(amount);
        }
        else {
            if (super.getID().equals("")) {
                System.out.println("You don't have an account");
                return;
            }
            super.depositMoney(amount);
        }        
        
    }
    
    public void withdraw(double amount) {
        
        if (linkedAccount != null) {
            try {
                linkedAccount.withdrawMoney(amount);            
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        else {        
            if (super.getID().equals("")) {
                System.out.println("You don't have an account");
                return;
            }
            try {
                super.withdrawMoney(amount);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void getInterest() {
        if (linkedAccount != null) {
            linkedAccount.interestEarnings();
            return;
        }
        super.interestEarnings();
    }
    
    public String toStringClient() {
        if (linkedAccount != null) {
            return "Client{"+"name=" + name + ", age=" + age + ", personType=" + personType + ", linkedAccount=" + linkedAccount + ", hasBankStatement=" + hasBankStatement + ", hasCodebtor=" + hasCodebtor +'}';
        }
        else {
            return "Client{"+"name=" + name + ", age=" + age + ", personType=" + personType + ", linkedAccount=" + super.toString() + ", hasBankStatement=" + hasBankStatement + ", hasCodebtor=" + hasCodebtor +'}';
        }
        
    }    
    
    public void payFee(double amount) {
        super.payFee(amount);
    }
    
}
