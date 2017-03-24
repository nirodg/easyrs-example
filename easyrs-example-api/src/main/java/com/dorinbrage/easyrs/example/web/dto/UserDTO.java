package com.dorinbrage.easyrs.example.web.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Dorin_Brage
 */
@Getter
@Setter
public class UserDTO {

  private String guid;
  private String name;
  private String email;
  private Date created_on;
  private Date updated_on;
  private boolean enabled;

}
