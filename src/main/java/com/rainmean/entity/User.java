package com.rainmean.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "t_users")
public class User {
  @Id
  @GeneratedValue
  private Long id;
  private String username;
  private String password;
  private Long age;
  private Long sex;
  @Column(name="create_time")
  private Timestamp createTime;
  private String comments;
  private Double balance;
}
