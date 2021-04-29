package utexas.eaorkun.longhornweather;

public class WeatherHourly
{
   private final int dt;
   private final String temp;
   private final String feels_like;
   private final String pressure;
   private final String humidity;
   private final String clouds;
   private final String visibility;
   private final String wind_speed;
   private final Weather[] weather;
   private final String pop;

   public WeatherHourly(int dt, String temp, String feels_like, String pressure, String humidity, String clouds, String visibility, String wind_speed, Weather[] weather, String pop)
   {
      this.dt = dt;
      this.temp = temp;
      this.feels_like = feels_like;
      this.pressure = pressure;
      this.humidity = humidity;
      this.clouds = clouds;
      this.visibility = visibility;
      this.wind_speed = wind_speed;
      this.weather = weather;
      this.pop = pop;
   }

   public int getDt()
   {
      return dt;
   }

   public String getTemp()
   {
      return temp;
   }

   public String getFeels_like()
   {
      return feels_like;
   }

   public String getPressure()
   {
      return pressure;
   }

   public String getHumidity()
   {
      return humidity;
   }

   public String getClouds()
   {
      return clouds;
   }

   public String getVisibility()
   {
      return visibility;
   }

   public String getWind_speed()
   {
      return wind_speed;
   }

   public Weather[] getWeather()
   {
      return weather;
   }

   public String getPop()
   {
      return pop;
   }
}
