package org.cts.service;

import org.cts.beans.User;
import org.cts.dao.UserDao;
import org.cts.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
	UserDao dao=new UserDaoImpl();
	@Override
	public User validateUser(int uid) {
		User user=dao.validateUser(uid);
		return user;
	}

}
