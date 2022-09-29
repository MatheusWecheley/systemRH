package entities.controllers;

import entities.Dependents;
import entities.Employee;

import java.util.List;

public interface IPayroll {
    void payRoll(Integer verifyId, List<Employee> s);
}
