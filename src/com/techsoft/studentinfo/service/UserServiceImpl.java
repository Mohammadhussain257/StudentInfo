package com.techsoft.studentinfo.service;

import java.util.List;

import com.techsoft.studentinfo.dao.UserDao;
import com.techsoft.studentinfo.dao.UserDaoImpl;
import com.techsoft.studentinfo.dto.User;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();

	@Override
	public void saveUserInfo(User user) {
		userDao.saveUserInfo(user);
	}

	@Override
	public void updateUserInfo(User user) {
		userDao.updateUserInfo(user);
	}

	@Override
	public void deleteUserInfo(int id) {
		userDao.deleteUserInfo(id);
	}

	@Override
	public List<User> getAllUserInfo() {
		return userDao.getAllUserInfo();
	}

	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	@Override
	public String getImageUrl(int id) {
		return userDao.getImageUrl(id);
	}

	@Override
	public int checkUser(String userName, String password) {
		return userDao.checkUser(userName, password);
	}

	@Override
	public User checkEmail(String email) {
		return userDao.checkEmail(email);
	}

}
