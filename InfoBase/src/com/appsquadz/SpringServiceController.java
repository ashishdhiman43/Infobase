//http://localhost:9090/RestJson/service/user/1002
//http://localhost:9090/RestJson/service/user/add/2009/appsquadz/appsquadz/abc
//http://localhost:9090/RestJson/service/user/del/2001
package com.appsquadz;


import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appsquadz.UserService;

import com.appsquadz.User;



@RestController

@RequestMapping("/service/user")

public class SpringServiceController {
	
	
UserService userService=new UserService();
	     	    
	@RequestMapping(value = "/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	
public User getUser(@PathVariable int id) 
{
		
User user=userService.getUserById(id);
		return user;
	
}
	
	@RequestMapping(value = "del/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	
	public void delUser(@PathVariable int id) 
	{
			
	userService.deleteUser(id);
			
	}
@RequestMapping(value = "/add/{id}/{name}/{last}/{mail}", method = RequestMethod.GET,headers="Accept=application/json")
	
	public void addUser(@PathVariable int id,@PathVariable String name,@PathVariable String last,@PathVariable String mail) 
	{
		User user=new User();
		 user.setUserid(id);
		 user.setFirstName(name);
		 user.setLastName(last);			
		 user.setEmail(mail);
	userService.addUser(user);
			
	}

@RequestMapping(value = "/update/{id}/{name}/{last}/{mail}", method = RequestMethod.GET,headers="Accept=application/json")
    public void updateUser(@PathVariable int id, @PathVariable String name, @PathVariable String last,@PathVariable String mail)throws Exception
    {
	    User user=new User();
	     user.setUserid(id);
	     user.setFirstName(name);
	     user.setLastName(last);			
	     user.setEmail(mail);
    userService.updateUser(user);
    }
	
@RequestMapping(method = RequestMethod.GET,headers="Accept=application/json")
	
public List<User> getAllUsers() {
		
List<User> users=userService.getAllUsers();
		return users;
	
}
	
	

}