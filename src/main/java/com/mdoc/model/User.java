package com.mdoc.model;

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

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    @Column(name = "email")
    @Email(message = "Please provide a valid Email Id!!")
    @NotEmpty(message = "Please enter email id")
    private String email;
    @Column(name = "password")
    @Length(min = 5, message = "Password must contain minimum of 5 characters!!")
    @NotEmpty(message = "Please enter password!!!")
    // @Transient
    private String password;
    @Column(name = "name")
    @NotEmpty(message = "Please provide name")
    private String name;
    @Column(name = "last_name")
    @NotEmpty(message = "Please provide last name")
    private String lastName;
    @Column(name = "active")
    private int active;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    
    public void setId(int id) {
	this.id = id;
    }

    public int getId() {
	return id;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getEmail() {
	return email;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getPassword() {
	return password;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setActive(int active) {
	this.active = active;
    }

    public int getActive() {
	return active;
    }

    public void setRoles(Set<Role> roles) {
	this.roles = roles;
    }

    public Set<Role> getRoles() {
	return roles;
    }

}