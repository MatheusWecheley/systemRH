package entities.controllers.implementation;

import entities.Dependents;
import entities.controllers.ICreateDependents;
import entities.controllers.enums.Dependecy;

import javax.swing.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreateDependencyImplementation implements ICreateDependents {
    String name;
    String birthDate;
    Dependecy dependecy;
    List<Dependents> dependentsList = new ArrayList<>();

    public void createDependency(){

        if(dependentsList.size() <= 1) {
            name = JOptionPane.showInputDialog(null, "Enter dependent name: ");
            birthDate = JOptionPane.showInputDialog(null, "Enter dependent birth date: ");
            dependecy = Dependecy.valueOf(
                    (JOptionPane.showInputDialog(null, "What is the degree of dependency?")).toUpperCase());



            Dependents dependents = new Dependents();

            dependents.setName(name);
            dependents.setBirthDate(birthDate);
            dependents.setModelDependecy(dependecy);

            dependentsList.add(dependents);

            JOptionPane.showMessageDialog(null
                    ,"Create Dependents \n" +
                            dependents.getName() +
                            "\n" +
                            dependents.getBirthDate() +
                            "\n" +
                            dependents.getModelDependecy());
        } else {
            JOptionPane.showMessageDialog(
                                null
                                , "You can't add more than 2 dependents"
                                , "Error add another dependents",
                                JOptionPane.ERROR_MESSAGE);
        }
    }

}
