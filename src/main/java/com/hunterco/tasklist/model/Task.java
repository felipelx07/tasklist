package com.hunterco.tasklist.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Task implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String title;
  private String description;
  private TaskStatus status = TaskStatus.OPEN;
  private Date plannedDate = new Date();

  private Date createdAt = new Date();
  private Date modifiedAt = new Date();
  private Date finishedAt;
  private Date removedAt;
}
