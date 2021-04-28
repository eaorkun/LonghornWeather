package utexas.eaorkun.longhornweather;

public class WeatherJson {
    private String lat;
    private String lon;
    private String timezone;
    private WeatherCurrent current;
    private WeatherHourly[] hourly;
    private WeatherDaily[] daily;


    public WeatherJson(String lat, String lon, String timezone, WeatherCurrent current, WeatherHourly[] hourly, WeatherDaily[] daily) {
        this.lat = lat;
        this.lon = lon;
        this.timezone = timezone;
        this.current = current;
        this.hourly = hourly;
        this.daily = daily;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public String getTimezone() {
        return timezone;
    }

    public WeatherCurrent getCurrent() {
        return current;
    }

    public WeatherHourly[] getHourly() {
        return hourly;
    }

    public WeatherDaily[] getDaily() {
        return daily;
    }
}
