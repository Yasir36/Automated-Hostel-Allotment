package com.aha.classes;

public class Applicant {
	private int rollNo;
	private int distFromHomeToHostel;
	private String name;
	private String department;
	//private boolean alloted;
	
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer("{");
		sb.append(rollNo+",");
		sb.append(distFromHomeToHostel+",");
		sb.append(name+",");
		sb.append(department+",");
		sb.append("}");
		return sb.toString();
	}
	
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @param rollNo the rollNo to set
	 */
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	/**
	 * @return the rollNo
	 */
	public int getRollNo() {
		return rollNo;
	}
	/**
	 * @return the distFromHomeToHostel
	 */
	public int getDistFromHomeToHostel() {
		return distFromHomeToHostel;
	}
	/**
	 * @param distFromHomeToHostel the distFromHomeToHostel to set
	 */
	public void setDistFromHomeToHostel(int distFromHomeToHostel) {
		this.distFromHomeToHostel = distFromHomeToHostel;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the alloted
	 */
//	public boolean isAlloted() {
//		return alloted;
//	}
//	/**
//	 * @param alloted the alloted to set
//	 */
//	public void setAlloted(boolean alloted) {
//		this.alloted = alloted;
//	}

	
}
