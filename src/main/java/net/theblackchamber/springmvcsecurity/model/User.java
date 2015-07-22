package net.theblackchamber.springmvcsecurity.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class User {

	private String username;
	private String hashedPassword;
	private List<String> roles;
	
	public List<String> getRoles() {
		return roles == null ? Collections.unmodifiableList(new ArrayList<String>()) : Collections.unmodifiableList(roles);
	}
	public void setRoles(List<String> roles) {
		this.roles = new ArrayList<String>(roles);
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getHashedPassword() {
		return hashedPassword;
	}
	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
	
	
	
}
