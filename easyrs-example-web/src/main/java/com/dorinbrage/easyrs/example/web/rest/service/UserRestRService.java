package com.dorinbrage.easyrs.example.web.rest.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.dorinbrage.easyrs.example.web.dto.UserDTO;
import com.dorinbrage.easyrs.example.web.endpoints.UserEndpoint;
import com.dorinbrage.easyrs.example.web.model.User;
import com.dorinbrage.easyrs.example.web.service.UserService;

/**
 * @author Dorin_Brage
 *
 */
@Named
@RequestScoped
public class UserRestRService implements UserEndpoint {

  @Inject
  private UserService service;

  public List<UserDTO> getAll() {
    return map(service.findAll());
  }

  public UserDTO create(UserDTO dto) {
    User user = service.create(map(dto));
    return map(user);
  }

  public UserDTO update(String id, UserDTO dto) {
    User user = service.findById(id);
    update(dto, user); // Update the entity based on the given dto
    user = service.update(user);
    return map(user);
  }

  public boolean delete(String id) {
    return service.deleteById(id);
  }

  private UserDTO map(User model) {

    if (model != null) {
      UserDTO dto = new UserDTO();
      dto.setGuid(model.getGuid());
      dto.setName(model.getName());
      dto.setEmail(model.getEmail());
      dto.setEnabled(model.isEnabled());
      dto.setCreated_on(model.getCreated_on());
      dto.setUpdated_on(model.getUpdated_on());
      return dto;
    }

    return null;
  }

  private User map(UserDTO dto) {

    if (dto != null) {
      User model = new User();
      model.setGuid(dto.getGuid());
      model.setName(dto.getName());
      model.setEmail(dto.getEmail());
      model.setEnabled(dto.isEnabled());
      model.setCreated_on(dto.getCreated_on());
      model.setUpdated_on(dto.getUpdated_on());
      return model;

    }
    return null;
  }

  private void update(UserDTO dto, User model) {
    if (dto != null && model != null) {
      model.setName(dto.getName());
      model.setEmail(dto.getEmail());
      model.setEnabled(dto.isEnabled());
      model.setCreated_on(dto.getCreated_on());
      model.setUpdated_on(dto.getUpdated_on());
    }
  }

  private List<UserDTO> map(List<User> list) {
    if (list != null) {

      final List<UserDTO> dtos = new ArrayList<UserDTO>();

      list.forEach((dto) -> {
        dtos.add(map(dto));
      });

      return dtos;
    }

    return null;
  }

}
