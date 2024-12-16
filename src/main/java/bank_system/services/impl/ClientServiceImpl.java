package bank_system.services.impl;

import bank_system.exceptions.EntityNotFoundInDbException;
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
        Client client = this.clientRepository.findById(id).orElse(null);
        if(client == null){

            throw new EntityNotFoundInDbException("Client not found!");
        }

        this.clientRepository.delete(client);
    }

    @Override
    public Client getClientById(long id) {
        Client client = this.clientRepository.findById(id).orElse(null);
        if(client == null){

            throw new EntityNotFoundInDbException("Client not found!");
        }

        return client;
    }

    @Override
    public Set<Client> getAllClients() {
        if(this.clientRepository.findAll().isEmpty()){

            throw new EntityNotFoundInDbException("Client table is empty");
        }

        return new HashSet<>(this.clientRepository.findAll());
    }

    @Override
    public Client getClientByEgn(String egn) {
        if(this.clientRepository.findByEgn(egn) == null){

            throw new EntityNotFoundInDbException("Client not found!");
        }

        return this.clientRepository.findByEgn(egn);
    }
}
