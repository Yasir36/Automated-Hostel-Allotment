package com.aha.dao;

import java.util.List;

import com.aha.classes.Allotee;

public interface AlloteeDao {
	public Allotee getAllotee(String rollNo);
	public List<Allotee> getAllAllotees();
}
