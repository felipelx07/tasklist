package com.hunterco.tasklist.util;

import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class JPAUtil implements Serializable {

  private static final long serialVersionUID = 1L;

  @PersistenceContext(unitName = "tracklist-unit")
  private EntityManager em;

  @Produces
  @RequestScoped
  public EntityManager produceEntityManager() {
    return em;
  }
}
