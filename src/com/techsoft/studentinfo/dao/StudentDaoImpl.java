package com.techsoft.studentinfo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.techsoft.studentinfo.dto.Student;
import com.techsoft.studentinfo.util.DbUtil;

public class StudentDaoImpl implements StudentDao {
	PreparedStatement ps = null;

	@Override
	public void savdStudentInfo(Student student) {
		String sql = "insert into student_details(student_name,roll,dob,college_name,subject,email,gender,department,image_url)values(?,?,?,?,?,?,?,?,?)";
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, student.getStudentName());
			ps.setInt(2, student.getRoll());
			ps.setDate(3, new java.sql.Date(student.getDob().getTime()));
			ps.setString(4, student.getCollegeName());
			ps.setString(5, student.getSubject());
			ps.setString(6, student.getEmail());
			ps.setString(7, student.getGender());
			ps.setString(8, student.getDepartment());
			ps.setString(9, student.getImageUrl());
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudentInfo(Student student) {
		String sql = "update student_details set student_name=?,roll=?,dob=?,college_name=?,subject=?,email=?,gender=?,department=?,image_url=? where id=?";
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, student.getStudentName());
			ps.setInt(2, student.getRoll());
			ps.setDate(3, new java.sql.Date(student.getDob().getTime()));
			ps.setString(4, student.getCollegeName());
			ps.setString(5, student.getSubject());
			ps.setString(6, student.getEmail());
			ps.setString(7, student.getGender());
			ps.setString(8, student.getDepartment());
			ps.setString(9, student.getImageUrl());
			ps.setInt(10, student.getId());
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteStudentInfo(int id) {
		String sql = "delete from student_details where id=?";
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Student> getAllStudentInfo() {
		List<Student> studentList = new ArrayList<Student>();
		String sql = "select * from student_details";
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setStudentName(rs.getString("student_name"));
				student.setRoll(rs.getInt("roll"));
				student.setDob(rs.getDate("dob"));
				student.setCollegeName(rs.getString("college_name"));
				student.setSubject(rs.getString("subject"));
				student.setEmail(rs.getString("email"));
				student.setGender(rs.getString("gender"));
				student.setDepartment(rs.getString("department"));
				studentList.add(student);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return studentList;
	}

	@Override
	public Student getStudentInfo(int id) {
		String sql = "select * from student_details where id=?";
		Student student=new Student();
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				student.setId(rs.getInt("id"));
				student.setStudentName(rs.getString("student_name"));
				student.setRoll(rs.getInt("roll"));
				student.setDob(rs.getDate("dob"));
				student.setCollegeName(rs.getString("college_name"));
				student.setSubject(rs.getString("subject"));
				student.setEmail(rs.getString("email"));
				student.setGender(rs.getString("gender"));
				student.setDepartment(rs.getString("department"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public String getImageUrl(int id) {
		String sql = "select image_url from student_details where id=?";
		String imageUrl="";
		try {
			ps=DbUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				imageUrl=rs.getString("image_url");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return imageUrl;
	}
	

}
