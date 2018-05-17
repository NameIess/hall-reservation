package com.training.playgendary.reservation.dao;

import com.training.playgendary.reservation.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Contains the basic methods for interacting with the employee entity
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
