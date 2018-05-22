package com.training.playgendary.reservation.controller;

import com.training.playgendary.reservation.config.TestConfig;
import com.training.playgendary.reservation.entity.Employee;
import com.training.playgendary.reservation.entity.dto.request.PageableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@WebAppConfiguration
@ContextConfiguration(classes = TestConfig.class)
@ActiveProfiles("test")
public class ReservationControllerIT extends AbstractTestNGSpringContextTests {

    @Autowired
    private ReservationController reservationController;


    @Test
    public void shouldReturnEmployeeListWhenDataExist() {
        PageableDTO pageableDTO = new PageableDTO();
        pageableDTO.setPageNumber(0);
        pageableDTO.setPageSize(5);

        Page<Employee> page = reservationController.findAllEmployees(pageableDTO);
        List<Employee> content = page.getContent();

        Assert.assertNotNull(content);
        Assert.assertFalse(content.isEmpty());
    }
}
