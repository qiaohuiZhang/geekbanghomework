package week7.homework.service;

public class TestBatch {
    public static void main(String[] args) {
        for (int i = 1; i <=10; i++) {
            new OrderBatchService().start();
        }
    }
}
