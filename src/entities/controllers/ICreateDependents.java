package entities.controllers;

import entities.controllers.enums.Dependecy;

import java.util.Date;

public interface ICreateDependents {
    void createDependency(String name, Date birthDate, Dependecy dependecy);
}
