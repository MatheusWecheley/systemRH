package entities.controllers.implementation;

import entities.Dependents;
import entities.controllers.ICreateDependents;
import entities.controllers.enums.Dependecy;

import java.util.Date;

public class CreateDependencyImplementation implements ICreateDependents {
    String name;
    Date birthDate;
    Dependecy dependecy;
    Dependents dependents = new Dependents();

    public void createDependency(String name, Date birthDate, Dependecy dependecy){
        this.name = name;
        this.birthDate = birthDate;
        this.dependecy = dependecy;

        dependents.setName(name);
        dependents.setBirthDate(birthDate);
        dependents.setDependecy(dependecy);

    }
}
