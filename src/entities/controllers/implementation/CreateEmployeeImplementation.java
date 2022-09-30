package entities.controllers.implementation;

import entities.Department;
import entities.Dependents;
import entities.Employee;
import entities.controllers.ICreateDependents;
import entities.controllers.ICreateEmployee;
import entities.controllers.enums.Role;
import javax.swing.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateEmployeeImplementation implements ICreateEmployee {
    List<Employee> employeeList = new ArrayList<>();

    @Override
    public void createEmployee(int id) throws Exception {

        Employee employee = new Employee();

        try {
            employee.setRegistration(id);
            questionsEmployee(employee);
            employeeList.add(employee);
            JOptionPane.showMessageDialog(null,employee);

        } catch (DateTimeException e) {
            JOptionPane.showMessageDialog(null
                    , "Date Format invalid!"
                    , "Date error"
                    , JOptionPane.ERROR_MESSAGE);
            return;
        } catch (IllegalArgumentException ie) {
            JOptionPane.showMessageDialog(null
                    ,"Role invalid!"
                    , "Error Role"
                    , JOptionPane.ERROR_MESSAGE);
            return;
        }
        addDependents(employee);
    }

    public Integer verifyID(List<Employee> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getRegistration() == id) {
                return i;
            }
        }
        return null;
    }



    private void addDependents(Employee employee) throws Exception {
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
                ICreateDependents createDependents = new CreateDependencyImplementation();
                List<Dependents> dependentsList = employee.getDependentsList();
                Dependents result = createDependents.createDependency(dependentsList);
                if(result != null) {
                    employee.getDependentsList().add(result);
                }
            } else if(response == 1) {
                break;
            }
        }
    }

    private void questionsEmployee(Employee employee) {
        String[] choises = {"management", "agency", "P&D"};
        String hire_date;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Department department = new Department();


        employee.setFirstName(JOptionPane.showInputDialog("Enter first Name the Employee's: "));
        employee.setLastName(JOptionPane.showInputDialog("Enter last name the Employee's: "));
        hire_date = JOptionPane.showInputDialog("Enter hire date the Employee: ");
        LocalDate date = LocalDate.parse(hire_date, fmt);
        employee.setHire_date(date);
        employee.setCPF(JOptionPane.showInputDialog("Enter CPF the Employee's: "));
        employee.setSalary(Double.parseDouble(JOptionPane.showInputDialog("Enter salary the Employee's")));
        employee.setCargo(Role.valueOf(JOptionPane.showInputDialog(
                "Which is the employee's job?\n"
                        + Arrays.toString(
                                Role.values()))
                                .toUpperCase()));
        int validate = (JOptionPane.showOptionDialog(
                null
                , "Choose the departament:"
                , "Options"
                , JOptionPane.YES_NO_CANCEL_OPTION
                , JOptionPane.QUESTION_MESSAGE
                , null
                , choises
                , null));
        if(validate == 0) {
            employee.setDepartment(department.getManagement());
        } else if(validate == 1) {
            employee.setDepartment(department.getAgency());
        } else {
            employee.setDepartment(department.getSearch());
        }
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}
