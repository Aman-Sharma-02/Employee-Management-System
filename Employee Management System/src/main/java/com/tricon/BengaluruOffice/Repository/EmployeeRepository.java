package com.tricon.BengaluruOffice.Repository;

import com.tricon.BengaluruOffice.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
