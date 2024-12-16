package bank_system.services;

import bank_system.models.entities.Employee;

import java.util.Set;

public interface EmployeeService {

    public void createEmployee(Employee employee);
    public Employee getEmployeeById(long id);
    public Set<Employee> getAllEmployees();
}
