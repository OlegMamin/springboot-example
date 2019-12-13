package com.mamin.spring.controllers;

import com.mamin.spring.entities.Contract;
import com.mamin.spring.repositories.ContractsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by otherz on 12.12.2019.
 */
@Controller
@RestController
public class FirstController {

    @Autowired
    private ContractsRepository contractsRepository;

    @RequestMapping(path = "/hello")
    public String showHelloWorld(){
        return "hello-world";
    }

    @GetMapping(path = "/api/contracts/findFree")
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
}
