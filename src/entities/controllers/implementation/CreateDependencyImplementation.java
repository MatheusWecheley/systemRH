package entities.controllers.implementation;

import entities.Dependents;
import entities.controllers.ICreateDependents;
import entities.controllers.enums.Dependecy;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CreateDependencyImplementation implements ICreateDependents {
    String name;
    String birthDate;
    Dependecy dependecy;

    public Dependents createDependency(List<Dependents> dependentsList){

        Dependents dependents = new Dependents();

        if(dependentsList.size() <= 1) {
            name = JOptionPane.showInputDialog(null, "Enter dependent name: ");
            birthDate = JOptionPane.showInputDialog(null, "Enter dependent birth date: ");
            dependecy = Dependecy.valueOf(
                    (JOptionPane.showInputDialog(null, "What is the degree of dependency?")).toUpperCase());

            dependents.setName(name);
            dependents.setBirthDate(birthDate);
            dependents.setModelDependecy(dependecy);

            JOptionPane.showMessageDialog(null
                    , "Create Dependents \n" +
                            dependents.getName() +
                            "\n" +
                            dependents.getBirthDate() +
                            "\n" +
                            dependents.getModelDependecy());

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
