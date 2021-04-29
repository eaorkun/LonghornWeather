package utexas.eaorkun.longhornweather;

public class Temperature
{
   private final String day;
   private final String min;
   private final String max;
   private final String night;
   private final String eve;
   private final String morn;

   public Temperature(String day, String min, String max, String night, String eve, String morn)
   {
      this.day = day;
      this.min = min;
      this.max = max;
      this.night = night;
      this.eve = eve;
      this.morn = morn;
   }

   public String getDay()
   {
      return day;
   }

   public String getMin()
   {
      return min;
   }

   public String getMax()
   {
      return max;
   }

   public String getNight()
   {
      return night;
   }

   public String getEve()
   {
      return eve;
   }

   public String getMorn()
   {
      return morn;
   }
}
