package com.hunterco.tasklist.factory;

import com.hunterco.tasklist.model.Task;

public class TaskFactory {

  public static Task getTask1() {
    Task task = new Task();
    task.setTitle("Reunion w/ Team");
    task.setDescription("Scrum dayle reunion");
    return task;
  }

  public static Task getTask2() {
    Task task = new Task();
    task.setTitle("Go to Bank");
    task.setDescription("Transfer $500 to Paul");
    return task;
  }

  public static Task getTask3() {
    Task task = new Task();
    task.setTitle("Meet with Jane");
    task.setDescription("Meet at 8pm");
    return task;
  }
}
