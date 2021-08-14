package com.apex.homework.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.apex.homework.entity.Transaction;
import com.apex.homework.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Setter
@Getter
public class UserDetailsImpl implements UserDetails {

	public static UserDetailsImpl build(User user) {
		return new UserDetailsImpl(
				user.getId(), 
				user.getUsername(),
				user.getPassword(),
				user.getTransactions());
	}
	private Collection<? extends GrantedAuthority> authorities;
	private String id;

	@JsonIgnore
	private String password;
	private List<Transaction> transactions;
	private String username;

	public UserDetailsImpl(String id, String username, String password, List<Transaction> transactions) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.transactions = transactions;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
