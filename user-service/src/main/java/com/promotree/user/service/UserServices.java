package com.promotree.user.service;

import java.util.List;

import com.promostree.domain.entities.Location;
import com.promostree.domain.user.LocationType;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserFeedback;
import com.promostree.domain.user.UserLocations;
import com.promostree.domain.user.UserPreferences;
import com.promostree.domain.user.UserProfile;
import com.promostree.domain.user.UserShares;
import com.promostree.domain.user.UserShout;

public interface UserServices {
	
public boolean saveUserShares(UserShares userShares);
public List<UserShares> readPostedUserShares(long userId); 
public List<UserShares> readRecievedUserShares(long userId); 

public boolean saveUserCredentials(User user);
public boolean saveUserProfile(UserProfile userProfile);
public boolean saveUserPreferences(UserPreferences userPreferences);
public boolean saveUserLocations(UserLocations userLocations);
public boolean saveLocationType(LocationType locationType); 
public boolean saveLocation(Location location); 
public boolean saveUserFeedback(UserFeedback userFeedback);
public boolean saveUserShout(UserShout userShout);
	

}
