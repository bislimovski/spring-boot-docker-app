package com.example.docker.entity;

import org.springframework.data.annotation.Id;

public class Hello {

  @Id
  private String id;

  private String content;

  public Hello() {

  }

  public Hello(String content) {
    this.content = content;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
