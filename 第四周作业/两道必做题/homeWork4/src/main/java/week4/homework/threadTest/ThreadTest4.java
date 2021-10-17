package week4.homework.threadTest;

/**
 * 作业题目：
 * 思考有多少种方式，在 main 函数启动一个新线程，运行一个方法，拿到这
 * 个方法的返回值后，退出主线程?
 */
public class ThreadTest4 {

    /**
     * 方法四：开启子线程后，主线程进入等待状态，等到子线程执行完，通过notify方法唤醒主线程，最终主线程才结束。
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("主线程开始执行++++++++++");
        Object oo = new Object();
        try {
            Thread thread = new Thread(() -> {
                System.out.println("子线程开始执行++++++++++");
                try {
                    Thread.sleep(3000); //假设任务需要3秒完成
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("子线程执行结束++++++++++");
                synchronized (oo){
                    oo.notify();
                }
            });
            thread.start(); //开启子线程
            synchronized (oo){
                oo.wait();
            }
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行结束++++++++++");
    }
}