package entities.controllers.implementation;

import entities.Employee;
import entities.controllers.ICreateEmployee;

import javax.swing.*;
import java.util.Date;

public class CreateEmployeeImplementation implements ICreateEmployee {
    String firstName;
    String lastName;
    String CPF;
    Date hire_date;
    double salary;

    Employee employee = new Employee();

    @Override
    public void createEmployee(String firstName, String lastName, String CPF, Date hire_date, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.CPF = CPF;
        this.hire_date = hire_date;
        this.salary = salary;

        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setCPF(CPF);
        employee.setHire_date(hire_date);
        employee.setSalary(salary);

         JOptionPane.showMessageDialog(null,
                 "Name: " + employee.getFirstName()
                 + "\nLast Name: " + employee.getLastName()
                         + "\nHire Date: " + employee.getHire_date()
                         + "\nSalary: " + employee.getSalary());

    }

}
