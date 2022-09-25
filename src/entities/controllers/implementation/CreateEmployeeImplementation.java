package entities.controllers.implementation;

import entities.Dependents;
import entities.Employee;
import entities.controllers.ICreateDependents;
import entities.controllers.ICreateEmployee;

import javax.swing.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreateEmployeeImplementation implements ICreateEmployee {

    String firstName;
    String lastName;
    String CPF;
    String hire_date;
    double salary;
    List<Employee> employeeList = new ArrayList<>();

    @Override
    public void createEmployee() {

        DateTimeFormatter formate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        firstName = JOptionPane.showInputDialog("Enter first Name the Employee's: ");
        lastName = JOptionPane.showInputDialog("Enter last name the Employee's: ");
        CPF = JOptionPane.showInputDialog("Enter CPF the Employee's: ");
        hire_date = JOptionPane.showInputDialog("Enter hire date the Employee: ");
        salary = Double.parseDouble(JOptionPane.showInputDialog("Enter salary the Employee's"));

        Employee employee = new Employee();

        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setHire_date(hire_date);
        employee.setCPF(CPF);
        employee.setSalary(salary);

        employeeList.add(employee);
        int response = 0;

        while (response == 0) {
            int anotherDependecy = JOptionPane.showConfirmDialog(
                    null
                    , "Do you want add dependency?"
                    , "Add Another Dependency"
                    , JOptionPane.YES_NO_OPTION
                    , JOptionPane.QUESTION_MESSAGE
                    , null);

            response = anotherDependecy;
            ICreateDependents createDependents = new CreateDependencyImplementation();

            if (anotherDependecy == 0) {
                createDependents.createDependency();
            } else {
                break;
            }
        }
    }
    public Integer verifyID(List<Employee> employeeList, int id) {
        for (int i = 0; i < employeeList.size(); i++) {
            if(employeeList.get(i).getRegistration() == id) {
                return i;
            }
        }
        return null;
    }
}
