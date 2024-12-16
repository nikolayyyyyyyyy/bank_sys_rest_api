package bank_system.repositories;

import bank_system.models.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    public Employee findByTelephoneNumber(String telephone);
}
