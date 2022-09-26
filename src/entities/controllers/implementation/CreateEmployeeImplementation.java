package entities.controllers.implementation;

import entities.Department;
import entities.Dependents;
import entities.Employee;
import entities.controllers.ICreateDependents;
import entities.controllers.ICreateEmployee;
import entities.controllers.enums.Role;

import javax.swing.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CreateEmployeeImplementation implements ICreateEmployee {

    String firstName;
    String lastName;
    String CPF;
    String hire_date;
    double salary;
    Role role;
    Department department;
    List<Employee> employeeList = new ArrayList<>();

    @Override
    public void createEmployee() {

        int id = 0;
        String[] choises = {"management", "agency", "P&D"};

        firstName = JOptionPane.showInputDialog("Enter first Name the Employee's: ");
        lastName = JOptionPane.showInputDialog("Enter last name the Employee's: ");
        CPF = JOptionPane.showInputDialog("Enter CPF the Employee's: ");
        hire_date = JOptionPane.showInputDialog("Enter hire date the Employee: ");
        salary = Double.parseDouble(JOptionPane.showInputDialog("Enter salary the Employee's"));
        role = Role.valueOf(JOptionPane.showInputDialog("Which is the employee's job?"));
        String validate = String.valueOf(JOptionPane.showOptionDialog(
                null
                , "Choose the departament:"
                , "Options"
                , JOptionPane.YES_NO_CANCEL_OPTION
                , JOptionPane.QUESTION_MESSAGE
                , null
                , choises
                , null));


        Employee employee = new Employee();
        ICreateDependents createDependents = new CreateDependencyImplementation();
        id++;


        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setHire_date(hire_date);
        employee.setCPF(CPF);
        employee.setSalary(salary);
        employee.setCargo(role);
        employee.setRegistration(id);
        employee.setDepartment(validate);

        employeeList.add(employee);
        JOptionPane.showConfirmDialog(null, employee);

        int response = 0;

        while (response == 0 ) {
            response = JOptionPane.showConfirmDialog(
                    null
                    ,"Do you want add new dependency?"
                    ,"ADD new Dependency"
                    ,JOptionPane.YES_NO_OPTION
                    ,JOptionPane.QUESTION_MESSAGE
                    , null
            );
            if(response == 0 ) {
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
