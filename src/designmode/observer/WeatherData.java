package designmode.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
    private List<Observer> observers;

    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    public void setData(float temperature, float humidity, float pressure) {
        this.pressure = pressure;
        this.temperature = temperature;
        this.humidity = humidity;

        notifyAllObserver();
    }


    @Override
    public void registerObserver(Observer observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observer != null) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyAllObserver() {
        // 唤醒所有观察者
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }
}
