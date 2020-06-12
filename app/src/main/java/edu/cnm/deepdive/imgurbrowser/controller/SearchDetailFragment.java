package edu.cnm.deepdive.imgurbrowser.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.imgurbrowser.R;
import edu.cnm.deepdive.imgurbrowser.model.entity.Gallery;
import edu.cnm.deepdive.imgurbrowser.model.entity.Gallery.SearchResult;
import edu.cnm.deepdive.imgurbrowser.viewmodel.MainViewModel;
import java.util.List;
import java.util.Objects;

public class SearchDetailFragment extends Fragment {

  private WebView contentView;
  private MainViewModel viewModel;

  Toolbar toolbar;

  private Spinner spinner;
  private Gallery.SearchResult searchResult;
  private List<Gallery> galleries;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_detail, container, false);
    setupWebView(root);
//    toolbar = root.findViewById(R.id.toolbar);
    spinner = root.findViewById(R.id.galleries_spinner);
//    spinner.setOnItemSelectedListener(this);
//    toolbar.setTitle(R.string.app_name);

    return root;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    assert getParentFragment() != null;
    viewModel = new ViewModelProvider((Objects.requireNonNull(getActivity())))
        .get(MainViewModel.class);
    viewModel.getSearchResult().observe(getViewLifecycleOwner(), (searchResult) -> {
      this.searchResult = searchResult;
      ArrayAdapter<Gallery> adapter = new ArrayAdapter<>(getContext(), R.layout.support_simple_spinner_dropdown_item,
          galleries);
      adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      spinner.setAdapter(adapter);
    });
  }

  private void setupWebView(View root) {
    contentView = root.findViewById(R.id.content_view);
    contentView.setWebViewClient(new WebViewClient() {
      @Override
      public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        return false;
      }
    });
    WebSettings settings = contentView.getSettings();
    settings.setJavaScriptEnabled(false);
    settings.setSupportZoom(true);
    settings.setBuiltInZoomControls(true);
    settings.setDisplayZoomControls(false);
    settings.setUseWideViewPort(true);
    settings.setLoadWithOverviewMode(true);
  }

//  @Override
//  public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
//    contentView.loadUrl(data.get(pos).getUrl());
//  }
//
//  @Override
//  public void onNothingSelected(AdapterView<?> adapterView) {
//
//  }
}
