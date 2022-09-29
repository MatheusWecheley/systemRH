package entities.controllers;

import entities.Dependents;

import java.util.List;

public interface ICreateDependents {
    Dependents createDependency(List<Dependents> dependentsList);
}
