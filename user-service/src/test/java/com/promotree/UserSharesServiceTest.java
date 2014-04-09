package com.promotree;

import java.util.Date;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.promostree.domain.user.TargetUsers;
import com.promostree.domain.user.Type;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserShares;
import com.promostree.repositories.user.TypeRepository;
import com.promostree.repositories.user.UserSharesRepository;
import com.promotree.user.service.UserSharesServiceImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class UserSharesServiceTest
{
   @Autowired
   UserSharesServiceImpl userSharesServiceImpl;
   @Autowired
   UserShares userShares;
  
   @Autowired
   TargetUsers targetUsers;
   @Autowired
   TypeRepository typeRepository;
   
    
   @org.junit.Test
    public  void saveUserSharesTest()
    {
    	Type pt=new Type();
		pt.setName("brand");
		
		User user=new User();
		user.setEmail("ananth@gmail.com");
		user.setPhoneNumber("9542128262");
		
    	
    	userShares.setComment("it's pretty good..");
    	userShares.setCreateDate(new Date()); 	
    	userShares.setType(pt);
    	userShares.setUser(user);
    	userShares.setValue("Pepe zeans");
    	userSharesServiceImpl.saveUserShares(userShares);
    	      
    }

 
}
