package utexas.eaorkun.longhornweather;

public class WeatherHourly {
    private String temp;
    private String feels_like;
    private String pressure;
    private String humidity;
    private String clouds;
    private String visibility;
    private String wind_speed;
    private Weather[] weather;
    private String pop;

    public WeatherHourly(String temp, String feels_like, String pressure, String humidity, String clouds, String visibility, String wind_speed, Weather[] weather, String pop) {
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

    public String getTemp() {
        return temp;
    }

    public String getFeels_like() {
        return feels_like;
    }

    public String getPressure() {
        return pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getClouds() {
        return clouds;
    }

    public String getVisibility() {
        return visibility;
    }

    public String getWind_speed() {
        return wind_speed;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public String getPop() {
        return pop;
    }
}
