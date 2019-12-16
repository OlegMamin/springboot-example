package com.mamin.spring.controllers;

import com.mamin.spring.entities.Contract;
import com.mamin.spring.repositories.ContractsRepository;
import com.mamin.spring.services.DashboardService;
import com.sun.javafx.collections.ImmutableObservableList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by otherz on 16.12.2019.
 */
@RunWith(MockitoJUnitRunner.class)
public class AnyRestControllerTest {

    @Mock
    private DashboardService dashboardService;

    @InjectMocks
    private AnyRestController controller;

    @Test
    public void getFreeContractsRest() throws Exception {
        Mockito.when(dashboardService.getContractsByClientId(1))
                .thenReturn(Arrays.asList());

        List<Contract> contracts = controller.getContractsRest(1);
        Mockito.verify(dashboardService).getContractsByClientId(1);
    }

}