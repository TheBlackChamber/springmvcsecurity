package net.theblackchamber.springmvcsecurity.dao;

import java.util.ArrayList;
import java.util.List;

import net.theblackchamber.springmvcsecurity.model.User;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	/**
	 * Fetch a user from the database by username and hashed password.
	 * @param username
	 * @param hashedPassword
	 * @return
	 */
	public User getUser(String username, String hashedPassword){
		
		//TODO real implementation here.
		User user = new User();
		user.setUsername(username);
		user.setHashedPassword(hashedPassword);
		
		List<String> roles = new ArrayList<String>();
		roles.add("USER");
		
		user.setRoles(roles);
		
		return user;
		
	}
	
}
