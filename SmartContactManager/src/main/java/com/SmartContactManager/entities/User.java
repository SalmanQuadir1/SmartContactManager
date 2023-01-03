package com.SmartContactManager.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	private String email;
	private String role;
	private String imageUrl;
	private String enabled;	
	private String about;
	private String password;

	
	@OneToMany(cascade=CascadeType.ALL,mappedBy = "user")
	private List<Contact> contact=new ArrayList<Contact>();


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}


	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}


	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}


	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	/**
	 * @return the enabled
	 */
	public String getEnabled() {
		return enabled;
	}


	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}


	/**
	 * @return the about
	 */
	public String getAbout() {
		return about;
	}


	/**
	 * @param about the about to set
	 */
	public void setAbout(String about) {
		this.about = about;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the contact
	 */
	public List<Contact> getContact() {
		return contact;
	}


	/**
	 * @param contact the contact to set
	 */
	public void setContact(List<Contact> contact) {
		this.contact = contact;
	}


	public User(int id, String name, String description, String email, String role, String imageUrl, String enabled,
			String about, String password, List<Contact> contact) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.email = email;
		this.role = role;
		this.imageUrl = imageUrl;
		this.enabled = enabled;
		this.about = about;
		this.password = password;
		this.contact = contact;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	
	
	
	
	

}
