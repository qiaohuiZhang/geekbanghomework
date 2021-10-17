package week4.homework.threadTest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 作业题目：
 * 思考有多少种方式，在 main 函数启动一个新线程，运行一个方法，拿到这
 * 个方法的返回值后，退出主线程?
 */
public class ThreadTest7 {

    /**
     * 方法七：使用java.util.concurrent.locks.ReentrantLock，创建一把锁，让子线程先拿到锁，执行完后再释放，
     * 而主线程因为拿不到锁，一直阻塞，直到拿到锁后才能往下走。
     * @param args
     */
    public static void main(String[] args) {
        final ReentrantLock lock = new ReentrantLock();
        System.out.println("主线程开始执行++++++++++");
        try {
            Thread thread = new Thread(() -> {
                System.out.println("子线程开始执行++++++++++");
                try {
                    lock.lock();
                    Thread.sleep(3000); //假设任务需要3秒完成
                    lock.unlock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("子线程执行结束++++++++++");
            });
            thread.start();
            Thread.sleep(1000);//主线程停一下，确保子线程先拿到锁
            lock.lock();
            lock.unlock();
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行结束++++++++++");
    }
}