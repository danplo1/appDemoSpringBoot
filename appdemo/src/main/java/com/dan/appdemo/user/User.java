package com.dan.appdemo.user;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;




@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;

	@Column(name = "email")
	@NotNull
	private String email;

	@Column(name = "password")
	@NotNull
	//@Length(min = 5, message = "Hasło musi składać się z minimum 5 znaków.")
	private String password;
	
	@Column(name = "name")
	@NotNull
	private String name;
	
	@Column(name = "last_name")
	@NotNull
	private String lastName;
	
	@Column(name = "active")
	@NotNull
	private int active;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable (name = "user_role", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name= "role_id"))
	
	private Set<Role> roles;
	
	@Transient //oznacza,że przy operacjach insert/update, ta składowa -przezroczysta- będzie pomijana, coś pomocniczego
	private String operation;
	
	@Transient
	private int RoleNumber;
	
	@Transient
	private String newPassword;
	
	// gettery i settery

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public int getRoleNumber() {
		return RoleNumber;
	}

	public void setRoleNumber(int roleNumber) {
		RoleNumber = roleNumber;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	
	

}
