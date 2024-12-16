package bank_system.services.impl;

import bank_system.exceptions.EntityNotFoundInDbException;
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
        Employee employee = this.employeeRepository.findById(id).orElse(null);
        if(employee == null){

            throw new EntityNotFoundInDbException("Employee not found!");
        }

        this.employeeRepository.delete(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        Employee employee = this.employeeRepository.findById(id).orElse(null);
        if(employee == null){

            throw new EntityNotFoundInDbException("Employee not found!");
        }

        return employee;
    }

    @Override
    public Set<Employee> getAllEmployees() {
        if(this.employeeRepository.findAll().isEmpty()){

            throw new EntityNotFoundInDbException("Employee table is empty!");
        }

        return new HashSet<>(this.employeeRepository.findAll());
    }

    @Override
    public Employee getEmployeeByTelephoneNumber(String telephoneNumber) {
        if(this.employeeRepository.findByTelephoneNumber(telephoneNumber) == null){

            throw new EntityNotFoundInDbException("Employee not found!");
        }

        return this.employeeRepository.findByTelephoneNumber(telephoneNumber);
    }
}
