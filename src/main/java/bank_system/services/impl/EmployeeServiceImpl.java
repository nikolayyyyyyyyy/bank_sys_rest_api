package bank_system.services.impl;

import bank_system.models.entities.Employee;
import bank_system.repositories.EmployeeRepository;
import bank_system.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void createEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(long id) {
        this.employeeRepository.deleteById(id);
    }

    @Override
    public Employee getEmployeeById(long id) {
        return this.employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Employee> getAllEmployees() {
        return new HashSet<>(this.employeeRepository.findAll());
    }

    @Override
    public Employee getEmployeeByTelephoneNumber(String telephoneNumber) {
        return this.employeeRepository.findByTelephoneNumber(telephoneNumber);
    }
}
