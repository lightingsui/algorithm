package others;

/**
 * 多线程循环打印数字
 *
 * @author ：隋亮亮
 * @since ：2020/8/8 17:53
 */
public class MultithreadedPrintNumber implements Runnable {
    public static Object LOCK = new Object();

    private int maxNumber;

    private static int current = 0;

    private int threadNumber;

    private int threadCount;


    public MultithreadedPrintNumber(int maxNumber, int threadNumber, int threadCount) {
        this.maxNumber = maxNumber;
        this.threadNumber = threadNumber;
        this.threadCount = threadCount;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (LOCK) {
                while (current % threadCount != threadNumber) {
                    if (current > maxNumber) {
                        break;
                    }

                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (current > maxNumber) {
                    break;
                }

                System.out.println("Thread " + threadNumber + " print: " + current++);
                LOCK.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        int threadCount = 3;
        int maxNumber = 10;

        for (int i = 0; i < threadCount; i++) {
            new Thread(new MultithreadedPrintNumber(maxNumber, i, threadCount)).start();
        }
    }
}
