package edu.cnm.deepdive.imgurbrowser.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.imgurbrowser.R;
import edu.cnm.deepdive.imgurbrowser.model.entity.Gallery;
import edu.cnm.deepdive.imgurbrowser.model.entity.Gallery.SearchResult;
import edu.cnm.deepdive.imgurbrowser.view.GalleryListAdapter;
import edu.cnm.deepdive.imgurbrowser.viewmodel.ListViewModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GallerySearchFragment extends Fragment {

  private ListViewModel viewModel;
  private GalleryListAdapter galleryListAdapter = new GalleryListAdapter(getContext());

  private ProgressBar loadingView;
  private TextView listError;
  private RecyclerView galleryArray;

  private List<Gallery> galleries;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.gallery_list, container, false);

    loadingView = view.findViewById(R.id.loading_view);
    listError = view.findViewById(R.id.list_error);
    galleryArray = view.findViewById(R.id.recycler_view);

    return view;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(getActivity())
        .get(ListViewModel.class);
    viewModel.getSearchResult().observe(getViewLifecycleOwner(), searchResult -> {
      if (searchResult != null) {
        galleryArray.setVisibility(View.VISIBLE);
        galleries = new ArrayList<Gallery>(Arrays.asList(searchResult.getData()));
        galleryListAdapter.updateGalleryList(galleries);
      }
    });

    viewModel.getLoading().observe(getViewLifecycleOwner(), loading -> {
      loadingView.setVisibility(loading ? View.VISIBLE : View.GONE);
      if (loading) {
        listError.setVisibility(View.GONE);
        galleryArray.setVisibility(View.GONE);
      }
    });

    viewModel.getError().observe(getViewLifecycleOwner(), error -> {
      listError.setVisibility(error ? View.VISIBLE : View.GONE);
    });

    viewModel.loadData();
    if (galleryArray != null) {
      galleryArray.setLayoutManager(new LinearLayoutManager(getContext()));
      galleryArray.setAdapter(galleryListAdapter);
    }

  }
}
