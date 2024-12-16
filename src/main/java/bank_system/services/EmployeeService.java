package bank_system.services;

import bank_system.models.entities.Employee;

import java.util.Set;

public interface EmployeeService {

    public void createEmployee(Employee employee);
    public void updateEmployee(Employee employee);
    public void deleteEmployeeById(long id);
    public Employee getEmployeeById(long id);
    public Set<Employee> getAllEmployees();
    public Employee getEmployeeByTelephoneNumber(String telephoneNumber);
}
