import entities.controllers.ICreateEmployee;
import entities.controllers.IPayroll;
import entities.controllers.implementation.CreateEmployeeImplementation;
import entities.controllers.implementation.CreatePayRoll;

import javax.swing.*;

public class Program {
    public static void main(String[] args) {
        int operation = 0;
        String[] choises = {"Create Employee", "Generate Payroll", "Cancel"};
        ICreateEmployee addEmployee = new CreateEmployeeImplementation();
        IPayroll payroll = new CreatePayRoll();
        int id = 0;


        while (operation == 0) {

            int result = JOptionPane.showOptionDialog(
                    null
                    , "Choose the desired operation:"
                    , "Options"
                    , JOptionPane.YES_NO_CANCEL_OPTION
                    , JOptionPane.QUESTION_MESSAGE
                    , null
                    , choises
                    , "Create Employee");

            if (result == 0) {
                id++;
                addEmployee.createEmployee(id);
            } else if(result == 1) {
                payroll.calculateTotalValue();
            }
            else {
                break;
            }
        }
    }
}
