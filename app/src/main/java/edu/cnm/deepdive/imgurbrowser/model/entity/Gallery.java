package edu.cnm.deepdive.imgurbrowser.model.entity;

import androidx.annotation.NonNull;
import com.google.gson.annotations.Expose;
import java.util.Arrays;

public class Gallery {

  private String id;

  @Expose
  private String title;

  @Expose
  private String description;

  private long datetime;

  private String link;

  private Tag[] tags;

  @Expose
  private Image[] images;

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

  public long getDatetime() {
    return datetime;
  }

  public void setDatetime(long datetime) {
    this.datetime = datetime;
  }

  public Tag[] getTags() {
    return tags;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public void setTags(Tag[] tags) {
    this.tags = tags;
  }

  public Image[] getImages() {
    return images;
  }

  public void setImages(Image[] images) {
    this.images = images;
  }

  @Override
  public String toString() {
    return title + description + Arrays.toString(images);
  }

  public static class SearchResult {

    @Expose
    Gallery[] data;

    public Gallery[] getData() {
      return data;
    }

    public void setData(Gallery[] data) {
      this.data = data;
    }

    @Override
    public String toString() {
      return "SearchResult{" +
          "data=" + Arrays.toString(getData());
    }
  }


}
