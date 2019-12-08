package com.hunterco.tasklist.controller;

import com.hunterco.tasklist.model.Task;
import com.hunterco.tasklist.model.TaskStatus;
import com.hunterco.tasklist.service.ITaskService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
@Getter
@Setter
public class TaskController implements Serializable {

  @Inject
  private transient ITaskService service;

  private Task task;
  private String search;
  private List<Task> list;

  @PostConstruct
  public void init() {
    task = new Task();
  }

  public void update() {
    service.update(task);
    task = new Task();
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Task saved"));
  }

  public void remove(Task task) {
    service.remove(task);
    init();
  }

  public Task find() {
    return service.find(task.getId());
  }

  public void search() {
    list = service.find(search);
  }

  public List<Task> getList() {
    return service.list();
  }

  public TaskStatus[] getStatuses() {
    return TaskStatus.values();
  }
}
