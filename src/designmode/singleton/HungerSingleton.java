package designmode.singleton;

/**
 * 饿汉模式的单例
 *
 * @author ：隋亮亮
 * @since ：2020/7/3 0:06
 */
public class HungerSingleton {
    private static HungerSingleton singleton = new HungerSingleton();

    public static HungerSingleton getInstance() {
        return singleton;
    }


    public static void main(String[] args) {
        HungerSingleton singleton = HungerSingleton.getInstance();
        HungerSingleton singleton1 = HungerSingleton.getInstance();
        HungerSingleton singleton2 = HungerSingleton.getInstance();

        System.out.println(singleton == singleton1);
        System.out.println(singleton1 == singleton2);
    }
}
