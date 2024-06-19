
package com.mycompany.entidadfinanciera;

import com.mycompany.entidadfinanciera.users.Users;
import com.mycompany.entidadfinanciera.users.UsersType;

public class EntidadFinanciera {

    public static void main(String[] args) throws Exception {
        
        Users user1 = new Users ("Camila", "Uribe", 18, UsersType.EMPLOYEE, true);
        
        
        user1.depositMoney(20000);
        user1.youthAccount("djja", 10000, 8);
        user1.depositMoney(25000);
        user1.requisitosCredito(10000);
        
     
        
    }
}
