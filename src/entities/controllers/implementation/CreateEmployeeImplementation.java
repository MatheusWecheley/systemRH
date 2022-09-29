package entities.controllers.implementation;

import entities.Dependents;
import entities.Employee;
import entities.controllers.ICreateDependents;
import entities.controllers.ICreateEmployee;
import entities.controllers.enums.Role;
import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreateEmployeeImplementation implements ICreateEmployee {
    int id = 1;
    List<Employee> employeeList = new ArrayList<>();

    @Override
    public void createEmployee(int id) throws Exception {
        int response = 0;
        String[] choises = {"management", "agency", "P&D"};
        String hire_date;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Employee employee = new Employee();


        try {
            employee.setFirstName(JOptionPane.showInputDialog("Enter first Name the Employee's: "));
            employee.setLastName(JOptionPane.showInputDialog("Enter last name the Employee's: "));
            hire_date = JOptionPane.showInputDialog("Enter hire date the Employee: ");
            LocalDate date = LocalDate.parse(hire_date, fmt);
            employee.setHire_date(date);
            employee.setCPF(JOptionPane.showInputDialog("Enter CPF the Employee's: "));
            employee.setSalary(Double.parseDouble(JOptionPane.showInputDialog("Enter salary the Employee's")));
            employee.setCargo(Role.valueOf(JOptionPane.showInputDialog("Which is the employee's job?").toUpperCase()));
            employee.setRegistration(id);

            int validate = (JOptionPane.showOptionDialog(
                    null
                    , "Choose the departament:"
                    , "Options"
                    , JOptionPane.YES_NO_CANCEL_OPTION
                    , JOptionPane.QUESTION_MESSAGE
                    , null
                    , choises
                    , null));

            employeeList.add(employee);
            JOptionPane.showMessageDialog(null,employee);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error create new Employee: \n" + e);
            return;
        }


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

    public Integer verifyID(List<Employee> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getRegistration() == id) {
                return i;
            }
        }
        return null;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }
}
