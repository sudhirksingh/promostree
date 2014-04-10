package com.promotree;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.promostree.domain.user.TargetUsers;
import com.promostree.domain.user.Type;
import com.promostree.domain.user.User;
import com.promostree.domain.user.UserShares;
import com.promostree.repositories.user.TypeRepository;
import com.promotree.user.service.UserSharesServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:user-service-application-context.xml")
public class UserSharesServiceTest
{
   @Autowired
   UserSharesServiceImpl userSharesServiceImpl;
   /*  @Autowired
   UserShares userShares;
   @Autowired
   TargetUsers targetUsers;
   @Autowired
   TypeRepository typeRepository;*/
   @Test
   public  void SharesTest()
   {
	   System.out.print("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	   
   }
   
   /*@Test
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
    	boolean b=userSharesServiceImpl.saveUserShares(userShares);
    	Assert.assertTrue(b);
    	      
    }*/

 
}
