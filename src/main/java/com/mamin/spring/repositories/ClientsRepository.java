package com.mamin.spring.repositories;

import com.mamin.spring.entities.Client;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by otherz on 13.12.2019.
 */
@Repository
@RepositoryRestResource(collectionResourceRel = "clients", path = "clients")
public interface ClientsRepository extends PagingAndSortingRepository<Client, Integer> {
    Client findByLogin(String login);

    Client findByLoginAndEncryptedPassword(String login, String encryptedPassword);

    Client findByPassportNumber(String passportNumber);
}
