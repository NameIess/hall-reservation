package com.training.playgendary.reservation.service;

import com.training.playgendary.reservation.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);

    Employee findById(Long id);

    List<Employee> findAll();
}
