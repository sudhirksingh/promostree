package com.promostree.delegator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.promostree.domain.user.User;
import com.promostree.domain.user.UserPreference;
import com.promostree.domain.user.UserProfile;
import com.promostree.domain.user.UserShare;
import com.promostree.domain.user.UserShout;
import com.promostree.user.service.UserServices;

@Component
public class UserServiceDelegate {
	@Autowired
	UserServices userServices;
	
	//to  Registration
	public UserProfile saveUserCredentials(User user){
	UserProfile  use=userServices.saveUserCredentials(user);
	return use;
	}
	// to savetheusershout
	public  String saveUserShout(UserShout userShout)
	{
      String ushout	= userServices.saveUserShout(userShout);
		return "userShout";
	}
	//tor read userShouts
	public  List<UserShout>  readUserShout(User user)
	{
    List<UserShout> userShout	= userServices.readUserShout(user);
		return userShout;
	}
	//to share 
	public boolean saveUserShares(UserShare userShares){
	Boolean save=	userServices.saveUserShares(userShares);
		return save;
	}
	//to read shares which i got
	public List<UserShare> readReceivedUserShares(Long userId){
		User user=new User();
		user.setId(userId);
		return userServices.readRecievedUserShares(user);
	}
	//to read shares which i posted
	public List<UserShare> readPostedUserShares(Long userId){
		User user=new User();
		user.setId(userId);
		return userServices.readPostedUserShares(user);
	}

	//to save user preference
	public List<UserPreference> saveUserPreference(List<UserPreference> userPreference){
		return userServices.saveUserPreference(userPreference);
	}
	//to read user preferences
	public List<UserPreference> readUserPreference(User user){
		return userServices.readUserPreferences(user);
	}


}
