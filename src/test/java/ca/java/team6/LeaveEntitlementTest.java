package ca.java.team6;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ca.java.team6.entities.LeaveEntitlement;
import ca.java.team6.repositories.LeaveEntitlementRepository;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class LeaveEntitlementTest {
	@Autowired
	private LeaveEntitlementRepository leRepo;
	@Test
	public void testSaveLE() {
		LeaveEntitlement newLE1 = new LeaveEntitlement();
		newLE1.setEmpType("Administrative");
		newLE1.setAnnualQty(14);
		newLE1.setMedicalQty(60);
		LeaveEntitlement savedLE1 = leRepo.save(newLE1);
		assertThat(savedLE1.getEmpType()).isEqualTo("Administrative");
		LeaveEntitlement retrievedLE1 = leRepo.findByEmpType("Administrative");
		assertThat(retrievedLE1).isNotNull();
		assertThat(retrievedLE1.getEmpType()).isEqualTo("Administrative");
		
		LeaveEntitlement newLE2 = new LeaveEntitlement();
		newLE2.setEmpType("Professional");
		newLE2.setAnnualQty(18);
		newLE2.setMedicalQty(60);
		LeaveEntitlement savedLE2 = leRepo.save(newLE2);
		assertThat(savedLE2.getEmpType()).isEqualTo("Professional");
		LeaveEntitlement retrievedLE2 = leRepo.findByEmpType("Professional");
		assertThat(retrievedLE2).isNotNull();
		assertThat(retrievedLE2.getEmpType()).isEqualTo("Professional");
	}

}
