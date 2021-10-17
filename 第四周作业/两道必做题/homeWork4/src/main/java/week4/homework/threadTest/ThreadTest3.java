package week4.homework.threadTest;

/**
 * 作业题目：
 * 思考有多少种方式，在 main 函数启动一个新线程，运行一个方法，拿到这
 * 个方法的返回值后，退出主线程?
 */
public class ThreadTest3 {

    /**
     * 方法三：开启子线程后，主线程开始监听子线程的线程状态是否还“活着”，如果还活着，为了节省cpu，可以睡眠1秒，之后在继续监听
     * 子线程的状态，如果子线程die，那么说明子线程已经执行完，主线程接下来再睡眠1秒，然后结束。
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("主线程开始执行++++++++++");
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
            thread.start(); //开启子线程

            while (true) {
                if (!thread.isAlive()) {
                    Thread.sleep(500);
                    break;
                } else {
                    Thread.sleep(1000);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行结束++++++++++");
    }
}