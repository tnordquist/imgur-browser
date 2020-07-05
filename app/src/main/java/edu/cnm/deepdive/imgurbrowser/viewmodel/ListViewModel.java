package edu.cnm.deepdive.imgurbrowser.viewmodel;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import edu.cnm.deepdive.imgurbrowser.BuildConfig;
import edu.cnm.deepdive.imgurbrowser.model.entity.Gallery;
import edu.cnm.deepdive.imgurbrowser.service.ImgurService;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ListViewModel extends AndroidViewModel {

  private MutableLiveData<Gallery.SearchResult> searchResult;
  private MutableLiveData<Boolean> loadError = new MutableLiveData<Boolean>();
  private MutableLiveData<Boolean> loading = new MutableLiveData<Boolean>();
  private MutableLiveData<Throwable> throwable;
  private CompositeDisposable pending;
  ImgurService imgurService;

  public ListViewModel(@NonNull Application application) {
    super(application);
    imgurService = ImgurService.getInstance();
    searchResult = new MutableLiveData<Gallery.SearchResult>();
    throwable = new MutableLiveData<Throwable>();
    loadError = new MutableLiveData<Boolean>();
    loading = new MutableLiveData<Boolean>();
    pending = new CompositeDisposable();
    loadData();
  }

  public LiveData<Gallery.SearchResult> getSearchResult() {
    return searchResult;
  }

  public LiveData<Boolean> getLoading() {
    return loading;
  }

  public LiveData<Boolean> getError() {
    return loadError;
  }

  public MutableLiveData<Throwable> getThrowable() {
    return throwable;
  }


  @SuppressLint("CheckResult")
  public void loadData() {
    pending.add(
        imgurService.getSearchResult(BuildConfig.CLIENT_ID,
            "fish AND sharks")
            .subscribeOn(Schedulers.io())
            .subscribe(
                searchResult -> this.searchResult.postValue(searchResult),
                throwable -> this.throwable.postValue(throwable.getCause())
            )
    );
  }

  @Override
  protected void onCleared() {
    super.onCleared();
    pending.clear();
  }

}
