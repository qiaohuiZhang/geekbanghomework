package week4.homework.threadTest;

/**
 * 作业题目：
 * 思考有多少种方式，在 main 函数启动一个新线程，运行一个方法，拿到这
 * 个方法的返回值后，退出主线程?
 */
public class ThreadTest1 {

    /**
     * 方法一：在子线程中设置一个成员变量signalFlag作为标记，在子线程执行结束时改变它的值。
     * 而主线程在开启子线程后，用while循环每隔1秒就检查一次这个标记，一旦标记发生变化，主线程再睡一秒后结束循环，
     * 这样能确保主线程在子线程结束后再结束。
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("主线程开始执行++++++++++");
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
        while(true){
            try {
                if(myThread1.isSignalFlag()){
                    Thread.sleep(500);
                    break;
                }else{
                    Thread.sleep(1000);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("主线程执行结束++++++++++");
    }
}

class MyThread1 extends Thread {

    public boolean signalFlag = false;

    public boolean isSignalFlag() {
        return signalFlag;
    }

    public void setSignalFlag(boolean signalFlag) {
        this.signalFlag = signalFlag;
    }

    @Override
    public void run() {
        System.out.println("子线程开始执行++++++++++");
        try {
            Thread.sleep(3000); //假设任务需要3秒完成
            signalFlag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("子线程执行结束++++++++++");
    }

}