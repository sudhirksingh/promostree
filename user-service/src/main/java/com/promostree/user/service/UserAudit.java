package com.promostree.user.service;

import com.promostree.domain.user.User;

public interface UserAudit {
	
	public boolean log(User user);

}
