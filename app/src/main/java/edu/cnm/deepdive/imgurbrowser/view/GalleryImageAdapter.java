package edu.cnm.deepdive.imgurbrowser.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.google.android.gms.common.SupportErrorDialogFragment;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import edu.cnm.deepdive.imgurbrowser.R;
import edu.cnm.deepdive.imgurbrowser.controller.ImageDetailDialogFragment;
import edu.cnm.deepdive.imgurbrowser.model.entity.Image;
import java.util.List;

public class GalleryImageAdapter extends ArrayAdapter<Image> {

  public GalleryImageAdapter(@NonNull Context context,
      Image[] imageItemArray) {
    super(context, 0, imageItemArray);
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    return initView(position, convertView, parent);
  }

  @Nullable
  @Override
  public View getDropDownView(int position, @Nullable View convertView,
      @NonNull ViewGroup parent) {
    return initView(position, convertView, parent);
  }

  private View initView(int position, View convertview, ViewGroup parent) {
    if (convertview == null) {
      convertview = LayoutInflater.from(getContext()).inflate(
          R.layout.custom_gallery_search_spinner_item, parent, false
      );
    }
    ImageView imageView = convertview.findViewById(R.id.image_gallery_search);
    TextView titleView = convertview.findViewById(R.id.title);
    TextView descriptionView = convertview.findViewById(R.id.description);
    TextView urlView = convertview.findViewById(R.id.url);

    Image currentItem = getItem(position);

    if (currentItem != null) {
      Picasso.get().load(currentItem.getUrl()).into(imageView);
      titleView.setText(currentItem.getTitle());
      descriptionView.setText(currentItem.getDescription());
      urlView.setText(currentItem.getUrl());
    }

    return convertview;
  }
}