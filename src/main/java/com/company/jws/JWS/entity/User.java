package com.company.jws.JWS.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
@NamedQuery(name = "user_findall", query = "select u from User u")
public class User {

	@Id
	private String email;

	private String fullName;
	private String gender;
	private String password;

}
