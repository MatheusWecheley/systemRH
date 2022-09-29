package entities.controllers.implementation;

import entities.Department;
import entities.Dependents;
import entities.Employee;
import entities.controllers.IPayroll;
import entities.controllers.enums.Taxes;

import javax.swing.*;
import java.util.List;
import java.util.Objects;

public class CreatePayRoll implements IPayroll {
    Employee employee;
    Department department;
    String company;
    static Taxes taxes;

    public void payRoll(Integer verifyId, List<Employee> list) {

        if(verifyId == null) {
            JOptionPane.showMessageDialog(null, "Not possible calculate employee salary!");
        } else {
            int size = list.get(verifyId).getDependentsList().size();
            calculateValue(verifyId, list, size);
        }
    }
    private static void calculateValue(int verifyId, List<Employee> list, int size) {

        Employee employee = list.get(verifyId);

        if(Objects.equals(list.get(verifyId).getRole().toString(), "ENGINEER")) {
            double oldSalary = employee.getSalary();
            double newSalary = oldSalary - ( oldSalary * Taxes.SINDICATE.getValues())
                    - ( oldSalary * Taxes.INPS.getValues())
                    - ( oldSalary * Taxes.INSS.getValues())
                    - ( oldSalary * Taxes.SO.getValues())
                    + (105.99 * size)
                    ;
            employee.setSalary(newSalary);
            JOptionPane.showMessageDialog(null, employee.getSalary());

        } else {
            double oldSalary = employee.getSalary();
            double newSalary = oldSalary - ( oldSalary * Taxes.INPS.getValues())
                    - ( oldSalary * Taxes.INSS.getValues())
                    - ( oldSalary * Taxes.SO.getValues())
                    + (105.99 * size);
            employee.setSalary(newSalary);
            JOptionPane.showMessageDialog(null, employee.getSalary());
        }
    }

}
