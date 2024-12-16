package bank_system.services.impl;

import bank_system.exceptions.EntityAlreadyExistException;
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
        if(this.clientRepository.findByEgn(client.getEgn()) != null){

            throw new EntityAlreadyExistException("Client with this egn already exist!");
        }

        this.clientRepository.save(client);
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
//        if(this.clientRepository.findAll().isEmpty()){
//
//            throw new EntityNotFoundInDbException("Client table is empty");
//        }

        return new HashSet<>(this.clientRepository.findAll());
    }
}
