package ca.java.team6.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class LeaveEntitlement {
	
	@Id
	@Column(name="EmpType", length=50)
	private String empType;
	
	@Column(name="AnnualQty")
	private int annualQty;
	
	@Column(name="MedicalQty")
	private int medicalQty;
	
	@OneToMany(mappedBy="myLeaveEntitlement")
	private List<Employee> employees;
	
	
	public LeaveEntitlement(){}
	
	public LeaveEntitlement(String empType, int annualQty, int medicalQty)
	{
		this.empType = empType;
		this.annualQty = annualQty;
		this.medicalQty = medicalQty;
		employees = new ArrayList<Employee>();
	}
	
	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}
	
	public int getAnnualQty() {
		return annualQty;
	}
	public void setAnnualQty(int annualQty) {
		this.annualQty = annualQty;
	}
	public int getMedicalQty() {
		return medicalQty;
	}
	public void setMedicalQty(int medicalQty) {
		this.medicalQty = medicalQty;
	}
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	@Override
	public String toString() {
		return "LeaveEntitlement [empType=" + empType + ", annualQty=" + annualQty + ", medicalQty=" + medicalQty + "]";
	}
	
}
