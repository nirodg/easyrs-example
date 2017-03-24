package com.dorinbrage.easyrs.example.web.endpoints;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dorinbrage.easyrs.example.web.dto.UserDTO;


/**
 * 
 * @author Dorin_Brage
 *
 */
@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface UserEndpoint {

  @Path("/")
  @GET
  List<UserDTO> getAll();

  @Path("/")
  @PUT
  UserDTO create(UserDTO dto);

  @Path("/{id}")
  @POST
  UserDTO update(@PathParam("id") String id, UserDTO dto);

  @Path("/{id}")
  @DELETE
  boolean delete(@PathParam("id") String id);
}
