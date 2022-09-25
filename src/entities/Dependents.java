package entities;

import entities.controllers.enums.Dependecy;

import java.util.Date;

public class Dependents extends Employee{
    protected String name;
    protected String birthDate;
    protected Dependecy modelDependecy;

    public Dependents() {
    }

    public Dependents(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Dependecy getModelDependecy() {
        return modelDependecy;
    }

    public void setModelDependecy(Dependecy modelDependecy) {
        this.modelDependecy = modelDependecy;
    }



}
