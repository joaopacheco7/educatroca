package br.com.educatroca.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person extends PanacheEntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;

	@Column
	private String email;

	@Column
	private String password;


	public String getName() {
		return name;
	}


	public void setName(final String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(final String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(final String password) {
		this.password = password;
	}
}
