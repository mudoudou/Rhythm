package com.pan.dao;

import java.util.List;

import com.pan.po.Student;

public interface StudentMapper {
	List<Student> liStudents()throws Exception;
}
