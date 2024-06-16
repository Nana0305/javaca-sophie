package ca.java.team6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.java.team6.entities.EmployeeLeaveRecord;

public interface EmployeeLeaveRecordRepository extends JpaRepository< EmployeeLeaveRecord, Long>{

}
