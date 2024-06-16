package ca.java.team6;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ca.java.team6.entities.Employee;
import ca.java.team6.entities.LeaveEntitlement;
import ca.java.team6.repositories.EmployeeRepository;
import ca.java.team6.repositories.LeaveEntitlementRepository;

@SpringBootTest
public class EmployeeTest {
	@Autowired
	private EmployeeRepository employeeRepo;
	@Autowired
	private LeaveEntitlementRepository leRepo;
	@Test
	public void testSaveEmployee() {
		Employee employee1 = new Employee();
		employee1.setFirstName("John");
		employee1.setLastName("Tan");
		LeaveEntitlement retrievedLE = leRepo.findByEmpType("Administrative");
		employee1.setMyLeaveEntitlement(retrievedLE);
		employee1.setEmpStatus("active");
		employee1.setJoinDate(new Date());
		employee1.setPassWord("john123");
		employeeRepo.save(employee1);
		
		Employee employee2 = new Employee();
		employee2.setFirstName("Jane");
		employee2.setLastName("Lim");
		employee2.setMyLeaveEntitlement(leRepo.findByEmpType("Professional"));
		employee2.setEmpStatus("active");
		employee2.setJoinDate(new Date());
		employee2.setPassWord("jane123");
		employee2.setManager(employee1);
		employeeRepo.save(employee2);
		
		Employee employee3 = new Employee();
		employee3.setFirstName("Jamie");
		employee3.setLastName("Lee");
		employee3.setMyLeaveEntitlement(leRepo.findByEmpType("Professional"));
		employee3.setEmpStatus("active");
		employee3.setJoinDate(new Date());
		employee3.setPassWord("jamie123");
		employee2.setManager(employee1);
		Employee savedEmployee = employeeRepo.save(employee3);
		assertThat(savedEmployee.getEmpId()).isNotNull();
		assertThat(savedEmployee.getFirstName()).isEqualTo("Jamie");
		Employee[] retrievedEmployee = employeeRepo.findByFirstName("Jamie");
		assertThat(retrievedEmployee[retrievedEmployee.length-1].getFirstName()).isEqualTo("Jamie");
		
	}

}
