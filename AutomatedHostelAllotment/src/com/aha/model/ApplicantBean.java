package com.aha.model;

public class ApplicantBean {
	private int id;
	private String firstName;
	private String lastName;
	private String rollNo;
	private String CNIC;
	private String challanNo;
	private String feesStatus;
	
	
	@Override
	public String toString() {
		return "ApplicantBean [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", rollNo=" + rollNo
				+ ", CNIC=" + CNIC + ", challanNo=" + challanNo + ", feesStatus=" + feesStatus + "]";
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the rollNo
	 */
	public String getRollNo() {
		return rollNo;
	}
	/**
	 * @param rollNo the rollNo to set
	 */
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	/**
	 * @return the challanNo
	 */
	public String getChallanNo() {
		return challanNo;
	}
	/**
	 * @param challanNo the challanNo to set
	 */
	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}
	/**
	 * @return the feesStatus
	 */
	public String getFeesStatus() {
		return feesStatus;
	}
	/**
	 * @param feesStatus the feesStatus to set
	 */
	public void setFeesStatus(String feesStatus) {
		this.feesStatus = feesStatus;
	}
	/**
	 * @return the cNIC
	 */
	public String getCNIC() {
		return CNIC;
	}
	/**
	 * @param cNIC the cNIC to set
	 */
	public void setCNIC(String cNIC) {
		CNIC = cNIC;
	}
	
	
}
