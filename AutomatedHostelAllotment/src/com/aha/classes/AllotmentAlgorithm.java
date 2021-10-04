package com.aha.classes;

import java.util.List;

import com.aha.dao.AlloteeDao;
import com.aha.daoimpl.AlloteeDaoImpl;

import java.util.ArrayList;
import java.util.Iterator;

public class AllotmentAlgorithm {
	private final Distance allDistances = new Distance();
	private final int ROOMS_AVAILABLE = 2;
	private final int MAX_RES_PER_ROOM = 3;
	public List<Room> alotApplicants(List<Allotee> applicants)
	{
		float[] distances = sortDistance(applicants);
		List<Room> rooms = new ArrayList<>();
		Room room = new Room();
		int rno=0;
		for (int i = 0; i < applicants.size(); i++) 
		{
			if(i%3==0) {
				room = new Room();
				rno++;
				room.setRoomNo(213+rno);
				room.setHostel("Shaikh Abdul Majeed Sindhi");
				
			}
			
			room.setResident(getApplicantByDistance(applicants, distances[i]));
			if(i%3==0)
				rooms.add(room);
		}
		
		return rooms;
	}
	
	public float[] sortDistance(List<Allotee> applicants)
	{
		float[] distances = getDistances(applicants);
		for(int i=0;i<distances.length;i++) {
			for (int j = 0; j < distances.length-i-1; j++) {
				if(distances[j]<distances[j+1])
				{
					float temp = distances[j];
					distances[j] = distances[j+1];
					distances[j+1] = temp;					
				}
			}
		}
			
		return distances;
	}
	
	public float[] getDistances(List<Allotee> applicants)
	{ 
		float distances[] = new float[applicants.size()];
		Allotee allotee;
		for (int i = 0;  i< distances.length; i++) {
			allotee = applicants.get(i);
			distances[i] = new Distance().getDistanceByDistrict(allotee.getDistrict());
		}
		
		return distances;
	}
	
	public Allotee getApplicantByDistance(List<Allotee> allotees,float distance)
	{
		for(int i=0;i<allotees.size();i++)
		{
			for(int j=0;j<allotees.size();j++)
			{
				if(distance== allDistances.getDistanceByDistrict(allotees.get(i).getDistrict()) && !allotees.get(i).isAlotted()) {
					allotees.get(i).setAlotted(true);
					return allotees.get(i);
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		AlloteeDao alloteeDAO = new AlloteeDaoImpl();
		AllotmentAlgorithm alloter = new AllotmentAlgorithm();
		List<Room> rooms = alloter.alotApplicants((alloteeDAO.getAllAllotees()));
		for (Room room : rooms) {
			System.out.println(room.toString());
		}
	}
}

