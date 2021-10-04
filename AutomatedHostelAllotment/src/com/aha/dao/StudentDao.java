package com.aha.dao;

import java.util.List;

import com.aha.model.StudentBean;

public interface StudentDao {
	public List<StudentBean> getAllStudents();
    public List<StudentBean> getUnApprovedStudents();
    public int deleteStudent(int student_id);
    public int updateStudent(StudentBean student);
    public int approveStudent(int student_id,int student_approved_status);
    public int addStudent(StudentBean student);	
}
