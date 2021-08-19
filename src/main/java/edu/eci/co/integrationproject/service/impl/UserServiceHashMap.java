package edu.eci.co.integrationproject.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.eci.co.integrationproject.data.User;
import edu.eci.co.integrationproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserServiceHashMap implements UserService {

	private final HashMap<String, User> userHashMap;

	@Override public User create(final User user) {

		userHashMap.put(user.getId(), user);
		return user;
	}

	@Override public User findById(final String id) {

		if (userHashMap.containsKey(id)) {
			return userHashMap.get(id);
		}
		return null;
	}

	@Override public List<User> all() {

		return new ArrayList<>(userHashMap.values());
	}

	@Override public void deleteById(final String id) {

		userHashMap.remove(id);
	}

	@Override public User update(final User user, final String userId) {

		if (userHashMap.containsKey(userId)) {
			return userHashMap.put(userId, user);
		}
		return null;
	}
}
