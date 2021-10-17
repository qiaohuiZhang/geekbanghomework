package week4.homework.threadTest;

/**
 * 作业题目：
 * 思考有多少种方式，在 main 函数启动一个新线程，运行一个方法，拿到这
 * 个方法的返回值后，退出主线程?
 */
public class ThreadTest2 {

    /**
     * 方法二：开启子线程后，让子线程执行join方法，使得当前主线程阻塞直到子线程执行完成，
     * 故而能保证主线程再子线程执行完成之后才完成。
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
            thread.join();
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行结束++++++++++");
    }
}