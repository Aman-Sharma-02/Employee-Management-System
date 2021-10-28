package com.tricon.BengaluruOffice.Model;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
        @Id
        @Column(name="employee_id", nullable=false)
        private long EmployeeId;

        @Column(name="full_name")
        private String FullName;

        @Column(name="designation")
        private String Designation;

        @Column(name="date_of_birth")
        private String DateOfBirth;

        @Column(name="phone_number")
        private long PhoneNumber;

        @Column(name="address")
        private String Address;

    public Employee(long employeeId, String fullName, String designation, String dateOfBirth, long phoneNumber, String address) {
        super();
        this.EmployeeId = employeeId;
        this.FullName = fullName;
        this.Designation = designation;
        this.DateOfBirth = dateOfBirth;
        this.PhoneNumber = phoneNumber;
        this.Address = address;
    }

    public Employee() {
        super();
    }

    public long getEmployeeId() {
        return this.EmployeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.EmployeeId = employeeId;
    }

    public String getFullName() {
        return this.FullName;
    }

    public void setFullName(String fullName) {
        this.FullName = fullName;
    }

    public String getDesignation() {
        return this.Designation;
    }

    public void setDesignation(String designation) {
        this.Designation = designation;
    }

    public String getDateOfBirth() {
        return this.DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.DateOfBirth = dateOfBirth;
    }

    public long getPhoneNumber() {
        return this.PhoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.PhoneNumber = phoneNumber;
    }

    public String getAddress() {
        return this.Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeId=" + this.EmployeeId +
                ", FullName='" + this.FullName + '\'' +
                ", Designation='" + this.Designation + '\'' +
                ", DateOfBirth='" + this.DateOfBirth + '\'' +
                ", PhoneNumber=" + this.PhoneNumber +
                ", Address='" + this.Address + '\'' +
                '}';
    }
}
