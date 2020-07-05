package edu.cnm.deepdive.imgurbrowser.controller;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import edu.cnm.deepdive.imgurbrowser.R;

public class ImageDetailDialogFragment extends DialogFragment {

  //private CallBack callBack;

  public static ImageDetailDialogFragment newInstance() {
    return new ImageDetailDialogFragment();
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogTheme);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_image_detail_dialog, container, false);
    return view;
  }

}
