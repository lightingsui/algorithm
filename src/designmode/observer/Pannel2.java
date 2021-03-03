package designmode.observer;

public class Pannel2 implements Observer {
    private static final String CLASS_NAME = Pannel2.class.getSimpleName();

    public Pannel2(Subject subject) {
        subject.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        display(temperature, humidity, pressure);
    }

    public void display(float temperature, float humidity, float pressure) {
        System.out.println("----------Panner-2----------");
        System.out.println("current temperature: " + temperature);
        System.out.println("current humidity: " + humidity);
        System.out.println("current pressure: " + pressure);
        System.out.println();
    }
}
