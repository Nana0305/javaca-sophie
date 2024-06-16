package ca.java.team6.entities;

import java.sql.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "EmployeeLeaveRecords")
public class EmployeeLeaveRecord {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LeaveID", nullable = false)
    private Long leaveId;

    @Column(name = "LeaveQty", nullable = false)
    private double leaveQty;
    
    @Column(name = "LeaveDate", nullable = false)
    private Date leaveDate; 
    
    @ManyToOne
    @JoinColumn(name="EmpId", referencedColumnName = "EmpId", nullable=false)
    private Employee employee;

    @Column(name = "LeaveType", nullable = false, length = 50)
    private String leaveType;

    @Column(name = "Status", nullable = false, length = 50)
    private String status;
    
    @ManyToOne
    @JoinColumn(name="ApprMgrId", referencedColumnName = "EmpId", nullable=true)
    private Employee approveManager;
    
    @ManyToOne
    @JoinColumn(name = "CoveringIC", referencedColumnName="EmpId", nullable=true)
    private Employee coveringEmployee;
    
    @Column(name = "AddReason", columnDefinition = "TEXT", nullable=false)
    private String additionalReason;
    
    @Column(name = "Ovs")
    private boolean isOverseas;

    @Column(name = "ContactDetail", columnDefinition = "TEXT")
    private String contactDetail;

    
    public EmployeeLeaveRecord() {}
    
    public EmployeeLeaveRecord(double leaveQty, Date leaveDate, Employee employee,
            String leaveType, String status, String additionalReason, boolean isOverseas) {
    	
    	this.leaveQty = leaveQty;
    	this.leaveDate = leaveDate;
    	this.employee = employee;
    	this.leaveType = leaveType;
    	this.status = status;
    	this.additionalReason = additionalReason;
    	this.isOverseas = isOverseas;
    	
    }


	public long getLeaveId() {
		return leaveId;
	}


	public void setLeaveId(long leaveId) {
		this.leaveId = leaveId;
	}


	public double getLeaveQty() {
		return leaveQty;
	}


	public void setLeaveQty(double leaveQty) {
		this.leaveQty = leaveQty;
	}


	public Date getLeaveDate() {
		return leaveDate;
	}


	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public String getLeaveType() {
		return leaveType;
	}


	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee getApproveManager() {
		return approveManager;
	}

	public void setApproveManager(Employee approveManager) {
		this.approveManager = approveManager;
	}

	public Employee getCoveringEmployee() {
		return coveringEmployee;
	}


	public void setCoveringEmployee(Employee coveringEmployee) {
		this.coveringEmployee = coveringEmployee;
	}

	public String getContactDetail() {
		return contactDetail;
	}


	public void setContactDetail(String contactDetail) {
		this.contactDetail = contactDetail;
	}

	public boolean isOverseas() {
		return isOverseas;
	}

	public void setOverseas(boolean isOverseas) {
		this.isOverseas = isOverseas;
	}

	public String getAdditionalReason() {
		return additionalReason;
	}

	public void setAdditionalReason(String additionalReason) {
		this.additionalReason = additionalReason;
	}
    
	@Override
	public String toString() {
			return "EmployeeLeaveRecord [leaveId=" + leaveId + ", leaveQty=" + leaveQty + ", leaveDate=" + leaveDate
					+ ", employee=" + employee + ", leaveType=" + leaveType + ", status=" + status + ", approveManager="
					+ approveManager + ", coveringEmployee=" + coveringEmployee + ", additionalReason=" + additionalReason
					+ ", isOverseas=" + isOverseas + ", contactDetail=" + contactDetail
					+ "]";
	}
    
}
