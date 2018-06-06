package com.ie.realms;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.ie.entities.User;
import com.ie.service.ShiroService;

public class ShiroRealm extends AuthenticatingRealm {
	
	@Autowired
	ShiroService shiroService;
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;

		String username = upToken.getUsername();

		User user = shiroService.getUserByUserName(username);
		
		Object principal = user;

		String password = user.getPassword();

		Object credentials = null; // "fc1709d0a95a6be30bc5926fdb7f22f4";
		if ("admin".equals(username)) {
			credentials = "df655ad8d3229f3269fad2a8bab59b6c";
		} else {
			credentials = password;
		}

		String realmName = getName();

		ByteSource credentialsSalt = ByteSource.Util.bytes(username);

		SimpleAuthenticationInfo info = null; 
//		info = new SimpleAuthenticationInfo(principal, credentials, realmName);
		info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
		return info;
	}


	public static void main(String[] args) {
		String hashAlgorithmName = "MD5";
		Object credentials = "admin";
		Object salt = ByteSource.Util.bytes("student");
		int hashIterations = 1024;
		
		Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
		System.out.println(result);
	}

}
