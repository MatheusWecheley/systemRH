package entities.controllers;

import entities.Dependents;
import entities.Employee;

import java.util.List;

public interface ICreateDependents {
    Dependents createDependency(List<Dependents> dependentsList) throws Exception;
}
