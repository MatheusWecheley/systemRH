package entities.controllers.implementation;


import entities.Department;
import entities.Employee;
import entities.controllers.ICreateEmployee;
import entities.controllers.IPayroll;
import entities.controllers.enums.Taxes;
import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CreatePayRoll implements IPayroll {

    static List<Employee> valueDepartments = new ArrayList<>();

    public void payRoll(Integer verifyId, List<Employee> list) {

        if(verifyId != null) {
            int size = list.get(verifyId).getDependentsList().size();
            calculateValueEmployee(verifyId, list, size);
        } else {
            JOptionPane.showMessageDialog(null, "Not possible calculate employee salary!");
        }
    }

    public Double generatePayRollDepartment(List<Employee> list) {
        for (int i = 0; i < list.size(); i++) {
            double salary = list.get(i).getSalary();
            if(salary != 0) {
                double totalValue = 0;
                totalValue += salary - (salary * Taxes.INPS.getValues()) - ( salary * Taxes.SO.getValues()) - (salary * Taxes.INSS.getValues()) +
                        (105.99 * list.get(i).getDependentsList().size() + (100 * yearsWorked(list.get(i))));
                return totalValue;
            }
        }
        return null;
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
            employee.setSalaryTotal(newSalary);
            JOptionPane.showMessageDialog(null, "Total to payable: R$" +employee.getSalaryTotal());
            valueDepartments.add(employee);

        } else {
            double oldSalary = employee.getSalary();
            double newSalary = oldSalary - ( oldSalary * Taxes.INPS.getValues())
                    - ( oldSalary * Taxes.INSS.getValues())
                    - ( oldSalary * Taxes.SO.getValues())
                    + (105.99 * size)
                    + (100 * timeWorked);
            employee.setSalaryTotal(newSalary);
            JOptionPane.showMessageDialog(null,"Total to payable: R$" + employee.getSalaryTotal());
            valueDepartments.add(employee);
        }
    }

    private static Integer yearsWorked(Employee employee) {
        return LocalDate.now().getYear() - employee.getHire_date().getYear();
    }

}
