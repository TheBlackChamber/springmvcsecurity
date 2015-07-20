package net.theblackchamber.springmvcsecurity.security;

import java.util.ArrayList;
import java.util.List;

import net.theblackchamber.crypto.providers.digest.WhirlpoolDigestProvider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class DbAuthenticationProvider implements AuthenticationProvider {

	// TODO insert DAO.

	private WhirlpoolDigestProvider hashProvider = new WhirlpoolDigestProvider();
	
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		String name = authentication.getName();
		String password = authentication.getCredentials().toString();

		// hash password
		String hashedPass = hashProvider.digest(password);
		
		List<String> permissions = authenticate(name, hashedPass);

		// If user has permissions then add them to the granted authorities
		if (!permissions.isEmpty()) {
			List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();

			// Populate granted auths from DB permissions
			for (String permission : permissions) {

				grantedAuths.add(new SimpleGrantedAuthority(permission));

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
	 * users list of permissions.
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	private List<String> authenticate(String username, String password) {
		
		List<String> permissions = new ArrayList<String>();
		
		// TODO See if users is in DB with hashed password

		// TODO populate permissions from database
		//NOTE: the ROLE_ is really important here!!!
		permissions.add("ROLE_USER");

		// Return list of users permissions
		return permissions;

	}

}
