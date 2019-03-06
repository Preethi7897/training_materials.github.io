package org.cts.dao;

import org.cts.beans.User;

public interface UserDao {
	User validateUser(int uid);
}
