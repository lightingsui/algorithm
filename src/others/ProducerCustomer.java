package others;

/**
 * 生产者消费者
 *
 * @author ：隋亮亮
 * @since ：2020/8/9 11:21
 */
public class ProducerCustomer {
    public static int number = 0;

    private final static Object LOCK = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Producer());
        Thread thread2 = new Thread(new Producer());
        Thread thread3 = new Thread(new Customer());
        Thread thread4 = new Thread(new Customer());
        Thread thread5 = new Thread(new Customer());

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }




    private static class Producer implements Runnable {
        @Override
        public void run() {
            while(true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while(number >= 10) {
                        try {

                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getId() + "生产了 1 件商品");
                    number++;
                    LOCK.notifyAll();
                }
            }
        }
    }

    private static class Customer implements Runnable {

        @Override
        public void run() {
            while(true) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK) {
                    while(number <= 0) {
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    number--;

                    System.out.println(Thread.currentThread().getId() + "消费了 1 件商品");

                    LOCK.notifyAll();
                }
            }
        }
    }
}
