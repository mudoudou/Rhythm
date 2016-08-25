package com.pan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pan.dao.AdminMapper;
import com.pan.po.Admin;
import com.pan.po.Student;
import com.pan.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired AdminMapper adminMapper;
	public String login(String username) throws Exception {
		
		return adminMapper.login(username);
	}
	public List<Student> liStudents() throws Exception {
		
		return adminMapper.liStudents();
	}
	public void addstu(Student student) throws Exception {
		adminMapper.addstu(student);
	}



}
