package edu.cnm.deepdive.imgurbrowser.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.imgurbrowser.model.entity.Gallery;
import java.util.ArrayList;
import java.util.List;

public class GalleryListAdapter extends RecyclerView.Adapter<GalleryListAdapter.GalleryViewHolder>{

  List<Gallery> galleries = new ArrayList<>();

  public void updateGalleryList(List<Gallery> newGalleryList) {

  }

  @NonNull
  @Override
  public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return null;
  }

  @Override
  public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {

  }

  @Override
  public int getItemCount() {
    return 0;
  }

  class GalleryViewHolder extends RecyclerView.ViewHolder {

    public GalleryViewHolder(@NonNull View itemView) {
      super(itemView);
    }
  }

}
