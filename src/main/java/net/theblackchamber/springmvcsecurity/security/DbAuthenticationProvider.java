package net.theblackchamber.springmvcsecurity.security;

import java.util.ArrayList;
import java.util.List;

import net.theblackchamber.crypto.providers.digest.WhirlpoolDigestProvider;
import net.theblackchamber.springmvcsecurity.dao.UserDao;
import net.theblackchamber.springmvcsecurity.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class DbAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserDao userDao;

	private WhirlpoolDigestProvider hashProvider = new WhirlpoolDigestProvider();
	
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		String name = authentication.getName();
		String password = authentication.getCredentials().toString();

		// hash password
		String hashedPass = hashProvider.digest(password);
		
		User dbUser = authenticate(name, hashedPass);

		// If user has permissions then add them to the granted authorities
		if (dbUser != null) {
			List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();

			List<String> roles = dbUser.getRoles();
			
			// Populate granted auths from DB permissions
			for (String permission : roles) {

				grantedAuths.add(new SimpleGrantedAuthority("ROLE_" + permission));

			}

			Authentication auth = new UsernamePasswordAuthenticationToken(name,
					hashedPass, grantedAuths);
			return auth;
		} else {
			// If user has no permissions return null
			return null;
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	/**
	 * Method which will authenticate a user against the database and return the
	 * database user.
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	private User authenticate(String username, String password) {
		
		return userDao.getUser(username, password);

	}

}
