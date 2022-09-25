import entities.controllers.ICreateEmployee;
import entities.controllers.implementation.CreateEmployeeImplementation;

import javax.swing.*;

public class Program {
    public static void main(String[] args) {
        int operation;
        String[] choises = {"Create Employee", "Generate Payroll", "Cancel"};
        ICreateEmployee addEmployee = new CreateEmployeeImplementation();

        operation = 5;

        while (operation == 5) {

            operation = JOptionPane.showOptionDialog(
                    null
                    , "Choose the desired operation:"
                    , "Options"
                    , JOptionPane.YES_NO_CANCEL_OPTION
                    , JOptionPane.QUESTION_MESSAGE
                    , null
                    , choises
                    , "Create Employee");

            if (operation == 0) {
                addEmployee.createEmployee();
            } else {
                break;
            }
        }
    }
}
