package com.promostree;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.promostree.domain.user.TargetUser;
import com.promostree.domain.user.Type;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserShares;
import com.promostree.repositories.user.TypeRepository;
import com.promostree.user.service.UserServiceImpl;
import com.promostree.user.service.UserServices;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:user-service-application-context.xml")
public class UserSharesServiceTest
{
   @Autowired
   UserServices userService;
   @Autowired
   TypeRepository typeRepository;
   @Test
   public  void SharesTest()
   {
	   System.out.print("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	   
   }
   
   @Test
    public  void saveUserSharesTest()
    {
    	Type pt = new Type();
    	pt.setId(1L);
		//pt.setName("brand");
		User user = new User();
		user.setId(1L);
	//	user.setEmail("ananth@gmail.com");
	//	user.setPhoneNumber("9542128262");
    	UserShares userShares = new UserShares();
		userShares.setComment("it's pretty good..");
    	userShares.setCreateDate(new Date()); 	
    	userShares.setType(pt);
    	userShares.setUser(user);
    	userShares.setValue("Pepe zeans");
    	boolean b= userService.saveUserShares(userShares);
    	Assert.assertTrue(b);
    	      
    }

 
}
