package com.base.shiro.realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.base.model.User;

public class UserRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//根据用户名数据库查找role、permission信息
		String username = (String) principals.getPrimaryPrincipal();

		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		Set<String> roles = new HashSet<>();
		roles.add("user:v1");
		// 数据库查找部分
		authorizationInfo.setRoles(roles);// 设置用户角色
		Set<String> permissions = new HashSet<>();
		permissions.add("look");
		// 数据库查找部分
		authorizationInfo.setStringPermissions(permissions);// 设置权限
		return authorizationInfo;
	}

	@SuppressWarnings("unused")
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		String username = (String) token.getPrincipal();
		//数据库查找部分,根据用户名查出用户数据
		//这里没不连接数据库
		User user = new User();
		user.setId(1);
		user.setUsername("wgw");
		user.setPassword("dcb414c994516157208900161497d8c1");
		user.setSalt("shiro");

		if (user == null) {
			throw new UnknownAccountException();// 没找到帐号
		}
		ByteSource credentialsSalt  = ByteSource.Util.bytes("shiro");
		// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), // 用户名
				user.getPassword(), // 密码
				credentialsSalt,// salt=username+salt
				getName() // realm name
		);
		return authenticationInfo;
	}

}
