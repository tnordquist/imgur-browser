package edu.cnm.deepdive.imgurbrowser.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.UUID;

public class Image {

  @Expose
  @SerializedName("id")
  private String imageId;

  @Expose
  private String title;

  @Expose
  private String description;

  @Expose
  @SerializedName("datetime")
  private long imageDateTime;

  @Expose
  @SerializedName("link")
  private String mediaLink;

  public String getImageId() {
    return imageId;
  }

  public void setImageId(String imageId) {
    this.imageId = imageId;
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

  public long getImageDateTime() {
    return imageDateTime;
  }

  public void setImageDateTime(long imageDateTime) {
    this.imageDateTime = imageDateTime;
  }

  public String getMediaLink() {
    return mediaLink;
  }

  public void setMediaLink(String mediaLink) {
    this.mediaLink = mediaLink;
  }

}
