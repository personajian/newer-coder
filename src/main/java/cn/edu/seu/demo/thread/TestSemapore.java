package cn.edu.seu.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**《Java并发编程艺术》P192
 * @Author personajian
 * @Date 2017/9/2 16:33
 */
public class TestSemapore {

    private static final int THREAD_COUNT=30;

    private static ExecutorService threadPool= Executors.newFixedThreadPool(THREAD_COUNT);

    private static Semaphore s=new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        s.acquire();
                        System.out.println("save data");
                        s.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        threadPool.shutdown();
    }
}
