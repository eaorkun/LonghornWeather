package utexas.eaorkun.longhornweather;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class FirstFragment extends Fragment
{

   @Override
   public View onCreateView(
      LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState
   )
   {
      // Inflate the layout for this fragment
      return inflater.inflate(R.layout.fragment_first, container, false);
   }

   public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
   {
      super.onViewCreated(view, savedInstanceState);
      volleyRequest(); //Update data
      getParentFragment().getView().setBackgroundColor(Color.parseColor("#d6d2c4")); //change background color
      view.findViewById(R.id.button_first).setOnClickListener(view1 -> {
         NavHostFragment.findNavController(FirstFragment.this)
            .navigate(R.id.action_FirstFragment_to_SecondFragment); //transition to 2nd fragment
      });

   }


   public void volleyRequest()
   {
      // Instantiate the RequestQueue
      RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
      String url = "https://api.openweathermap.org/data/2.5/onecall?lat=30.267153&lon=-97.743057&units=imperial&appid=8d88d6c39f0b66df7711714be6871f6f";

      // Request a string response from the provided URL.
      StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
         response -> {
            //store json object to java object
            Gson g = new Gson();
            WeatherJson s = g.fromJson(response, WeatherJson.class);

            //set weather icon
            final ImageView imageView = getActivity().findViewById(R.id.imageView1);
            String icon = s.getCurrent().getWeather()[0].getIcon();

            switch (icon)
            {
               case "01d":
                  imageView.setImageResource(R.drawable.i01d);
                  break;
               case "01n":
                  imageView.setImageResource(R.drawable.i01n);
                  break;
               case "02d":
                  imageView.setImageResource(R.drawable.i02d);
                  break;
               case "02n":
                  imageView.setImageResource(R.drawable.i02n);
                  break;
               case "03d":
                  imageView.setImageResource(R.drawable.i03d);
                  break;
               case "03n":
                  imageView.setImageResource(R.drawable.i03n);
                  break;
               case "04d":
                  imageView.setImageResource(R.drawable.i04d);
                  break;
               case "04n":
                  imageView.setImageResource(R.drawable.i04n);
                  break;
               case "09d":
                  imageView.setImageResource(R.drawable.i09d);
                  break;
               case "09n":
                  imageView.setImageResource(R.drawable.i09n);
                  break;
               case "10d":
                  imageView.setImageResource(R.drawable.i10d);
                  break;
               case "10n":
                  imageView.setImageResource(R.drawable.i10n);
                  break;
               case "11d":
                  imageView.setImageResource(R.drawable.i11d);
                  break;
               case "11n":
                  imageView.setImageResource(R.drawable.i11n);
                  break;
               case "13d":
                  imageView.setImageResource(R.drawable.i13d);
                  break;
               case "13n":
                  imageView.setImageResource(R.drawable.i13n);
                  break;
               case "50d":
                  imageView.setImageResource(R.drawable.i50d);
                  break;
               case "50n":
                  imageView.setImageResource(R.drawable.i50n);
                  break;
            }

            String output;

            //set temperature
            final TextView tempView = getActivity().findViewById(R.id.tempView1);
            output = s.getCurrent().getTemp() + " Degrees";
            tempView.setText(output);

            //set feels like temperature
            final TextView feelsView = getActivity().findViewById(R.id.feelsLike1);
            output = "Feels Like " + s.getCurrent().getFeels_like() + " Degrees";
            feelsView.setText(output);

            //set humidity
            final TextView humidityView = getActivity().findViewById(R.id.humidityView1);
            output = "Humidity: " + s.getCurrent().getHumidity() + "%";
            humidityView.setText(output);

            //set wind speed
            final TextView windView = getActivity().findViewById(R.id.windView1);
            output = "Wind Speed: " + s.getCurrent().getWind_speed() + " mph";
            windView.setText(output);

            //set pressure
            final TextView pressureView = getActivity().findViewById(R.id.pressureView1);
            output = "Pressure: " + s.getCurrent().getPressure() + " hPA";
            pressureView.setText(output);

            //set visibility
            final TextView visibilityView = getActivity().findViewById(R.id.visibilityView1);
            output = "Visibility: " + s.getCurrent().getVisibility() + " meters";
            visibilityView.setText(output);

            //set weather condition
            final TextView conditionView = getActivity().findViewById(R.id.mainView1);
            conditionView.setText(s.getCurrent().getWeather()[0].getMain());

            //set detailed weather condition
            final TextView descView = getActivity().findViewById(R.id.descriptionView1);
            output = "Condition: " + s.getCurrent().getWeather()[0].getDescription().substring(0, 1).toUpperCase()
               + s.getCurrent().getWeather()[0].getDescription().toLowerCase().substring(1);
            descView.setText(output);


         }, error -> {
         });
      // Add the request to the Request Queue.
      queue.add(stringRequest);
   }


}