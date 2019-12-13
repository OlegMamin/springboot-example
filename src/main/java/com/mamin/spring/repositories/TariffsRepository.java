package com.mamin.spring.repositories;

import com.mamin.spring.entities.Tariff;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by otherz on 13.12.2019.
 */
@Repository
@RepositoryRestResource(collectionResourceRel = "tariffs", path = "tariffs")
public interface TariffsRepository extends PagingAndSortingRepository<Tariff, Integer> {
    Tariff findByName(String name);

    @Query("FROM Tariff ORDER BY price")
    List<Tariff> findAllOrderByPrice();

    List<Tariff> findByPriceBetween(double minPrice, double maxPrice);
}
