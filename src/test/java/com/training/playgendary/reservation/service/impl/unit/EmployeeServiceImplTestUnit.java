package com.training.playgendary.reservation.service.impl.unit;

import com.training.playgendary.reservation.dao.EmployeeRepository;
import com.training.playgendary.reservation.entity.Employee;
import com.training.playgendary.reservation.entity.dto.request.PageableAssembler;
import com.training.playgendary.reservation.entity.dto.request.PageableDTO;
import com.training.playgendary.reservation.service.EmployeeService;
import com.training.playgendary.reservation.service.impl.EmployeeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.PageImpl;
import org.testng.Assert;
import resources.TestResources;

import java.util.List;
import java.util.Optional;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

public class EmployeeServiceImplTestUnit {
    private EmployeeService underTest;
    private EmployeeRepository employeeRepository;
    private PageableAssembler pageableAssembler;

    @Before
    public void doSetup() {
        employeeRepository = mock(EmployeeRepository.class);
        pageableAssembler = mock(PageableAssembler.class);
        underTest = new EmployeeServiceImpl(employeeRepository, pageableAssembler);
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
        when(employeeRepository.save(any(Employee.class))).thenReturn(expectedResult);

        Employee actualResult = underTest.save(expectedResult);

        verify(employeeRepository, times(1)).save(any(Employee.class));
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void shouldReturnEmployeeListWhenEmployeeTableExists() {
        List<Employee> expectedResult = TestResources.EMPLOYEES;
        when(pageableAssembler.createRequest(any(PageableDTO.class), any(Class.class))).thenReturn(TestResources.UNSORTED_REQUEST);
        when(employeeRepository.findAll(TestResources.UNSORTED_REQUEST)).thenReturn(new PageImpl<>(expectedResult));

        List<Employee> actualResult = underTest.findAll(new PageableDTO()).getContent();

        verify(employeeRepository, times(1)).findAll(TestResources.UNSORTED_REQUEST);
        Assert.assertEquals(actualResult, expectedResult);
    }
}

