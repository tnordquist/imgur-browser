package edu.cnm.deepdive.imgurbrowser.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.imgurbrowser.R;
import edu.cnm.deepdive.imgurbrowser.controller.GallerySearchFragment;
import edu.cnm.deepdive.imgurbrowser.model.entity.Gallery;

public class GalleryListAdapter extends
    RecyclerView.Adapter<GalleryListAdapter.GalleryViewHolder> implements
    OnItemSelectedListener {

  private final Context context;
  private final Gallery[] galleries;
  private final OnItemSelectedHelper onItemSelectedHelper;
  GallerySearchFragment gallerySearchFragment;

  public GalleryListAdapter(Context context, Gallery[] galleries,
      OnItemSelectedHelper onItemSelectedHelper) {
    super();
    this.context = context;
    this.galleries = galleries;
    this.onItemSelectedHelper = onItemSelectedHelper;
  }

  @NonNull
  @Override
  public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_gallery_search, parent, false);
    return new GalleryViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
    holder.bind(position);
  }

  @Override
  public int getItemCount() {
    return galleries.length;
  }

  @Override
  public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {

    onItemSelectedHelper.onSelected(pos);
  }

  @Override
  public void onNothingSelected(AdapterView<?> adapterView) {
  }

  class GalleryViewHolder extends RecyclerView.ViewHolder {

    private final TextView title;
    private final TextView description;
    private final Spinner imageSpinner;

    public GalleryViewHolder(@NonNull View itemView) {
      super(itemView);
      title = itemView.findViewById(R.id.title);
      description = itemView.findViewById(R.id.description);
      imageSpinner = itemView.findViewById(R.id.gallery_search_spinner);
    }

    private void bind(int position) {
      title.setText(galleries[position].getTitle());
      description.setText(galleries[position].getDescription());
      GalleryImageAdapter galleryImageAdapter = new GalleryImageAdapter(context,
          galleries[position].getImages());
      imageSpinner.setAdapter(galleryImageAdapter);


    }
  }

  public interface OnItemSelectedHelper {
    void onSelected(int pos);
  }


}
