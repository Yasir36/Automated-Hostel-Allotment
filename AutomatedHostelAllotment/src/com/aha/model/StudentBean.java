package com.aha.model;

public class StudentBean {
	private int id;
    private String firstName;
    private String lastName;    
    private String fatherName;
    private String surname;
    private String dateOfBirth;
    private String CNIC;
    private String district;
    private String currentAddress;
    private String permanentAddress;
    private int postalCode;
    private String guardianName;
    private String guardianCNIC;
    private String rollNo;
    private String dept;
	private String email;
    private int isApproved;
    
    public StudentBean(String firstName, String lastName, String fatherName, String surname, String dateOfBirth,
			String cNIC, String district, String currentAddress, String permanentAddress, int postalCode,
			String guardianName, String guardianCNIC, String rollNo, String dept, String email, int isApproved) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		CNIC = cNIC;
		this.district = district;
		this.currentAddress = currentAddress;
		this.permanentAddress = permanentAddress;
		this.postalCode = postalCode;
		this.guardianName = guardianName;
		this.guardianCNIC = guardianCNIC;
		this.rollNo = rollNo;
		this.dept = dept;
		this.email = email;
		this.isApproved = isApproved;
	}

	public StudentBean() {
		super();
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
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
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the dept
	 */
	public String getDept() {
		return dept;
	}

	/**
	 * @param dept the dept to set
	 */
	public void setDept(String dept) {
		this.dept = dept;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

    
    /**
     * @return the fatherName
     */
    public String getFatherName() {
        return fatherName;
    }

    /**
     * @param fatherName the fatherName to set
     */
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
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
	 * @return the isApproved
	 */
	public int getIsApproved() {
		return isApproved;
	}

	/**
     * @return the dateOfBirth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the CNIC
     */
    public String getCNIC() {
        return CNIC;
    }

    /**
     * @param CNIC the CNIC to set
     */
    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    /**
     * @return the postalCode
     */
    public int getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return the guardianName
     */
    public String getGuardianName() {
        return guardianName;
    }

    /**
     * @param guardianName the guardianName to set
     */
    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    /**
     * @return the guardianCNIC
     */
    public String getGuardianCNIC() {
        return guardianCNIC;
    }

    /**
     * @param guardianCNIC the guardianCNIC to set
     */
    public void setGuardianCNIC(String guardianCNIC) {
        this.guardianCNIC = guardianCNIC;
    }

    /**
     * @return the isApproved
     */
    public int isIsApproved() {
        return isApproved;
    }

    /**
     * @param isApproved the isApproved to set
     */
    public void setIsApproved(int isApproved) {
        this.isApproved = isApproved;
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

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
}
