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

/**
 * 
 * @author Dorin Brage
 *
 */
@Entity
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

  /**
   * @return the guid
   */
  public String getGuid() {
    return guid;
  }

  /**
   * @param guid the guid to set
   */
  public void setGuid(String guid) {
    this.guid = guid;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return the created_on
   */
  public Date getCreated_on() {
    return created_on;
  }

  /**
   * @param created_on the created_on to set
   */
  public void setCreated_on(Date created_on) {
    this.created_on = created_on;
  }

  /**
   * @return the updated_on
   */
  public Date getUpdated_on() {
    return updated_on;
  }

  /**
   * @param updated_on the updated_on to set
   */
  public void setUpdated_on(Date updated_on) {
    this.updated_on = updated_on;
  }

  /**
   * @return the enabled
   */
  public boolean isEnabled() {
    return enabled;
  }

  /**
   * @param enabled the enabled to set
   */
  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

}
