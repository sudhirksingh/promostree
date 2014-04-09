package com.promostree.delegator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.promostree.domain.user.UserShares;
import com.promotree.user.service.UserServices;

@Component
public class UserServiceDelegate {
	@Autowired
	UserServices userServices;
	
	public boolean saveUserShares(UserShares userShares){
	Boolean save=	userServices.saveUserShares(userShares);
		return save;
	}
}
