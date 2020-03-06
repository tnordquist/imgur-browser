package edu.cnm.deepdive.imgurbrowser.view;


import android.os.Bundle;
import android.view.View.OnClickListener;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import edu.cnm.deepdive.imgurbrowser.R;

public class ListFragment extends Fragment {

  @BindView(R.id.fab_list)
  FloatingActionButton listFab;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_list, container, false);
    ButterKnife.bind(this,view);
    return view;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    listFab.setOnClickListener(view1 -> {
      NavDirections action = ListFragmentDirections.actionGoToDetail();
      Navigation.findNavController(view1).navigate(action);
    });
  }
}
