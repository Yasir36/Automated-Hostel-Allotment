package com.aha.classes;

public class Allotee {
	private int id;
	private String firstName;
	private String lastName;
	private String surname;
	private String fullName;
	private String district;
	private String permanentAddress;
	private String rollNo;
	private String dept;
	private boolean isAlotted = false;
	
	
	@Override
	public String toString() {
		return "Allotee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", surname=" + surname
				+ ", district=" + district + ", permanentAddress=" + permanentAddress + ", rollNo=" + rollNo + ", dept="
				+ dept + "]";
	}

	public Allotee(int id, String firstName, String lastName, String surname, String district, String permanentAddress, String rollNo,
			String dept) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.surname = surname;
		this.district = district;
		this.permanentAddress = permanentAddress;
		this.rollNo = rollNo;
		this.dept = dept;
		fullName = this.firstName+" "+ this.lastName+" "+ this.surname;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @return the permanentAddress
	 */
	public String getPermanentAddress() {
		return permanentAddress;
	}

	/**
	 * @return the rollNo
	 */
	public String getRollNo() {
		return rollNo;
	}

	/**
	 * @return the dept
	 */
	public String getDept() {
		return dept;
	}
	public void setAlotted(boolean isAlotted)
	{
		this.isAlotted=isAlotted;
	}
	/**
	 * @return the isAlotted
	 */
	public boolean isAlotted() {
		return isAlotted;
	}

	
}