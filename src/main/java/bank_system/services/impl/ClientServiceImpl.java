package bank_system.services.impl;

import bank_system.models.entities.Client;
import bank_system.repositories.ClientRepository;
import bank_system.services.ClientService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void createClient(Client client) {
        this.clientRepository.save(client);
    }

    @Override
    public void updateClient(Client client) {
        this.clientRepository.save(client);
    }

    @Override
    public void deleteClientById(long id) {
        this.clientRepository.deleteById(id);
    }

    @Override
    public Client getClientById(long id) {
        return this.clientRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Client> getAllClients() {
        return new HashSet<>(this.clientRepository.findAll());
    }

    @Override
    public Client getClientByEgn(String egn) {
        return this.clientRepository.findByEgn(egn);
    }
}
