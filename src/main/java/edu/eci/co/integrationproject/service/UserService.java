package edu.eci.co.integrationproject.service;

import java.util.List;

import edu.eci.co.integrationproject.data.User;
import edu.eci.co.integrationproject.exception.UserServiceException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

	User create(User user);

	User findById(String id) throws UserServiceException;

	List<User> all();

	void deleteById(String id);

	User update(User user, String userId);

}
