package edu.cnm.deepdive.imgurbrowser.controller;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import edu.cnm.deepdive.imgurbrowser.R;

public class ImageDetailDialogFragment extends DialogFragment {

  private AlertDialog dialog;
  private View root;

  public static ImageDetailDialogFragment newInstance() {
    return new ImageDetailDialogFragment();
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
//    setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogTheme);
  }

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    root = LayoutInflater.from(getContext())
        .inflate(R.layout.fragment_image_detail_dialog, null, false);
    dialog = new AlertDialog.Builder(getContext())
        .setTitle("Test Dialog")
        .setMessage(
            "Dialog message contents. This should be replaced by inflating a view, and invoking setView.")
        .setPositiveButton(android.R.string.ok, (dlg, which) -> {/* Doing nothing so far*/})
    .create();
    return dialog;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return null;
  }

}
