package designmode.singleton;

/**
 * 懒汉模式的单例
 *
 * @author ：隋亮亮
 * @since ：2020/7/3 0:03
 */
public class IdlerSingleton {
    private static IdlerSingleton singleton;

    public static IdlerSingleton getInstance() {
        if(singleton == null) {
            singleton = new IdlerSingleton();
        }

        return singleton;
    }


    public static void main(String[] args) {
        IdlerSingleton singleton = IdlerSingleton.getInstance();
        IdlerSingleton singleton1 = IdlerSingleton.getInstance();
        IdlerSingleton singleton2 = IdlerSingleton.getInstance();

        System.out.println(singleton == singleton1);
        System.out.println(singleton1 == singleton2);
    }
}
