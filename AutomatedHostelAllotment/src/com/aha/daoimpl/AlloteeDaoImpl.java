package com.aha.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.aha.classes.Allotee;
import com.aha.dao.AlloteeDao;
import com.aha.dbc.DBConnection;

public class AlloteeDaoImpl implements AlloteeDao {
	Connection con = DBConnection.getConnection();
	@Override
	public Allotee getAllotee(String rollNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Allotee> getAllAllotees() {
		List<Allotee> allotees = new ArrayList<>();
		Allotee allotee;
		try {
			PreparedStatement pst = con.prepareStatement("SELECT student_id,student_first_name,student_last_name,student_surname,student_perm_address,student_district,student_rollNo,student_dept FROM students WHERE student_approved_status=1");
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				allotee = new Allotee(
						rs.getInt("student_id"),
						rs.getString("student_first_name"),
						rs.getString("student_last_name"),
						rs.getString("student_surname"),
						rs.getString("student_district"),
						rs.getString("student_perm_address"),
						rs.getString("student_rollNo"),
						rs.getString("student_dept")
						);
				System.out.println(allotee.toString());
				allotees.add(allotee);
			}
			return allotees;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
