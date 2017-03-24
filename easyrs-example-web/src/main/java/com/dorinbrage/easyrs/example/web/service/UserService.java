package com.dorinbrage.easyrs.example.web.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dorinbrage.easyrs.example.web.model.User;

/**
 * 
 * @author Dorin Brage
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class UserService {

  @PersistenceContext
  private EntityManager em;

  @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
  public User create(User model) {
    em.persist(model);
    return model;
  }

  @SuppressWarnings("unchecked")
  public List<User> findAll() {
    return em.createNamedQuery("findAll").getResultList();
  }

  public User findById(String id) {
    Query query = em.createNamedQuery("findAll");
    query.setParameter("guid", id);
    return (User) query.getSingleResult();
  }

  public User updateById(User model) {
    return em.merge(model);
  }

  public boolean deleteById(String id) {
    try {
      em.remove(findById(id));
      return true;
    } catch (Exception e) {
      return false;
    }
  }

}
