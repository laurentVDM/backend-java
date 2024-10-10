package be.vinci.api;

import be.vinci.api.filters.Authorize;
import be.vinci.domain.User;
import be.vinci.services.UserDataService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Singleton
@Path("/users")
public class UserResource {

  @Inject
  private UserDataService myUserDataService;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Authorize
  public List<User> getAll() {
    System.out.println("getAll");
    return myUserDataService.getAll();
  }


}
