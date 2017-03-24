package com.dorinbrage.easyrs.example.web.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Dorin Brage
 *
 */
@Entity
@Getter
@Setter
@NamedQueries({@NamedQuery(name = "findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "findById", query = "SELECT u FROM User u WHERE u.guid LIKE :id")})
public class User {

  @Id
  private String guid;

  private String name;

  private String email;

  @Temporal(TemporalType.TIMESTAMP)
  private Date created_on;

  @Temporal(TemporalType.TIMESTAMP)
  private Date updated_on;

  private boolean enabled;

  @PrePersist
  public void prePersist() {
    this.guid = UUID.randomUUID().toString();
    this.created_on = new Date();
    this.created_on = new Date();
  }

}
