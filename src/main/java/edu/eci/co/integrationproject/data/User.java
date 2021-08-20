package edu.eci.co.integrationproject.data;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private String id;

	private String name;

	private String lastName;

	private String email;

	private Date createdAt;

}
