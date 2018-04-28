package com.training.playgendary.reservation.service.impl.unit;

import com.training.playgendary.reservation.dao.EmployeeRepository;
import com.training.playgendary.reservation.entity.Employee;
import com.training.playgendary.reservation.service.EmployeeService;
import com.training.playgendary.reservation.service.impl.EmployeeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;
import resources.TestResources;

import java.util.List;
import java.util.Optional;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

public class EmployeeServiceImplTestUnit {
    private EmployeeService underTest;
    private EmployeeRepository employeeRepository;

    @Before
    public void doSetup() {
        employeeRepository = mock(EmployeeRepository.class);
        underTest = new EmployeeServiceImpl(employeeRepository);
    }

    @Test
    public void shouldReturnEmployeeWhenIdValid() {
        Employee expectedResult = TestResources.VALID_EMPLOYEE_ID_1;
        when(employeeRepository.findById(anyLong())).thenReturn(Optional.ofNullable(expectedResult));

        Employee actualResult = underTest.findById(1L);

        verify(employeeRepository, times(1)).findById(anyLong());
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void shouldSaveEmployeeAndReturnSavedEntityWhenEmployeeValid() {
        Employee expectedResult = TestResources.VALID_EMPLOYEE_ID_1;
        when(underTest.save(any(Employee.class))).thenReturn(expectedResult);

        Employee actualResult = underTest.save(expectedResult);

        verify(employeeRepository, times(1)).save(any(Employee.class));
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void shouldReturnEmployeeListWhenEmployeeTableExists() {
        List<Employee> expectedResult = TestResources.EMPLOYEES;
        when(underTest.findAll()).thenReturn(expectedResult);

        List<Employee> actualResult = underTest.findAll();

        verify(employeeRepository, times(1)).findAll();
        Assert.assertEquals(actualResult, expectedResult);
    }
}

