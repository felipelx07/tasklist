package com.hunterco.tasklist;

import com.hunterco.tasklist.factory.TaskFactory;
import com.hunterco.tasklist.model.Task;
import com.hunterco.tasklist.service.ITaskService;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class TaskIT {

  @Deployment
  public static JavaArchive createDeployment() {
    return ShrinkWrap.create(JavaArchive.class).addPackages(true, "com.hunterco.tasklist")
        .addAsResource("META-INF/persistence.xml")
        .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
  }

  @Inject
  private ITaskService service;
  List<Task> list = new ArrayList<>();

  @Before
  public void beforeTest() {
    list = new ArrayList<>();
    Task task1 = service.update(TaskFactory.getTask1());
    Task task2 = service.update(TaskFactory.getTask2());
    Task task3 = service.update(TaskFactory.getTask3());
    list.add(task1);
    list.add(task2);
    list.add(task3);
  }

  @After
  public void afterTest() {
    if (list != null && list.size() > 0)
      service.list().forEach(t -> service.remove(t));
  }

  @Test
  public void createTasks() {
    service.list().forEach(t -> service.update(t));
  }

  @Test
  public void removeTasks() {
    service.list().forEach(t -> service.remove(t));
  }

  @Test
  public void findTask() {
    service.list().forEach(t -> service.update(t));
    Task task = service.find(TaskFactory.getTask1().getId());
    Assert.assertNotNull(task);
    Assert.assertNotNull(TaskFactory.getTask1().getTitle(), task.getTitle());
  }

  @Test
  public void searchTask() {
    service.list().forEach(t -> service.update(t));
    List<Task> list = service.find("Reunion");
    Assert.assertNotNull(list);
  }

  @Test
  public void listAllTasks() {
    List<Task> list = service.list();
    Assert.assertNotNull(list);
  }

}
