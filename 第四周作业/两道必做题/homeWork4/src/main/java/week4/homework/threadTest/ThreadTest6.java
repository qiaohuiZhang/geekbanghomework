package week4.homework.threadTest;

import java.util.concurrent.*;

/**
 * 作业题目：
 * 思考有多少种方式，在 main 函数启动一个新线程，运行一个方法，拿到这
 * 个方法的返回值后，退出主线程?
 */
public class ThreadTest6 {

    /**
     * 方法六：利用java线程池的submit后的返回对象Future的get方法阻塞主线程，可以保证子线程有返回结果后，主线程才继续往下走。
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("主线程开始执行++++++++++");
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        try {
            Thread thread = new Thread(() -> {
                System.out.println("子线程开始执行++++++++++");
                try {
                    Thread.sleep(3000); //假设任务需要3秒完成
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("子线程执行结束++++++++++");
            });
            Future future = executorService.submit(thread);//开启子线程
            future.get();
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行结束++++++++++");
        executorService.shutdown();
    }
}