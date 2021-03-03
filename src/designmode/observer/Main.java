package designmode.observer;

public class Main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        Pannel1 pannel1 = new Pannel1(weatherData);
        Pannel2 pannel2 = new Pannel2(weatherData);

        weatherData.setData(23.2f, 25.34f, 1024);
    }
}
