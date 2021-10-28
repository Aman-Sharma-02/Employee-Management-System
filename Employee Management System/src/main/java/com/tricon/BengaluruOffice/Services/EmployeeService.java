package com.tricon.BengaluruOffice.Services;

import com.tricon.BengaluruOffice.Model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployee(long EmployeeId);

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void removeEmployee(long emp);
}
