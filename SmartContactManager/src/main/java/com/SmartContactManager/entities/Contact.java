package com.SmartContactManager.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Contact {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	private String name;
	private String description;
	private String email;
	private String phone;
	private String image;
	private String work;
	private String secondName;
	
	@ManyToOne
	private User user;
	
	/**
	 * @return the user
	 */
	
	
	
	public User getUser() {
		return user;
	}
	/**
	 * @return the work
	 */
	public String getWork() {
		return work;
	}
	/**
	 * @param work the work to set
	 */
	public void setWork(String work) {
		this.work = work;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	public int getCid() {
		return cid;
	}
	/**
	 * @param cid the cid to set
	 */
	public void setCid(int cid) {
		this.cid = cid;
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
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getSecondName() {
		return secondName;
	}
	
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public Contact(int cid, String name, String description, String email, String phone, String image, String work,
			String secondName, User user) {
		super();
		this.cid = cid;
		this.name = name;
		this.description = description;
		this.email = email;
		this.phone = phone;
		this.image = image;
		this.work = work;
		this.secondName = secondName;
		this.user = user;
	}
	
	/*
	 * @Override public String toString() { return "Contact [cid=" + cid + ", name="
	 * + name + ", description=" + description + ", email=" + email + ", phone=" +
	 * phone + ", image=" + image + ", work=" + work + ", secondName=" + secondName
	 * + ", user=" + user + "]"; }
	 */
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}
