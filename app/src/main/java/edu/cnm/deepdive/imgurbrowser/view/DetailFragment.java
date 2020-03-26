package edu.cnm.deepdive.imgurbrowser.view;

import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.Fragment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.cnm.deepdive.imgurbrowser.R;
import edu.cnm.deepdive.imgurbrowser.model.entity.GalleryModel;
import edu.cnm.deepdive.imgurbrowser.model.entity.GalleryModel.SearchResult;
import edu.cnm.deepdive.imgurbrowser.model.entity.Image;
import edu.cnm.deepdive.imgurbrowser.service.ImgurService;
import java.io.IOException;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailFragment extends Fragment {

  private static final String IMAGE_URL =
      "https://i.imgur.com/2dbvcdq.png/";

  private WebView contentView;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_detail, container, false);
    setupWebview(root);
    return root;
  }

  private void setupWebview(View root) {
    contentView = root.findViewById(R.id.content_view);
    contentView.setWebViewClient(new WebViewClient() {

      @Override
      public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        return false;
      }

      @Override
      public void onPageFinished(WebView view, String url) {
        // TODO Update view to indicate that load is complete.
      }
    });
    WebSettings settings = contentView.getSettings();
    settings.setJavaScriptEnabled(true);
    settings.setSupportZoom(true);
    settings.setBuiltInZoomControls(true);
    settings.setDisplayZoomControls(false);
    settings.setUseWideViewPort(true);
    settings.setLoadWithOverviewMode(true);
    new Retriever().start();
  }


  private class Retriever extends Thread {

    @Override
    public void run() {
      Gson gson = new GsonBuilder()
          .excludeFieldsWithoutExposeAnnotation()
          .create();
      Retrofit retrofit = new Retrofit.Builder()
          .baseUrl(IMAGE_URL)
          .addConverterFactory(GsonConverterFactory.create(gson))
          .build();
      ImgurService service = retrofit.create(ImgurService.class);
      try {
        Response<Image> response = service.get().execute();
        if (response.isSuccessful()) {
          Image image = response.body();
          String url = image.getMediaLink();
          getActivity().runOnUiThread(() -> contentView.loadUrl(url));
        } else {
          Log.e("ImgurService", response.message());
        }
      } catch (IOException e) {
        Log.e("ImgurService", e.getMessage(), e);
      }

    }
  }
}
