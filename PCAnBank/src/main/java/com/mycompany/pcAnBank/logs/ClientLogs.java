package com.mycompany.andresgarcia192229.logs;

import java.util.ArrayList;
import com.mycompany.andresgarcia192229.client.Client;

public class ClientLogs {
    ArrayList<Client> clientLog = new ArrayList<Client>();

    public ClientLogs() {
    }
    
    public void addClient(Client client) {
        clientLog.add(client);
    }
    
    
    
    public ArrayList<String> getClientLog() {
        ArrayList<String> clients = new ArrayList<String>();
        for (Client client : clientLog) {
            clients.add(client.toStringClient());
        }
        return clients;
    }
}
