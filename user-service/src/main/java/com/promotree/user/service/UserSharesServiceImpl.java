package com.promotree.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.promostree.domain.user.UserShares;
import com.promostree.repositories.user.UserSharesRepository;
@Component
public class UserSharesServiceImpl implements UserServices {
@Autowired
UserSharesRepository userSharesRepository;
	@Override
	public boolean saveUserShares(UserShares userShares) {
  
	UserShares userShared=userSharesRepository.save(userShares);	
	if(userShared.equals(userShares))
		return true;
	else
		return false;
	}

}
