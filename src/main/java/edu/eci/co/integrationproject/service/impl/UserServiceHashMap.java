package edu.eci.co.integrationproject.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import edu.eci.co.integrationproject.data.User;
import edu.eci.co.integrationproject.exception.UserServiceException;
import edu.eci.co.integrationproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserServiceHashMap implements UserService {

	private static final AtomicInteger userIdCounter = new AtomicInteger(1);
	private final HashMap<String, User> userHashMap;

	@Override public User create(final User user) {

		user.setId(String.valueOf(userIdCounter.getAndIncrement()));
		userHashMap.put(user.getId(), user);
		return user;
	}

	@Override public User findById(final String id) throws UserServiceException {

		if (userHashMap.containsKey(id)) {
			return userHashMap.get(id);
		}
		throw new UserServiceException(UserServiceException.USER_NOT_FOUND);
	}

	@Override public List<User> all() {

		return new ArrayList<>(userHashMap.values());
	}

	@Override public void deleteById(final String id) {

		userHashMap.remove(id);
	}

	@Override public User update(final User user, final String userId) {

		user.setId(userId);
		userHashMap.put(userId, user);
		return user;
	}
}
