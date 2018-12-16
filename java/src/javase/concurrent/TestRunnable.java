package javase.concurrent;

import static java.lang.Thread.sleep;

public class TestRunnable implements Runnable{
    private String name;
    private TestRunnable(String name){
        this.name=name;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name+" 运行 "+i);
            try {
                sleep((long) (Math.random()*10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //通过调用 thread 类中的API
        new Thread(new TestRunnable("C")).start();
        new Thread(new TestRunnable("D")).start();
    }
}
