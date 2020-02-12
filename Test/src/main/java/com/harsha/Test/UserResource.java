package com.harsha.Test;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.*;

//to handle  client side request we need javascript but for time being we use postman...a client to handle request
@Path("users")
public class UserResource {
	//user repo is a fake or static database
	//we create an object of it and call all the specified methods present in User repo
	UserRepo u1 = new UserRepo();
	
	//get all the users
	    @GET
	    @Produces(MediaType.APPLICATION_XML)
	    public List<Users> getIt() {
	    	return u1.getAllUser();
	    	
	    }
	    
	    //write your jdbc code in below method
	    //create a user 
	    @POST
	    @Path("create")
	    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	    public Users createUser(Users user) {
	    	System.out.println(user);
	    	
	    	u1.createUser(user);
	    	return user;
	    }
	    

	    //this resource updates the user if present...if not it creates a new user
	    @PUT
	    @Path("update")
	    @Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	    public Users updateUser(Users user) {
	    	System.out.println(user);
	    	if(u1.getAUser(user.getId()).getId()==0) {
	    		u1.createUser(user);
	    	}
	    	else {
	    		u1.UpdateUser(user);
	    	}
	    	
	    
	    	return user;
	    }
	    
	   
	    // to fetch a particular id we need a placeholder in url and we use path param to assign the id value to int id
	    @GET
	    @Path("get/{id}")
	    @Produces(MediaType.APPLICATION_XML)
	    public Users getUser(@javax.ws.rs.PathParam("id") int number) {
	    	 System.out.println("hello");
	        return u1.getAUser(number);
	    }
	    
	    //this resource will delete a particular record in database if the record id present
	    @DELETE
	    @Path("delete/{id}")
	    public Users deleteUser(@javax.ws.rs.PathParam("id") int number) {
	   
	    	Users u = u1.getAUser(number);
	    	if(u.getId()!=0) {
	    		u1.DeleteUser(number);
	    	}
	    	return u;
	    }
	    
	    
}
