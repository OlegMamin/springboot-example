package com.mamin.spring.services;

import com.mamin.spring.entities.Client;
import com.mamin.spring.entities.Contract;
import com.mamin.spring.repositories.ClientsRepository;
import com.mamin.spring.repositories.ContractsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by otherz on 13.12.2019.
 */
@Service
public class DashboardService {

    @Autowired
    private ClientsRepository clientsRepository;

    @Autowired
    private ContractsRepository contractsRepository;

    public List<Contract> getContractsByLogin(String login) {
        Client found = clientsRepository.findByLogin(login);
        return contractsRepository.findByClientOrderByPhoneNumber(found);
    }

    public List<Contract> getContractsByClientId(int clientId) {
        Client found = clientsRepository.findById(clientId).get();
        return contractsRepository.findByClientOrderByPhoneNumber(found);
    }
}