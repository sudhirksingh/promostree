package com.promostree.delegator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.promostree.domain.user.User;
import com.promostree.domain.user.UserShares;
import com.promostree.user.service.UserServices;

@Component
public class UserServiceDelegate {
	@Autowired
	UserServices userServices;
	//to  Registration
	public User saveUserCredentials(User user){
	User  use=userServices.saveUserCredentials(user);
	return use;
	}
	// to savetheusershout
	public  boolean saveUserShout()
	{
		return false;
		
	}
	//to share 
	public boolean saveUserShares(UserShares userShares){
	Boolean save=	userServices.saveUserShares(userShares);
		return save;
	}
	//to read shares which i got
	public List<UserShares> readReceivedUserShares(long userId){
		return userServices.readRecievedUserShares(userId);
	}
	//to read shares which i posted
	public List<UserShares> readPostedUserShares(long userId){
		return userServices.readPostedUserShares(userId);
	}

	

	
}
