package com.techsoft.studentinfo.service;

import java.util.List;

import com.techsoft.studentinfo.dao.StudentDao;
import com.techsoft.studentinfo.dao.StudentDaoImpl;
import com.techsoft.studentinfo.dto.Student;

public class StudentServiceImpl implements StudentService{
	StudentDao studentDao=new StudentDaoImpl();

	@Override
	public void saveStudentInfo(Student student) {
		studentDao.savdStudentInfo(student);
	}

	@Override
	public void updateStudentInfo(Student student) {
		studentDao.updateStudentInfo(student);
	}

	@Override
	public void deleteStudentInfo(int id) {
		studentDao.deleteStudentInfo(id);
	}

	@Override
	public List<Student> getAllStudentInfo() {
		
		return studentDao.getAllStudentInfo();
	}

	@Override
	public Student getStudentInfo(int id) {
		
		return studentDao.getStudentInfo(id);
	}

	@Override
	public String getImageUrl(int id) {
		return studentDao.getImageUrl(id);
	}

}
