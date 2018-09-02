package com.techsoft.studentinfo.service;

import java.util.List;

import com.techsoft.studentinfo.dto.User;

public interface UserService {
	public void saveUserInfo(User user);

	public void updateUserInfo(User user);

	public void deleteUserInfo(int id);

	public List<User> getAllUserInfo();

	public User getUserById(int id);

	public String getImageUrl(int id);

	public int checkUser(String userName, String password);

	public User checkEmail(String email);

}
