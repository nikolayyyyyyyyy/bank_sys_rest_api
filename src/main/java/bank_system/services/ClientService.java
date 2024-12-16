package bank_system.services;

import bank_system.models.entities.Client;

import java.util.Set;

public interface ClientService {

    public void createClient(Client client);
    public Client getClientById(long id);
    public Set<Client> getAllClients();
}
