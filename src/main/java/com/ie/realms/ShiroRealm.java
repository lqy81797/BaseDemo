package com.ie.realms;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;


public class ShiroRealm extends AuthorizingRealm {

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		System.out.println("First." + upToken.hashCode());

		String username = upToken.getUsername();

		System.out.println("�����ݿ��л�ȡ username: " + username + " ����Ӧ���û���Ϣ.");

		if ("unknown".equals(username)) {
			throw new UnknownAccountException("�û�������!");
		}

		if ("monster".equals(username)) {
			throw new LockedAccountException("�û�������");
		}

		Object principal = username;

		Object credentials = null; // "fc1709d0a95a6be30bc5926fdb7f22f4";
		if ("admin".equals(username)) {
			credentials = "df655ad8d3229f3269fad2a8bab59b6c";
		} else if ("user".equals(username)) {
			credentials = "098d2c478e9c11555ce2823231e02ec1";
		}

		String realmName = getName();

		ByteSource credentialsSalt = ByteSource.Util.bytes(username);

		SimpleAuthenticationInfo info = null; // new SimpleAuthenticationInfo(principal, credentials, realmName);
		info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
		return info;
	}

	public static void main(String[] args) {
		String hashAlgorithmName = "MD5";
		Object credentials = "admin";
		Object salt = ByteSource.Util.bytes("admin");
		;
		int hashIterations = 1024;

		Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
		System.out.println(result);
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Object principal = principals.getPrimaryPrincipal();

		Set<String> roles = new HashSet<>();
		roles.add("user");
		if ("admin".equals(principal)) {
			roles.add("admin");
		}

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);

		return info;
	}
}
