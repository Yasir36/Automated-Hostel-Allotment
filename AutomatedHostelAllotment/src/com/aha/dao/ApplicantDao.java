package com.aha.dao;

import java.util.List;

import com.aha.model.ApplicantBean;

public interface ApplicantDao {
	public List<ApplicantBean> getApprovedApplicants();
	public List<ApplicantBean> getUnapprovedApplicants();
	
	public int addApplicant(ApplicantBean applicant);
	public String getApplicantFeesStatus(String id);
}
