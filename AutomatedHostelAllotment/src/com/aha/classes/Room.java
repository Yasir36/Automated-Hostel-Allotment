package com.aha.classes;

import java.util.ArrayList;
import java.util.List;

public class Room {
	private List<Allotee> residents;
	private int roomNo;
	private String hostel;
	private final int MAX_RESIDENTS_PER_ROOM = 3;
	private int noOfResidents = 0;
	//boolean occupied = false;

	
	public Room()
	{
		residents = new ArrayList<>(MAX_RESIDENTS_PER_ROOM);
		roomNo+=1;
	}
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer("{\n");
		for(int i=0; i<MAX_RESIDENTS_PER_ROOM;i++) 
			sb.append(residents.get(i)+",\n");
		sb.append(roomNo+",\n");
		sb.append(hostel+",\n");
		sb.append("}");
		return sb.toString();
	}
	/**
	 * @return the residents
	 */
	public List<Allotee> getResidents() {
		return residents;
	}
	/**
	 * @return the resident
	 */
	public Allotee getResident(int index) {
		return residents.get(index);
	}
	/**
	 * @param residents the residents to set
	 */
	public void setResident(Allotee resident) {
		if(noOfResidents<3) {
			
			this.residents.add(noOfResidents,resident);
			noOfResidents++;
		}
		else {
			System.out.println("Room is Full");
		}
	}
	/**
	 * @return the roomNo
	 */
	public int getRoomNo() {
		return roomNo;
	}
	/**
	 * @param roomNo the roomNo to set
	 */
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	/**
	 * @return the hostel
	 */
	public String getHostel() {
		return hostel;
	}
	/**
	 * @param hostel the hostel to set
	 */
	public void setHostel(String hostel) {
		this.hostel = hostel;
	}
	/**
	 * @return the occupied
	 */
//	public boolean isOccupied() {
//		return occupied;
//	}
//	/**
//	 * @param occupied the occupied to set
//	 */
//	public void setOccupied(boolean occupied) {
//		this.occupied = occupied;
//	}
	
}
