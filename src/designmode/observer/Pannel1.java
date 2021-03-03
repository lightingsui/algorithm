package designmode.observer;

public class Pannel1 implements Observer {
    private static final String CLASS_NAME = Pannel1.class.getSimpleName();

    public Pannel1(Subject subject) {
        subject.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        display(temperature, humidity, pressure);
    }

    public void display(float temperature, float humidity, float pressure) {
        System.out.println("----------Panner-1----------");
        System.out.println("current temperature: " + temperature);
        System.out.println("current humidity: " + humidity);
        System.out.println("current pressure: " + pressure);
        System.out.println();
    }
}
