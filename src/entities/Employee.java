package entities;


import entities.controllers.enums.Role;

import java.util.Date;

public class Employee {
    private String firstName;
    private String lastName;
    private String CPF;
    private Date hire_date;
    private double salary;
    private int registration;

    private Dependents dependents;
    private Role role;



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getRegistration() {
        return registration;
    }

    public void setRegistration(int registration) {
        this.registration = registration;
    }

    public Dependents getDependents() {
        return dependents;
    }

    public void setDependents(Dependents dependents) {
        this.dependents = dependents;
    }

    public Role getRole() {
        return role;
    }

    public void setCargo(Role role) {
        this.role = role;
    }
}
