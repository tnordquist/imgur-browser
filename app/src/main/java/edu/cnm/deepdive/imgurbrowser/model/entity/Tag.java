package edu.cnm.deepdive.imgurbrowser.model.entity;

import com.google.gson.annotations.Expose;
import java.util.UUID;

public class Tag {

  @Expose
  private String name;

  @Expose
  private String description;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
