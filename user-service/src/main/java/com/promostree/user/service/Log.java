package com.promostree.user.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.promostree.domain.user.User;
@Component
public class Log {
private List<User> users;

public List<User> getUsers() {
	return users;
}

public void setUsers(List<User> users) {
	this.users = users;
}


}
