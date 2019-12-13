package com.mamin.spring.repositories;

import com.mamin.spring.entities.Option;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by otherz on 13.12.2019.
 */
@Repository
@RepositoryRestResource(collectionResourceRel = "options", path = "options")
public interface OptionsRepository extends PagingAndSortingRepository<Option, Integer> {
    Option findByName(String name);

    List<Option> findByMonthlyPaymentBetween(double minPrice, double maxPrice);

    List<Option> findByCostOfConnectionBetween(double minPrice, double maxPrice);
}
