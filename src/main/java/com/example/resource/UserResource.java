package com.example.resource;

import com.example.cache.UserCache;
import com.example.entity.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/user")
@Produces({ "application/json;charset=utf-8" })
public class UserResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }


    @POST
    @Consumes("application/json")
    public User newUser(User user) throws IOException {
        System.out.println("bean:\tuserName: " + user);
        UserCache.getUserCache().put(user.getUserId(),user);
        return user;
    }

    @GET
    @Path("/{id}")
    public User getUser(@PathParam("id") String id) {

        System.out.println("json get -----------------------------------f");
       User user = UserCache.getUserCache().get(id);
        if(user==null){
            throw new NotFoundException("No such User.");
        }
        return user;
    }

    @GET
    @Path("/map/all")
    public Map<String,User> getAllUsers(@PathParam("id") String id) {
        System.out.println("返回Map");
        return UserCache.getUserCache();
    }

    @GET
    @Path("/list/all")
    public List<String> getListUsers(@PathParam("id") String id) {
        System.out.println("返回列表");
        return UserCache.getUserCache().keySet().stream().collect(Collectors.toList());

    }
}
