package designmode.observer;

/**
 * 场景：<br/>一个天气预报类，{@link WeatherData} 是一个
 * 获取天气信息的类，当其中的温度等信息更新后，实时的通知
 * {@link Pannel1} 和 {@link Pannel2}
 *
 * @author sui
 */
public class Main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        Pannel1 pannel1 = new Pannel1(weatherData);
        Pannel2 pannel2 = new Pannel2(weatherData);

        weatherData.setData(23.2f, 25.34f, 1024);
    }
}
