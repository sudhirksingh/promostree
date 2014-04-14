package com.promostree.user.service;

import java.util.List;

import com.promostree.domain.entities.Location;
import com.promostree.domain.user.LocationType;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserFeedback;
import com.promostree.domain.user.UserLocation;
import com.promostree.domain.user.UserPreference;
import com.promostree.domain.user.UserProfile;
import com.promostree.domain.user.UserShare;
import com.promostree.domain.user.UserShout;

public interface UserServices {
	
public boolean saveUserShares(UserShare userShares);
public List<UserShare> readPostedUserShares(long userId); 
public List<UserShare> readRecievedUserShares(Long userId); 

public User saveUserCredentials(User user);
public UserProfile saveUserProfile(UserProfile userProfile);


public UserPreference saveUserPreference(UserPreference userPreferences);
public List<UserPreference> readUserPreferences(User user);
//public UserPreference deleteUserPreferences(UserPreference userPreferences);

public UserLocation saveUserLocations(UserLocation userLocations);


public boolean saveLocationType(LocationType locationType); 
public Location saveLocation(Location location); 
public boolean saveUserFeedback(UserFeedback userFeedback);

public String saveUserShout(UserShout userShout);


public List<UserShout> readUserShout(User user);	


}
