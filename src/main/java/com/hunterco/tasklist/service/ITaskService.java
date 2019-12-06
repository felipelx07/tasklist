package com.hunterco.tasklist.service;

import com.hunterco.tasklist.model.Task;
import java.util.List;

public interface ITaskService {

  Task update(Task task);

  void remove(Task task);

  Task find(Integer id);

  List<Task> find(String search);

  List<Task> list();

}
