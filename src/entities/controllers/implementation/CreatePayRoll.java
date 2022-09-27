package entities.controllers.implementation;

import entities.Department;
import entities.Employee;
import entities.controllers.IPayroll;

import javax.swing.*;

public class CreatePayRoll implements IPayroll {
    Employee employee;
    Department department;
    String company;
    CreateEmployeeImplementation createEmployeeImplementation;

    public CreatePayRoll() {
    }

    public CreatePayRoll(Employee employee) {
        this.employee = employee;
    }

    public void calculateTotalValue() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the Employee ID:"));

        Integer result = createEmployeeImplementation.verifyID(createEmployeeImplementation.employeeList, id);
        JOptionPane.showMessageDialog(null, result);
    }

}
