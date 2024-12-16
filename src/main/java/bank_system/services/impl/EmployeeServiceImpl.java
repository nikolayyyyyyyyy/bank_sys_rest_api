package bank_system.services.impl;

import bank_system.exceptions.EntityAlreadyExistException;
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
        if(this.employeeRepository.findByTelephoneNumber(employee.getTelephoneNumber()) != null){

            throw new EntityAlreadyExistException("Employee already exist in db!");
        }

        this.employeeRepository.save(employee);
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
}
