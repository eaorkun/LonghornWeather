package utexas.eaorkun.longhornweather;

public class WeatherDaily
{
   private final int dt;
   private final Temperature temp;
   private final String pressure;
   private final String humidity;
   private final String wind_speed;
   private final Weather[] weather;
   private final String clouds;
   private final String pop;

   public WeatherDaily(int dt, Temperature temp, String pressure, String humidity, String wind_speed, Weather[] weather, String clouds, String pop)
   {
      this.dt = dt;
      this.temp = temp;
      this.pressure = pressure;
      this.humidity = humidity;
      this.wind_speed = wind_speed;
      this.weather = weather;
      this.clouds = clouds;
      this.pop = pop;
   }

   public int getDt()
   {
      return dt;
   }

   public Temperature getTemp()
   {
      return temp;
   }

   public String getPressure()
   {
      return pressure;
   }

   public String getHumidity()
   {
      return humidity;
   }

   public String getWind_speed()
   {
      return wind_speed;
   }

   public Weather[] getWeather()
   {
      return weather;
   }

   public String getClouds()
   {
      return clouds;
   }

   public String getPop()
   {
      return pop;
   }
}
