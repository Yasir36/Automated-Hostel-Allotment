//package com.aha.classes;
//
//import java.util.List;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.Scanner;
//
//
//
//
//public class Main {
//
//	public static void main(String[] args) {
//		System.out.println("..Automated hostel Allotment Algorithm...");
//		System.out.println("Please Enter The Applicant's Details(rollNo(only number part),distance from hostel,name,dept(in this order)");
//		Scanner sc = new Scanner(System.in);	
//		List<Applicant> applicants = new ArrayList<>();
//		List<Room> rooms;
//		AllotmentAlgorithm alloter = new AllotmentAlgorithm();
//		Applicant applicant;
//		
//		for(int i=0;i<4;i++)
//		{
//			System.out.println("Please Enter The Applicant's Details(rollNo(only number part),distance from hostel,name,dept(in this order)");
//			applicant = new Applicant();
//			System.out.println("..RollNo...");
//			applicant.setRollNo(sc.nextInt());
//			System.out.println("..Distance...");
//			applicant.setDistFromHomeToHostel(sc.nextInt());
//			System.out.println("..Name...");
//			applicant.setName(sc.next());
//			System.out.println("..Department...");
//			applicant.setDepartment(sc.next());
//			
//			applicants.add(applicant);
//		}
//		sc.close();
//		System.out.println("..Starting Allotment...");
//		//rooms = alloter.alotApplicants(applicants);
//		
//		//Iterator<Room> itr = rooms.iterator();
//		
//	//	while(itr.hasNext())
//		{
//			
//		//	Room room = itr.next();
//		//	if(room!=null)
//		//	System.out.println(room);
//		}
//	}
//
//}
