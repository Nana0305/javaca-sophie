package ca.java.team6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.java.team6.entities.LeaveEntitlement;

public interface LeaveEntitlementRepository extends JpaRepository<LeaveEntitlement, String>{
	LeaveEntitlement findByEmpType(String empType);
}
