package com.aha.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.aha.dao.ApplicantDao;
import com.aha.dbc.DBConnection;
import com.aha.model.ApplicantBean;

public class ApplicantDaoImpl implements ApplicantDao{
	Connection con = DBConnection.getConnection();
	@Override
	public List<ApplicantBean> getUnapprovedApplicants() {
		ApplicantBean applicant = null;
        List<ApplicantBean> applicants = new ArrayList<>();
        try 
        {
            PreparedStatement pst = con.prepareStatement("select students.student_id,students.student_cnic,students.student_rollNo,students.student_first_name,students.student_last_name,fees.challan_no,fees.fees_status FROM students INNER JOIN fees ON students.student_rollNo=fees.student_rollNo WHERE students.student_approved_status = 0");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                applicant = new ApplicantBean();
                applicant.setId(rs.getInt("student_id"));
                applicant.setFirstName(rs.getString("student_first_name"));
                applicant.setLastName(rs.getString("student_last_name"));
                applicant.setCNIC(rs.getString("student_cnic"));
                applicant.setRollNo(rs.getString("student_rollNo"));
                applicant.setChallanNo(rs.getString("challan_no"));
                applicant.setFeesStatus(rs.getString("fees_status"));
                applicants.add(applicant);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return applicants;
	}
	
	@Override
	public List<ApplicantBean> getApprovedApplicants() {
		ApplicantBean applicant = null;
        List<ApplicantBean> applicants = new ArrayList<>();
        try 
        {
            PreparedStatement pst = con.prepareStatement("select students.student_id,students.student_cnic,students.student_rollNo,students.student_first_name,students.student_last_name,fees.challan_no,fees.fees_status FROM students INNER JOIN fees ON students.student_rollNo=fees.student_rollNo WHERE students.student_approved_status = 1");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                applicant = new ApplicantBean();
                applicant.setId(rs.getInt("student_id"));
                applicant.setFirstName(rs.getString("student_first_name"));
                applicant.setLastName(rs.getString("student_last_name"));
                applicant.setCNIC(rs.getString("student_cnic"));
                applicant.setRollNo(rs.getString("student_rollNo"));
                applicant.setChallanNo(rs.getString("challan_no"));
                applicant.setFeesStatus(rs.getString("fees_status"));
                applicants.add(applicant);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return applicants;
	}

	@Override
	public String getApplicantFeesStatus(String rollNo) {
		String f_status="";
		try {
			PreparedStatement pst = con.prepareStatement("SELECT fees_status FROM fees WHERE student_rollNo=?");
			if(!rollNo.equals(""))
				pst.setString(1, rollNo);
			else
				return null;
			ResultSet rs = pst.executeQuery();
			if(rs.next())
				f_status = rs.getString("fees_status");
			return f_status;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int addApplicant(ApplicantBean applicant) {
		try {
			PreparedStatement pst = con.prepareStatement("INSERT into fees(student_rollNo,fees_status) VALUES(?,?)");
			pst.setString(1, applicant.getRollNo());
			pst.setString(2, applicant.getFeesStatus());
			return pst.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
