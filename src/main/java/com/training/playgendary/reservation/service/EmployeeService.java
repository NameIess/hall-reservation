package com.training.playgendary.reservation.service;

import com.training.playgendary.reservation.entity.Employee;

import java.util.List;

/**
 * Contains the basic methods for interacting with the Employee entity
 */
public interface EmployeeService {

    /**
     * Saves particular entity into data source.
     * @param employee  Particular employee entity to be saved.
     * @return  Saved and identified employee entity.
     */
    Employee save(Employee employee);

    /**
     * Finds the employee using particular employee @id.
     * @param id    Requested employee identifier.
     * @return  Employee with particular @id value.
     */
    Employee findById(Long id);

    /**
     * Finds all employees that are stored in data source.
     * @return  Employee list
     */
    List<Employee> findAll();
}
