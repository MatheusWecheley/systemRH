import entities.controllers.ICreateEmployee;
import entities.controllers.implementation.CreateEmployeeImplementation;

import javax.swing.*;
import java.util.Date;

public class Program {
    public static void main(String[] args) {
        String firstName = JOptionPane.showInputDialog("Please, enter the employee's name: ");
        String lastName = JOptionPane.showInputDialog("Please, enter the employee's last name: ");
        String CPF = JOptionPane.showInputDialog("Enter CPF: ");
        Date hire_date = new Date();
        double salary = 2000.00;

        ICreateEmployee employee = new CreateEmployeeImplementation();

        employee.createEmployee(firstName, lastName, CPF, hire_date, salary);
    }
}
