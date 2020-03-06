package edu.cnm.deepdive.imgurbrowser.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import edu.cnm.deepdive.imgurbrowser.R;

public class MainActivity extends AppCompatActivity {

  private NavController navController;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    navController = Navigation.findNavController(this,R.id.fragment);
    NavigationUI.setupActionBarWithNavController(this,navController);
  }

  @Override
  public boolean onSupportNavigateUp() {
    return NavigationUI.navigateUp(navController, (DrawerLayout) null);
  }
}
