package com.mycompany.andresgarcia192229;

import com.mycompany.andresgarcia192229.logs.AccountLogs;
import com.mycompany.andresgarcia192229.client.Client;
import com.mycompany.andresgarcia192229.client.ClientType;
import com.mycompany.andresgarcia192229.logs.ClientLogs;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AndresGarcia192229 {

    public static void main(String[] args) {
        AccountLogs accLogs = new AccountLogs();
        ClientLogs clientLogs = new ClientLogs();
        
        Client worker1 = new Client("Bryce", 30, ClientType.EMPLOYEE, false, false, clientLogs);
        Client worker2 = new Client("Charlotte", 28, ClientType.EMPLOYEE, true, false, clientLogs);
        Client kid1 = new Client("Charlie", 13, ClientType.INDEPENDENT, false, false, clientLogs);
        
        worker1.deposit(20000);        
        worker1.createAccount("ACC1", 1000, accLogs);
                
        worker1.createAccount("ACC1", 10000, accLogs);
        worker2.createAccount("ACC2", 10000, accLogs);
        
        kid1.createAccount("ACC3", 10000, accLogs);
        
        worker1.deposit(20000);
        
        worker1.getInterest();        
        worker1.requestLoan(30000);
        
        kid1.requestLoan(30000);
        
        kid1.linkAccount("ACC2", accLogs);
        kid1.createAccount("ACC5", 20, accLogs);
        kid1.deposit(20000);
        
        kid1.withdraw(9000000);
        kid1.getInterest();
        
        worker1.payFee(100);
        
        System.out.println(accLogs.getAccountLog());        
        System.out.println(clientLogs.getClientLog());
        
        File log1 = new File("./clients.txt");
        try {
            FileWriter writer = new FileWriter(log1);
            PrintWriter pw = new PrintWriter(writer);
            for (String string : clientLogs.getClientLog()) {
                pw.println(string);
            }
            writer.close();
            pw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
