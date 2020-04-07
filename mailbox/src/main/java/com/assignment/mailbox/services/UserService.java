package com.assignment.mailbox.services;

import com.assignment.mailbox.model.User;
import com.assignment.mailbox.model.UserLogin;

public interface UserService {
	public int createUser(User user);
	public boolean login(UserLogin userlogin);
}
