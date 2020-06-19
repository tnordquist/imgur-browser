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

  private final List<Gallery> galleries = new ArrayList<Gallery>();

  public void updateGalleryList(List<Gallery> galleries) {
    galleries.clear();
    galleries.addAll(galleries);
    notifyDataSetChanged();
  }

  public GalleryListAdapter(Context context) {
    this.context = context;
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
    return galleries.size();
  }

  class GalleryViewHolder extends RecyclerView.ViewHolder {

    private final TextView title;
    TextView description;
    TextView images;

    public GalleryViewHolder(@NonNull View itemView) {
      super(itemView);
      title = itemView.findViewById(R.id.title);
      description = itemView.findViewById(R.id.description);
      images = itemView.findViewById(R.id.images);
    }

    private void bind(int position) {

      title.setText(galleries.get(position).getTitle());
      images.setText(Arrays.toString(galleries.get(position).getImages()));

    }
  }


}
