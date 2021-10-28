package com.tricon.BengaluruOffice.Services;

import com.tricon.BengaluruOffice.Model.Employee;
import com.tricon.BengaluruOffice.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
        @Autowired
        private EmployeeRepository employeeRepository;

        @Override
        public List<Employee> getAllEmployees() {
                return this.employeeRepository.findAll();
        }

        @Override
        public Employee getEmployee(long EmployeeId) {
                Optional<Employee> emp= this.employeeRepository.findById(EmployeeId);
                Employee employee1=null;
                if(emp.isPresent())
                {
                        employee1 = emp.get();
                }
                else
                {
                        throw new RuntimeException("Employee record not found for EmployeeId :: "+EmployeeId);
                }
                return employee1;
        }

        @Override
        public Employee createEmployee(Employee employee)
        {
                return employeeRepository.save(employee);
        }

        @Override
        public Employee updateEmployee(Employee employee) {
                Optional<Employee> emp = this.employeeRepository.findById(employee.getEmployeeId());
                Employee employee1=null;
                if(emp.isPresent()) {
                        employee1 = emp.get();
                        employee1.setEmployeeId(employee.getEmployeeId());
                        employee1.setAddress(employee.getAddress());
                        employee1.setDateOfBirth(employee.getDateOfBirth());
                        employee1.setDesignation(employee.getDesignation());
                        employee1.setFullName(employee.getFullName());
                        employee1.setPhoneNumber(employee.getPhoneNumber());
                        employeeRepository.save(employee1);
                }
                else
                {
                        throw new RuntimeException("Employee record not found for EmployeeId :: "+employee.getEmployeeId());
                }
                return employee1;
        }

        @Override
        public void removeEmployee(long emp) {
                Optional<Employee> employee = this.employeeRepository.findById(emp);
                if(employee.isPresent())
                {
                        this.employeeRepository.delete(employee.get());
                }
                else
                {
                        throw new RuntimeException("Employee record not found for EmployeeId :: "+emp);
                }
        }


}
