package edu.eci.co.integrationproject.controller;

import java.util.List;

import edu.eci.co.integrationproject.data.User;
import edu.eci.co.integrationproject.dto.UserDto;
import edu.eci.co.integrationproject.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

	private final UserService userService;

	private final ModelMapper modelmapper;

	@GetMapping
	public ResponseEntity<List<User>> all() {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.all());
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable String id) {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@PostMapping
	public ResponseEntity<User> create(@RequestBody UserDto userDto) {

		try {
			return ResponseEntity.status(HttpStatus.CREATED)
								 .body(userService.create(modelmapper.map(userDto, User.class)));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> update(@RequestBody UserDto userDto, @PathVariable String id) {

		try {
			return ResponseEntity.status(HttpStatus.OK)
								 .body(userService.update(modelmapper.map(userDto, User.class), id));
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable String id) {

		try {
			userService.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body(true);
		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
		}
	}

}
