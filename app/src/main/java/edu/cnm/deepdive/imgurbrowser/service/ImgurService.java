package edu.cnm.deepdive.imgurbrowser.service;

import edu.cnm.deepdive.imgurbrowser.model.entity.GalleryModel;
import edu.cnm.deepdive.imgurbrowser.model.entity.Image;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ImgurService {

  @GET("2dbvcdq.png")
  Call<Image> get();

}
