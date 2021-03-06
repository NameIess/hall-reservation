package com.training.playgendary.reservation.service.impl;

import com.training.playgendary.reservation.dao.EmployeeRepository;
import com.training.playgendary.reservation.entity.Employee;
import com.training.playgendary.reservation.entity.dto.request.PageableDTO;
import com.training.playgendary.reservation.entity.dto.request.assembler.PageableAssembler;
import com.training.playgendary.reservation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private PageableAssembler pageableAssembler;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, PageableAssembler pageableAssembler) {
        this.employeeRepository = employeeRepository;
        this.pageableAssembler = pageableAssembler;
    }

    @Override
    public Employee save(Employee employee) {
        Employee saveEmployee = employeeRepository.save(employee);
        return saveEmployee;
    }

    @Override
    @Transactional(readOnly = true)
    public Employee findById(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        Employee employee = null;

        if (optionalEmployee.isPresent()) {
            employee = optionalEmployee.get();
        }

        return employee;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Employee> findAll(PageableDTO pageableDTO) {
        Pageable pageable = pageableAssembler.createRequest(pageableDTO, Employee.class);
        Page<Employee> employeePage = employeeRepository.findAll(pageable);

        employeePage.forEach(e -> {
            e.getReservations().size();
        });

        return employeePage;
    }
}
