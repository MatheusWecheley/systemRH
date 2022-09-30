package entities.controllers.implementation;


import entities.Employee;
import entities.controllers.IPayroll;
import entities.controllers.enums.Taxes;
import javax.swing.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class CreatePayRoll implements IPayroll {

    public void payRoll(Integer verifyId, List<Employee> list) {

        if(verifyId == null) {
            JOptionPane.showMessageDialog(null, "Not possible calculate employee salary!");
        } else {
            int size = list.get(verifyId).getDependentsList().size();
            calculateValueEmployee(verifyId, list, size);
        }
    }
    private static void calculateValueEmployee(int verifyId, List<Employee> list, int size) {

        Employee employee = list.get(verifyId);
        int timeWorked = yearsWorked(employee);

        if(Objects.equals(list.get(verifyId).getRole().toString(), "ENGINEER")) {
            double oldSalary = employee.getSalary();
            double newSalary = oldSalary - ( oldSalary * Taxes.SINDICATE.getValues())
                    - ( oldSalary * Taxes.INPS.getValues())
                    - ( oldSalary * Taxes.INSS.getValues())
                    - ( oldSalary * Taxes.SO.getValues())
                    + (105.99 * size)
                    + (100 * timeWorked);
            employee.setSalary(newSalary);
            JOptionPane.showMessageDialog(null, "Total to payable: R$" +employee.getSalary());

        } else {
            double oldSalary = employee.getSalary();
            double newSalary = oldSalary - ( oldSalary * Taxes.INPS.getValues())
                    - ( oldSalary * Taxes.INSS.getValues())
                    - ( oldSalary * Taxes.SO.getValues())
                    + (105.99 * size)
                    + (100 * timeWorked);
            employee.setSalary(newSalary);
            JOptionPane.showMessageDialog(null,"Total to payable: R$" + employee.getSalary());
        }
    }

    private static Integer yearsWorked(Employee employee) {
        return LocalDate.now().getYear() - employee.getHire_date().getYear();
    }

}
