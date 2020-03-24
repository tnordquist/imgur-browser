package edu.cnm.deepdive.imgurbrowser.model.entity;

import com.google.gson.annotations.Expose;

public class GalleryModel {

  @Expose
  private String id;

  @Expose
  private String title;

  @Expose
  private long datetime;

  @Expose
  private Tag[] tags;

  @Expose
  private Image[] images;


  /*
  Single<GalleryModel.SearchResult> {}
   */

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

  public long getDatetime() {
    return datetime;
  }

  public void setDatetime(long datetime) {
    this.datetime = datetime;
  }

  public Tag[] getTags() {
    return tags;
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

  public static class SearchResult {

    @Expose
    GalleryModel[] data;

    public GalleryModel[] getData() {
      return data;
    }

    public void setData(GalleryModel[] data) {
      this.data = data;
    }
  }

}
