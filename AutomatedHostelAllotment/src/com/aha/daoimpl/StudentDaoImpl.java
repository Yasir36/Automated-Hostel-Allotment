package com.aha.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.aha.dao.StudentDao;
import com.aha.dbc.DBConnection;
import com.aha.model.StudentBean;

public class StudentDaoImpl implements StudentDao {

	Connection con = DBConnection.getConnection();
    @Override
    public List<StudentBean> getAllStudents() {
        StudentBean sb ;
        List<StudentBean> students = new ArrayList<>();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT * FROM students");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                sb = new StudentBean();
                sb.setId(rs.getInt("student_id"));
                sb.setFirstName(rs.getString("student_first_name"));
                sb.setLastName(rs.getString("student_last_name"));
                sb.setFatherName(rs.getString("student_father_name"));
                sb.setSurname(rs.getString("student_surname"));
                sb.setDateOfBirth(rs.getString("student_dob"));
                sb.setCNIC(rs.getString("student_cnic"));
                sb.setDistrict(rs.getString("student_district"));
                sb.setCurrentAddress(rs.getString("student_c_address"));
                sb.setPermanentAddress(rs.getString("student_perm_address"));
                sb.setPostalCode(rs.getInt("student_postal_code"));
                sb.setGuardianName(rs.getString("student_guardian_name"));
                sb.setGuardianCNIC(rs.getString("student_guardian_cnic"));
                sb.setDept(rs.getString("student_dept"));
                sb.setRollNo(rs.getString("student_rollNo"));
                sb.setEmail(rs.getString("student_email"));
                sb.setIsApproved(rs.getInt("student_approved_status"));
                students.add(sb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return students;
    }

    @Override
    public List<StudentBean> getUnApprovedStudents() {
        StudentBean sb = null;
        List<StudentBean> students = new ArrayList<>();
        try 
        {
            PreparedStatement pst = con.prepareStatement("select * from students where student_approved_status = 0");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                sb = new StudentBean();
                sb.setId(rs.getInt("student_id"));
                sb.setFirstName(rs.getString("student_first_name"));
                sb.setLastName(rs.getString("student_last_name"));
                sb.setFatherName(rs.getString("student_father_name"));
                sb.setSurname(rs.getString("student_surname"));
                sb.setDateOfBirth(rs.getString("student_dob"));
                sb.setCNIC(rs.getString("student_cnic"));
                sb.setDistrict(rs.getString("student_district"));
                sb.setCurrentAddress(rs.getString("student_c_address"));
                sb.setPermanentAddress(rs.getString("student_perm_address"));
                sb.setPostalCode(rs.getInt("student_postal_code"));
                sb.setGuardianName(rs.getString("student_guardian_name"));
                sb.setGuardianCNIC(rs.getString("student_guardian_cnic"));
                sb.setDept(rs.getString("student_dept"));
                sb.setRollNo(rs.getString("student_rollNo"));
                sb.setEmail(rs.getString("student_gemail"));
                sb.setIsApproved(rs.getInt("student_approved_status"));
                students.add(sb);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return students;

    }

    @Override
    public int addStudent(StudentBean student) {
            try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO students(student_first_name,student_last_name,student_father_name,student_surname,student_dob,student_cnic,student_c_address,student_perm_address,student_guardian_name,student_guardian_cnic,student_district,student_postal_code,student_rollNo,student_dept,student_email,student_approved_status)"
                                                        + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1,student.getFirstName());
            pst.setString(2,student.getLastName());
            pst.setString(3,student.getFatherName());            
            pst.setString(4,student.getSurname());
            pst.setString(5,student.getDateOfBirth());
            pst.setString(6,student.getCNIC());
            pst.setString(7,student.getCurrentAddress());
            pst.setString(8,student.getPermanentAddress());
            pst.setString(9,student.getGuardianName());
            pst.setString(10,student.getGuardianCNIC());
            pst.setString(11,student.getDistrict());
            pst.setInt(12,student.getPostalCode());
            pst.setString(13,student.getRollNo());
            pst.setString(14,student.getDept());
            pst.setString(15,student.getEmail());
            pst.setInt(16,student.isIsApproved());
            return pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    return 0;
    }

    @Override
    public int updateStudent(StudentBean student) {
        
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE students SET student_name = ?, student_father_name = ?,student_surname  = ?,student_dob = ?, student_cnic = ?, student_c_address = ?,student_perm_address = ?,student_guardian_name = ?,student_guardian_cnic = ?,student_district = ?,student_postal_code = ?,student_rollNo = ?,student_dept = ?,student_email = ?,student_approved_status = ?");
            pst.setString(1,student.getFirstName());
            pst.setString(2,student.getLastName());
            pst.setString(3,student.getFatherName());            
            pst.setString(4,student.getSurname());
            pst.setString(5,student.getDateOfBirth());
            pst.setString(6,student.getCNIC());
            pst.setString(7,student.getCurrentAddress());
            pst.setString(8,student.getPermanentAddress());
            pst.setString(9,student.getGuardianName());
            pst.setString(10,student.getGuardianCNIC());
            pst.setString(11,student.getDistrict());
            pst.setInt(12,student.getPostalCode());
            pst.setString(13,student.getRollNo());
            pst.setString(14,student.getDept());
            pst.setString(15,student.getEmail());
            pst.setInt(16,student.isIsApproved());
            return pst.executeUpdate();
        }
        catch(SQLException ex){ 
            System.out.println("Error in update student : "+ex.getMessage());
        }
        return 0;
    }
    
    @Override
    public int approveStudent(int student_id,int student_approved_status) {
        
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE students SET student_approved_status = ? WHERE student_id = ?");
            pst.setInt(1, student_approved_status);
            pst.setInt(2, student_id);
            return pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    @Override
    public int deleteStudent(int student_id) {
         try{
        PreparedStatement pst = con.prepareStatement("DELETE from students WHERE student_id = "+student_id);
        return pst.executeUpdate();
        }
        catch(SQLException ex){}
        
        return 0;
    }

}
