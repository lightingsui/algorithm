package designmode.singleton;

/**
 * 单例的双重检查
 *
 * @author ：隋亮亮
 * @since ：2020/7/2 23:52
 */
public class DoubleCheckSingleton {
    private static volatile DoubleCheckSingleton singleton;

    public static DoubleCheckSingleton getInstance() {
        if(singleton == null) {
            synchronized (DoubleCheckSingleton.class) {
                if(singleton == null) {
                    singleton = new DoubleCheckSingleton();
                }
            }
        }

        return singleton;
    }


    public static void main(String[] args) {
        DoubleCheckSingleton singleton = DoubleCheckSingleton.getInstance();
        DoubleCheckSingleton singleton1 = DoubleCheckSingleton.getInstance();
        DoubleCheckSingleton singleton2 = DoubleCheckSingleton.getInstance();

        System.out.println(singleton == singleton1);
        System.out.println(singleton1 == singleton2);
    }
}
