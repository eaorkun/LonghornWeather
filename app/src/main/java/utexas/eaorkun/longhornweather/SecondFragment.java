package utexas.eaorkun.longhornweather;

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

import java.util.Locale;

public class SecondFragment extends Fragment
{

   @Override
   public View onCreateView(
      LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState
   )
   {
      // Inflate the layout for this fragment
      return inflater.inflate(R.layout.fragment_second, container, false);
   }

   public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
   {
      super.onViewCreated(view, savedInstanceState);
      volleyRequest(); //update data for 2nd fragment
      view.findViewById(R.id.button_second).setOnClickListener(view1 -> {
         NavHostFragment.findNavController(SecondFragment.this)
            .navigate(R.id.action_SecondFragment_to_ThirdFragment); //Transition to next fragment
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
            //convert json object to java object
            Gson g = new Gson();
            WeatherJson wJson = g.fromJson(response, WeatherJson.class);

            //set times for each temperature
            TextView[] textViewArray = {getActivity().findViewById(R.id.temp0_2),
               getActivity().findViewById(R.id.temp1_2),
               getActivity().findViewById(R.id.temp2_2),
               getActivity().findViewById(R.id.temp3_2),
               getActivity().findViewById(R.id.temp4_2),
               getActivity().findViewById(R.id.temp5_2),
               getActivity().findViewById(R.id.temp6_2)};

            for (int i = 0; i < 7; ++i)
            {
               TextView textView = textViewArray[i];
               String date = new java.text.SimpleDateFormat("HH", Locale.US).format(new java.util.Date((long) (wJson.getHourly()[i].getDt()) * 1000));
               int timeNum = Integer.parseInt(date);
               if (timeNum == 12)
               {
                  date = date + "PM";
               }
               else if (timeNum == 0)
               {
                  date = "12AM";
               }
               else if (timeNum > 12)
               {
                  timeNum = timeNum - 12;
                  date = timeNum + "PM";
               }
               else
               {
                  date = timeNum + "AM";
               }
               textView.setText(date);
            }

            //set weather icons for each time
            ImageView[] imageViewArray = {getActivity().findViewById(R.id.icon0_2),
               getActivity().findViewById(R.id.icon1_2),
               getActivity().findViewById(R.id.icon2_2),
               getActivity().findViewById(R.id.icon3_2),
               getActivity().findViewById(R.id.icon4_2),
               getActivity().findViewById(R.id.icon5_2),
               getActivity().findViewById(R.id.icon6_2)};

            for (int i = 0; i < 7; i++)
            {
               ImageView imageView = imageViewArray[i];
               String icon = wJson.getHourly()[i].getWeather()[0].getIcon();

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
            }

            //set actual temperature for each time
            TextView[] degViewArray = {getActivity().findViewById(R.id.deg0_2),
               getActivity().findViewById(R.id.deg1_2),
               getActivity().findViewById(R.id.deg2_2),
               getActivity().findViewById(R.id.deg3_2),
               getActivity().findViewById(R.id.deg4_2),
               getActivity().findViewById(R.id.deg5_2),
               getActivity().findViewById(R.id.deg6_2)};

            for (int i = 0; i < 7; ++i)
            {
               TextView textView = degViewArray[i];
               String output = wJson.getHourly()[i].getTemp() + " Degrees";
               textView.setText(output);
            }


         }, error -> {
         });
      // Add the request to the Request Queue.
      queue.add(stringRequest);
   }

}