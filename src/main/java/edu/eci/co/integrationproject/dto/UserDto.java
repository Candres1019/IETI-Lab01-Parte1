package edu.eci.co.integrationproject.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserDto {

	private final String name;

	private final String lastName;

	private final String email;

	private final Boolean created;

}
