package entities.controllers;

import entities.Employee;

import java.util.List;

public interface ICreateEmployee {
    void createEmployee();
    Integer verifyID(List<Employee> employeeList, int id);

    List<Employee> getEmployeeList();
}
