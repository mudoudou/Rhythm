package com.pan.service;

import java.util.List;

import com.pan.po.Student;

public interface AdminService {
	String login(String username)throws Exception;
	List<Student> liStudents() throws Exception;
	void addstu(Student student)throws Exception;
}
