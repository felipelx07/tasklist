package com.hunterco.tasklist.service;

import com.hunterco.tasklist.model.Task;
import com.hunterco.tasklist.model.TaskStatus;
import com.hunterco.tasklist.repository.TaskRepository;
import java.util.Date;
import javax.transaction.Transactional;

public class TaskService extends TaskRepository implements ITaskService {

  @Transactional
  public Task update(Task task) {
    if (task.getStatus().equals(TaskStatus.DONE))
      task.setFinishedAt(new Date());
    task.setModifiedAt(new Date());
    return super.update(task);
  }
}
