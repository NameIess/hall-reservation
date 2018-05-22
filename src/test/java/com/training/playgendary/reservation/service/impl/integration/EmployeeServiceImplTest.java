//package com.training.playgendary.reservation.service.impl.integration;
//
//import com.training.playgendary.reservation.config.TestConfig;
//import com.training.playgendary.reservation.entity.Employee;
//import com.training.playgendary.reservation.entity.dto.request.assembler.PageableAssembler;
//import com.training.playgendary.reservation.entity.dto.request.PageableDTO;
//import com.training.playgendary.reservation.service.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.*;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.testng.Assert;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//import resources.TestResources;
//
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.List;
//
//@WebAppConfiguration
//@ContextConfiguration(classes = TestConfig.class)
//@ActiveProfiles("test")
//public class EmployeeServiceImplTest extends AbstractTestNGSpringContextTests {
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    @DataProvider(name = "validEmployeeAndId")
//    public static Object[][] validEmployeeAndId() throws ParseException {
//        return new Object[][]{
//                {1L, TestResources.VALID_EMPLOYEE_ID_1},
//                {2L, TestResources.VALID_EMPLOYEE_ID_2},
//                {3L, TestResources.VALID_EMPLOYEE_ID_3},
//                {4L, TestResources.VALID_EMPLOYEE_ID_4},
//        };
//    }
//
//
//    @Test(dataProvider = "validEmployeeAndId")
//    public void shouldReturnEmployeeWhenIdValid(Long id, Employee expectedResult) {
//        Employee actualResult = employeeService.findById(id);
//
//        Assert.assertEquals(actualResult, expectedResult);
//    }
//
//    @Test
//    public void shouldSaveEmployeeAndReturnSavedEntityWhenEmployeeValid() {
//        Employee actualResult = employeeService.save(TestResources.TEST_EMPLOYEE);
//
//        Assert.assertEquals(actualResult, TestResources.TEST_EMPLOYEE);
//    }
//
//    @Test
//    public void shouldReturnEmployeeListWhenEmployeeTableExists() {
////        List<Employee> employees = employeeService.findAll(pageRequest);
////        int actualResult = employees.size();
////
////        Assert.assertEquals(actualResult, TestResources.TABLE_EMPLOYEE_ROWS_AMOUNT);
//    }
//}
