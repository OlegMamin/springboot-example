package com.mamin.spring.controllers;

import com.mamin.spring.entities.Contract;
import com.mamin.spring.repositories.ClientsRepository;
import com.mamin.spring.repositories.ContractsRepository;
import com.mamin.spring.services.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by otherz on 13.12.2019.
 */
@RestController
@RequestMapping(path = "/api")
public class AnyRestController {
    @Autowired
    private ContractsRepository contractsRepository;

    @Autowired
    private DashboardService dashboardService;

    @GetMapping(path = "/contracts/findFree")
    public Page<Contract> getFreeContractsRest(
            @RequestParam(defaultValue = "11") int size,
            @RequestParam(defaultValue = "1") int page
    ) {
        return contractsRepository.findContractsToChosePagination(
//                Sort.by("phoneNumber"),
//                Sort.unsorted(),
//                Sort.by("phoneNumber").descending(),
//                Sort.by(Sort.Order.desc("phoneNumber"), Sort.Order.asc("clientName"))
                PageRequest.of(page - 1, size, Sort.by("phoneNumber"))
        );
    }

    @GetMapping(path = "/contracts/find")
    public List<Contract> getContractsRest(
            @RequestParam(defaultValue = "1") int clientId
    ){
        return dashboardService.getContractsByClientId(clientId);
    }
}
