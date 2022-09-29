package entities;

import entities.controllers.enums.Dependecy;

import java.time.LocalDate;
import java.util.Date;

public class Dependents extends Employee{
    protected String name;
    protected LocalDate birthDate;
    protected Dependecy modelDependecy;

    public Dependents() {
    }

    public Dependents(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Dependecy getModelDependecy() {
        return modelDependecy;
    }

    public void setModelDependecy(Dependecy modelDependecy) {
        this.modelDependecy = modelDependecy;
    }



}
