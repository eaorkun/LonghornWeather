package utexas.eaorkun.longhornweather;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity
{

   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      Toolbar toolbar = findViewById(R.id.toolbar); //Top bar
      setSupportActionBar(toolbar);

      FloatingActionButton fab = findViewById(R.id.fab); //Button for coordinates
      fab.setOnClickListener(view -> {
         //Outputs current location to screen
         Snackbar.make(view, "[Coordinates] Lat: 30.2672 Lon: -97.7431", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show();
      });
   }


}