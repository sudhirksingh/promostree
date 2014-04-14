package com.promostree.delegator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.promostree.domain.user.User;
import com.promostree.domain.user.UserShare;
import com.promostree.user.service.UserServices;

@Component
public class UserServiceDelegate {
	@Autowired
	UserServices userServices;
	//to share 
	public boolean saveUserShares(UserShare userShares){
	Boolean save=	userServices.saveUserShares(userShares);
		return save;
	}
	//to read shares which i got
	public List<UserShare> readReceivedUserShares(long userId){
		return userServices.readRecievedUserShares(userId);
	}
	//to read shares which i posted
	public List<UserShare> readPostedUserShares(long userId){
		return userServices.readPostedUserShares(userId);
	}
	public boolean saveUserCredentials(User user){
		return true;
	}
	
}
