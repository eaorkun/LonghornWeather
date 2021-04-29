package utexas.eaorkun.longhornweather;

//Main Java class which stores all the information from the json object from API

public class WeatherJson
{
   private final String lat;
   private final String lon;
   private final String timezone;
   private final WeatherCurrent current;
   private final WeatherHourly[] hourly;
   private final WeatherDaily[] daily;


   public WeatherJson(String lat, String lon, String timezone, WeatherCurrent current, WeatherHourly[] hourly, WeatherDaily[] daily)
   {
      this.lat = lat;
      this.lon = lon;
      this.timezone = timezone;
      this.current = current;
      this.hourly = hourly;
      this.daily = daily;
   }

   public String getLat()
   {
      return lat;
   }

   public String getLon()
   {
      return lon;
   }

   public String getTimezone()
   {
      return timezone;
   }

   public WeatherCurrent getCurrent()
   {
      return current;
   }

   public WeatherHourly[] getHourly()
   {
      return hourly;
   }

   public WeatherDaily[] getDaily()
   {
      return daily;
   }
}
