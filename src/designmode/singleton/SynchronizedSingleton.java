package designmode.singleton;

public class SynchronizedSingleton {
    private static SynchronizedSingleton uniqInstance;

    private SynchronizedSingleton() {}

    public static synchronized SynchronizedSingleton getInstance() {
        if(uniqInstance == null) {
            uniqInstance = new SynchronizedSingleton();
        }

        return uniqInstance;
    }

    public void doWork() {
        System.out.println("doWork");
    }
}