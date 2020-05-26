package edu.cnm.deepdive.imgurbrowser.viewmodel;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Query;
import edu.cnm.deepdive.imgurbrowser.BuildConfig;
import edu.cnm.deepdive.imgurbrowser.model.entity.Gallery;
import edu.cnm.deepdive.imgurbrowser.service.ImgurService;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {


  private MutableLiveData<Gallery.SearchResult> searchResult;
  private MutableLiveData<Throwable> throwable;
  ImgurService imgurService;

  public MainViewModel(@NonNull Application application) {
    super(application);
    imgurService = ImgurService.getInstance();
    searchResult = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
    loadData();
  }

  public MutableLiveData<Gallery.SearchResult> getSearchResult() {
    return searchResult;
  }

  public MutableLiveData<Throwable> getThrowable() {
    return throwable;
  }

  @SuppressLint("CheckResult")
  public void loadData() {
    imgurService.getSearchResult(BuildConfig.CLIENT_ID,
        "cute")
        .subscribeOn(Schedulers.io())
        .subscribe(
            (searchResult1 -> this.searchResult.postValue(searchResult1)),
            throwable1 -> {
              this.throwable.postValue(throwable1.getCause());
            }
        );
  }

}
