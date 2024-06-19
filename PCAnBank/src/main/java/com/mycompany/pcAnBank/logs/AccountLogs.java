package com.mycompany.andresgarcia192229.logs;

import java.util.ArrayList;
import com.mycompany.andresgarcia192229.account.Account;

public class AccountLogs {
    ArrayList<Account> accountLog = new ArrayList<Account>();

    public AccountLogs() {
    }
    
    public void addAccount(Account account) {
        accountLog.add(account);
    }

    public ArrayList<Account> getAccountLog() {
        return accountLog;
    }
    
    
}
