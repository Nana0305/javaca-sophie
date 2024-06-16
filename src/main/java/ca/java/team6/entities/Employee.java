package ca.java.team6.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmpId", nullable = false)
    private long empId;


	@Column(name = "FirstName", nullable = false, length = 50)
    private String firstName;

    @Column(name = "LastName", nullable = false, length = 50)
    private String lastName;
    
    @ManyToOne
    @JoinColumn(name="EmpType", referencedColumnName = "EmpType", nullable=false)
    private LeaveEntitlement myLeaveEntitlement;
    
    @Column(name = "JoinDate", nullable = false)
    private Date joinDate; 

    @Column(name = "EmpStatus", nullable = false, length = 25)
    private String empStatus;
    
    @ManyToOne
    @JoinColumn(name = "MgrId", nullable=true)
    private Employee manager;
    
    @OneToMany (mappedBy = "manager")
    private List<Employee> subordinates;
    
    @Column(name="Password(Hash)", nullable=false, length=50)
    private String passWord;
    
    @OneToMany(mappedBy="employee")
    private List<CompensationClaimRecord> compensationClaimRecords;
    
	@OneToMany(mappedBy="employee")
    private List<EmployeeLeaveRecord> employeeLeaveRecords;
    
    @OneToMany(mappedBy="approveManager")
    private List<EmployeeLeaveRecord> managerIdLeaveRecords;
    
    @OneToMany(mappedBy="coveringEmployee")
    private List<EmployeeLeaveRecord> coveringIcs;
   
    public Employee()
    {
    	
    }
    
    public Employee(String firstName, String lastName, LeaveEntitlement myLeaveEntitlement, Date joinDate, String empStatus,Employee manager, String passWord) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.joinDate = joinDate;
        this.empStatus = empStatus;
        this.manager = manager;
        this.passWord = passWord;
        this.myLeaveEntitlement = myLeaveEntitlement;
        compensationClaimRecords = new ArrayList<CompensationClaimRecord>();
        employeeLeaveRecords = new ArrayList<EmployeeLeaveRecord>();
        managerIdLeaveRecords = new ArrayList<EmployeeLeaveRecord>();
        coveringIcs = new ArrayList<EmployeeLeaveRecord>();
        subordinates = new ArrayList<Employee>();
    }

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LeaveEntitlement getMyLeaveEntitlement() {
		return myLeaveEntitlement;
	}

	public void setMyLeaveEntitlement(LeaveEntitlement myLeaveEntitlement) {
		this.myLeaveEntitlement = myLeaveEntitlement;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public List<CompensationClaimRecord> getCompensationClaimRecords() {
		return compensationClaimRecords;
	}

	public void setCompensationClaimRecords(List<CompensationClaimRecord> compensationClaimRecords) {
		this.compensationClaimRecords = compensationClaimRecords;
	}

	public List<EmployeeLeaveRecord> getEmployeeLeaveRecords() {
		return employeeLeaveRecords;
	}

	public void setEmployeeLeaveRecords(List<EmployeeLeaveRecord> employeeLeaveRecords) {
		this.employeeLeaveRecords = employeeLeaveRecords;
	}

	public List<EmployeeLeaveRecord> getManagerIdLeaveRecords() {
		return managerIdLeaveRecords;
	}

	public void setManagerIdLeaveRecords(List<EmployeeLeaveRecord> managerIdLeaveRecords) {
		this.managerIdLeaveRecords = managerIdLeaveRecords;
	}

	public List<EmployeeLeaveRecord> getCoveringIcs() {
		return coveringIcs;
	}

	public void setCoveringIcs(List<EmployeeLeaveRecord> coveringIcs) {
		this.coveringIcs = coveringIcs;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", empType="
					+ myLeaveEntitlement + ", joinDate=" + joinDate + ", empStatus=" + empStatus + ", manager=" + manager
					+ ", passWord=" + passWord + "]";
	}

	public List<Employee> getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(List<Employee> subordinates) {
		this.subordinates = subordinates;
	}
}
