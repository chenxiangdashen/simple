package com.example.simple.security.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

/**
 * SpringSecurity用户的实体
 * 注意:这里必须要实现UserDetails接口
 * @Author Sans
 * @CreateTime 2019/10/1 20:23
 */
@Data
public class SelfUserEntity implements Serializable, UserDetails {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 用户名
	 */
	private String username;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		isAccountNonExpired = accountNonExpired;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		isAccountNonLocked = accountNonLocked;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		isCredentialsNonExpired = credentialsNonExpired;
	}

	public void setEnabled(boolean enabled) {
		isEnabled = enabled;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 密码
	 */
	private String password;
	/**
	 * 状态:NORMAL正常  PROHIBIT禁用
	 */
	private String status;


	/**
	 * 用户角色
	 */
	private Collection<GrantedAuthority> authorities;
	/**
	 * 账户是否过期
	 */
	private boolean isAccountNonExpired = false;
	/**
	 * 账户是否被锁定
	 */
	private boolean isAccountNonLocked = false;
	/**
	 * 证书是否过期
	 */
	private boolean isCredentialsNonExpired = false;
	/**
	 * 账户是否有效
	 */
	private boolean isEnabled = true;


	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return isAccountNonExpired;
	}
	@Override
	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}
	@Override
	public boolean isEnabled() {
		return isEnabled;
	}
}