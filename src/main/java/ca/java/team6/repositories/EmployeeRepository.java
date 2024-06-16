package ca.java.team6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.java.team6.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Employee[] findByFirstName(String firstName);

}
