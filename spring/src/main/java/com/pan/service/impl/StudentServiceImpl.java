package com.pan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pan.dao.StudentMapper;
import com.pan.po.Student;
import com.pan.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentMapper studentMapper;
	public List<Student> liStudents() throws Exception {
		return studentMapper.liStudents();
	}

}
