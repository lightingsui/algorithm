package others;

/**
 * 多线程循环打印字母
 *
 * @author ：隋亮亮
 * @since ：2020/8/8 20:03
 */
public class MultithreadedPrintAlpha implements Runnable {
    private final static Object LOCK = new Object();

    private static int current = 0;

    public static String alpha[] = new String[]{"A", "B", "C"};

    public int threadNum;

    public static int printCount = 3;

    public static int currentPrintCount = 0;

    public MultithreadedPrintAlpha(int threadNum) {
        this.threadNum = threadNum;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (LOCK) {
                while(threadNum != current) {
                    if(currentPrintCount == printCount) {
                        break;
                    }

                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if(currentPrintCount == printCount) {
                    break;
                }

                if("C".equals(alpha[current])) {
                    currentPrintCount++;
                }

                System.out.println("thread " + threadNum + "  print "
                        + alpha[current]);
                current = (++current) % alpha.length;
                LOCK.notifyAll();
            }
        }
    }


    public static void main(String[] args) {
        int threadCount = 3;

        for (int i = 0; i < threadCount; i++) {
            new Thread(new MultithreadedPrintAlpha(i)).start();
        }

    }
}
