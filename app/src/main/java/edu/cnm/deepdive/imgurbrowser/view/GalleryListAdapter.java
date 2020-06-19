package edu.cnm.deepdive.imgurbrowser.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.imgurbrowser.R;
import edu.cnm.deepdive.imgurbrowser.model.entity.Gallery;
import edu.cnm.deepdive.imgurbrowser.model.entity.Gallery.SearchResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GalleryListAdapter extends RecyclerView.Adapter<GalleryListAdapter.GalleryViewHolder> {

  private final Context context;

//  private final Gallery.SearchResult searchResult = new SearchResult();

  //  private final List<Gallery> galleries = new ArrayList<Gallery>();
  private final Gallery[] galleries;

  public void updateGalleryList(Context context) {

  }

  public GalleryListAdapter(Context context, Gallery[] galleries) {
    super();
    this.context = context;
    this.galleries = galleries;
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

  class GalleryViewHolder extends RecyclerView.ViewHolder {

    private final TextView title;
    TextView description;
    TextView images;

    public GalleryViewHolder(@NonNull View itemView) {
      super(itemView);
      title = itemView.findViewById(R.id.title);
      description = itemView.findViewById(R.id.description);
      images = itemView.findViewById(R.id.image);
    }

    private void bind(int position) {

      title.setText(galleries[position].getTitle());
      description.setText(galleries[position].getDescription());
      images.setText(Arrays.toString(galleries[position].getImages()));

    }
  }


}
