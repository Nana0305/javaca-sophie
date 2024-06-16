package ca.java.team6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.java.team6.entities.CompensationClaimRecord;

public interface CompensationClaimRecordRepository extends JpaRepository<CompensationClaimRecord, Long> {

}
