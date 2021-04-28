package utexas.eaorkun.longhornweather;

public class WeatherDaily {
    Temperature temp;
    String pressure;
    String humidity;
    String wind_speed;
    Weather[] weather;
    String clouds;
    String pop;

    public WeatherDaily(Temperature temp, String pressure, String humidity, String wind_speed, Weather[] weather, String clouds, String pop) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.wind_speed = wind_speed;
        this.weather = weather;
        this.clouds = clouds;
        this.pop = pop;
    }

    public Temperature getTemp() {
        return temp;
    }

    public String getPressure() {
        return pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getWind_speed() {
        return wind_speed;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public String getClouds() {
        return clouds;
    }

    public String getPop() {
        return pop;
    }
}
