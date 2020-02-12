package com.harsha.Test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("users")
public class MyResource {

  /*  @GET
    @Produces(MediaType.APPLICATION_XML)
    public Users getIt() {
    	Users u1 = new Users();
    	u1.setAge(23);
    	u1.setName("harsha");
    	u1.setId(1);
        return u1;
    }*/
}
