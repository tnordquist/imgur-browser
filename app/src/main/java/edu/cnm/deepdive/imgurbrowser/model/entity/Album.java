package edu.cnm.deepdive.imgurbrowser.model.entity;

import com.google.gson.annotations.Expose;

public class Album {

  @Expose
  private String id;

  @Expose
  private String title;

  @Expose
  private String description;

  @Expose
  private int datetime;

  @Expose
  private String account_url; // nullable

  @Expose
  private int views;

  @Expose
  private String link;

  @Expose
  private String deletehash;

  @Expose
  private int images_count;

  @Expose
  private Image[] images;

  @Expose
  private boolean in_gallery;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getDatetime() {
    return datetime;
  }

  public void setDatetime(int datetime) {
    this.datetime = datetime;
  }

  public String getAccount_url() {
    return account_url;
  }

  public void setAccount_url(String account_url) {
    this.account_url = account_url;
  }

  public int getViews() {
    return views;
  }

  public void setViews(int views) {
    this.views = views;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getDeletehash() {
    return deletehash;
  }

  public void setDeletehash(String deletehash) {
    this.deletehash = deletehash;
  }

  public int getImages_count() {
    return images_count;
  }

  public void setImages_count(int images_count) {
    this.images_count = images_count;
  }

  public Image[] getImages() {
    return images;
  }

  public void setImages(Image[] images) {
    this.images = images;
  }

  public boolean isIn_gallery() {
    return in_gallery;
  }

  public void setIn_gallery(boolean in_gallery) {
    this.in_gallery = in_gallery;
  }
}
