package entities;

import entities.controllers.enums.Dependecy;

import java.util.Date;

public class Dependents {
    private String name;
    private Date birthDate;
    private Dependecy dependecy;

    public Dependents() {
    }

    public Dependents(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Dependecy getDependecy() {
        return dependecy;
    }

    public void setDependecy(Dependecy dependecy) {
        this.dependecy = dependecy;
    }
}
