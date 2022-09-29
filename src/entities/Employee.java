package entities;


import entities.controllers.enums.Role;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String firstName;
    private String lastName;
    private String CPF;
    private String hire_date;
    private double salary;
    private int registration = 0;
    private Dependents dependents;
    private Role role;
    private String department;
    private List<Dependents> dependentsList = new ArrayList<>();

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

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

    public String getHire_date() {
        return hire_date;
    }

    public void setHire_date(String hire_date) {
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
        this.registration += registration ;
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

    public List<Dependents> getDependentsList() {
        return dependentsList;
    }

    public String toString() {
        return  "First Name: " + firstName + "\n"
                + "Last Name: " + lastName + "\n"
                + "Hire Date: " + hire_date + "\n"
                + "Salary: " + salary + "\n"
                + "Position: " + role + "\n"
                + "ID Register: " + registration + "\n";
    }
}
