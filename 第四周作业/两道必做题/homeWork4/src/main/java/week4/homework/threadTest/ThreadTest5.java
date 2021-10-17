package week4.homework.threadTest;

import java.util.concurrent.CountDownLatch;

/**
 * 作业题目：
 * 思考有多少种方式，在 main 函数启动一个新线程，运行一个方法，拿到这
 * 个方法的返回值后，退出主线程?
 */
public class ThreadTest5 {

    /**
     * 方法五：使用java.util.concurrent包下的CountDownLatch，计数器设为1，在子线程结束后调用countDown方法，
     * 主线程在计数器不为0时阻塞，为0后则可以继续进行。
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("主线程开始执行++++++++++");
        int coutTotal = 1;
        CountDownLatch countDownLatch = new CountDownLatch(coutTotal);
        try {
            Thread thread = new Thread(() -> {
                System.out.println("子线程开始执行++++++++++");
                try {
                    Thread.sleep(3000); //假设任务需要3秒完成
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("子线程执行结束++++++++++");
                countDownLatch.countDown();
            });
            thread.start(); //开启子线程
            countDownLatch.wait();
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行结束++++++++++");
    }
}