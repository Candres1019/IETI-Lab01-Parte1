package edu.eci.co.integrationproject.data;

import java.util.Date;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class User {

	private final String id;

	private final String name;

	private final String lastName;

	private final String email;

	private final Date createdAt;

}
