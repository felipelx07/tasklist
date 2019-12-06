package com.hunterco.tasklist.repository;

import com.hunterco.tasklist.model.Task;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

public class TaskRepository {

  @Inject
  private EntityManager entityManager;

  protected Task update(Task task) {
    if (task.getId() == null)
      entityManager.persist(task);
    else
      entityManager.merge(task);
    return task;
  }

  @Transactional
  public void remove(Task task) {
    entityManager.remove(entityManager.contains(task) ? task : entityManager.merge(task));
  }

  public Task find(Integer id) {
    return entityManager.find(Task.class, id);
  }

  public List<Task> find(String search) {
    TypedQuery<Task> typedQuery = entityManager.createQuery(
        "SELECT t FROM Task t WHERE t.description = :description OR t.title = :title OR t.id = :id ",
        Task.class);
    typedQuery.setParameter("description", "%" + search + "%");
    typedQuery.setParameter("title", "%" + search + "%");
    return typedQuery.getResultList();
  }

  public List<Task> list() {
    TypedQuery<Task> typedQuery = entityManager.createQuery("SELECT t FROM Task t", Task.class);
    return typedQuery.getResultList();
  }
}
