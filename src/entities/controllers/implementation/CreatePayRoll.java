package entities.controllers.implementation;

import entities.Department;
import entities.Employee;
import entities.controllers.ICreateEmployee;
import entities.controllers.IPayroll;

import javax.swing.*;
import java.util.List;

public class CreatePayRoll implements IPayroll {
    Employee employee;
    Department department;
    String company;
    ICreateEmployee createEmployeeImplementation = new CreateEmployeeImplementation();

    public CreatePayRoll() {
    }

    public CreatePayRoll(Employee employee) {
        this.employee = employee;
    }

    public void calculateTotalValue(int verifyId) {
        List<Employee> employeeList = createEmployeeImplementation.getEmployeeList();
        Integer result = createEmployeeImplementation.verifyID(employeeList, verifyId);
        if(result == null) {
            JOptionPane.showMessageDialog(null, "Employee not found!");
        } else {
            JOptionPane.showConfirmDialog(null, result);
        }

    }

}
