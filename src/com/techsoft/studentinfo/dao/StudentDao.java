package com.techsoft.studentinfo.dao;

import java.util.List;

import com.techsoft.studentinfo.dto.Student;

public interface StudentDao {

	public void savdStudentInfo(Student student);

	public void updateStudentInfo(Student student);

	public void deleteStudentInfo(int id);

	public List<Student> getAllStudentInfo();

	public Student getStudentInfo(int id);
	
	public String getImageUrl(int id);
}
