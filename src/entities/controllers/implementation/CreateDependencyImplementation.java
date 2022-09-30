package entities.controllers.implementation;

import entities.Dependents;
import entities.Employee;
import entities.controllers.ICreateDependents;
import entities.controllers.enums.Dependecy;

import javax.swing.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CreateDependencyImplementation implements ICreateDependents {
    String name;
    String birthDate;
    Dependecy dependecy;

    public Dependents createDependency(List<Dependents> dependentsList) throws Exception {

        Dependents dependents = new Dependents();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        if(dependentsList.size() <= 1) {
            try {
                dependents.setName(JOptionPane.showInputDialog(null, "Enter dependent name: "));
                birthDate = JOptionPane.showInputDialog(null, "Enter dependent birth date: ");
                LocalDate date = LocalDate.parse(birthDate, fmt);
                dependents.setModelDependecy(Dependecy.valueOf((JOptionPane.showInputDialog(null, "What is the degree of dependency?")).toUpperCase()));


                if(dependents.getModelDependecy().toString() == "SON"){
                    if (LocalDate.now().getYear() - date.getYear() < 18) {
                        dependents.setBirthDate(date);
                    } else {
                        JOptionPane.showMessageDialog(null, "It is not possible to register a new dependent under the age of 18");
                        return null;
                    }
                }
                dependents.setBirthDate(date);
                JOptionPane.showMessageDialog(null
                        , "Create Dependents \n" +
                                dependents.getName() +
                                "\n" +
                                dependents.getBirthDate() +
                                "\n" +
                                dependents.getModelDependecy());
                return dependents;

            }catch (DateTimeException e) {
                JOptionPane.showMessageDialog(null
                        , "Date Format invalid"
                        , "Date error"
                        , JOptionPane.ERROR_MESSAGE);
            }catch (IllegalArgumentException ie) {
                JOptionPane.showMessageDialog(null
                        ,"Dependent invalid!"
                        , "Error Dependents"
                        , JOptionPane.ERROR_MESSAGE);
            }
            return dependents;

        } else {
            JOptionPane.showMessageDialog(
                    null
                    , "You can't add more than 2 dependents"
                    , "Error add another dependents",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
