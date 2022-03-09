package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDao {
	private static List<User> users = new ArrayList();

	private static int countUser = 3;
	static {
		users.add(new User(12, "sabya", new Date()));
		users.add(new User(15, "sachi", new Date()));
		users.add(new User(17, "manoj", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {

		if (user.getId() == null) {
			user.setId(++countUser);
		}
		users.add(user);
		return user;
	}

	public User findById(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public User deleteById(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				users.remove(user);
				return user;
			}
		}
		return null;
	}

}
