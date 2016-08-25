package com.pan.dao;

import java.util.List;

import com.pan.po.Student;

public interface AdminMapper {
	String login(String username)throws Exception;
	List<Student> liStudents() throws Exception;
	void addstu(Student student)throws Exception;
}
