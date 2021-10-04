package com.aha.classes;

import java.util.ArrayList;
import java.util.List;

public class Distance implements Comparable<Distance> 
{
	float distanceInKM;
	String district;
	List<Distance> distances;
	Distance(float distanceInKM,String district)
	{
		this.distanceInKM = distanceInKM;
		this.district = district;
	}
	
	Distance()
	{
		Distance badin = new Distance(120.0f,"Badin");
		Distance umerkot = new Distance(162.50f,"Umerkot");
		Distance sanghar = new Distance(113.0f,"Sanghar");
		Distance nawabshah = new Distance(119.0f,"Nawabshah");
		Distance karachi = new Distance(152.0f,"Karachi");
		Distance larkana = new Distance(305.0f,"Larkana");
		Distance shikarpur = new Distance(354.0f,"Shikarpur");
		Distance naushehroFeroze = new Distance(193.0f,"Naushehro Feroze");
		Distance sukkur = new Distance(323.0f,"Sukkur");
		Distance kashmore = new Distance(469.0f,"Kashmore");
		Distance jacobabad = new Distance(397.0f,"Jacobabad");
		Distance ghotki = new Distance(390.0f,"Ghotki");
		Distance khairpur = new Distance(298.0f,"Khairpur");
		Distance dadu = new Distance(183.0f,"Dadu");
		Distance sujawal = new Distance(127.0f,"Sujawal");
		Distance thatta = new Distance(101.0f,"Thatta");
		
		distances = new ArrayList<>();
		
		distances.add(badin);
		distances.add(umerkot);
		distances.add(sanghar);
		distances.add(nawabshah);
		distances.add(karachi);
		distances.add(larkana);
		distances.add(shikarpur);
		distances.add(naushehroFeroze);
		distances.add(sukkur);
		distances.add(kashmore);
		distances.add(jacobabad);
		distances.add(ghotki);
		distances.add(khairpur);
		distances.add(dadu);
		distances.add(sujawal);
		distances.add(thatta);
		
	}

	public float getDistanceByDistrict(String district)
	{
		Distance distance;
		for(int i=0;i<distances.size();i++)
		{
			distance = distances.get(i);
			if(distance.district.equalsIgnoreCase(district))
				return distance.distanceInKM;
		}
		return 0.0f;
	}
	
	public List<Distance> getAllDistrictsDistances()
	{
		return distances;
	}
	
	public float getDistanceInKM()
	{
		return this.distanceInKM;
	}

	@Override
	public int compareTo(Distance distance) 
	{
		// TODO Auto-generated method stub
		if(distance.getDistanceInKM()>this.distanceInKM)
			return 1;
		else if (distance.getDistanceInKM()<this.distanceInKM)
			return -1;
		return 0;
	}
}
