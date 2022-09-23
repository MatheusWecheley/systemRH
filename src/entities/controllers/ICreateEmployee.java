package entities.controllers;

import java.util.Date;

public interface ICreateEmployee {
    void createEmployee(String name, String lastName, String CPF, Date hire_date, double salary);
}
