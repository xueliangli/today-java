package javase.concurrency.test;

import java.util.Random;
/*************************************************************************
 *
 * 方法一：通过构造方法赋值
 * 在调用start方法之前通过线程类的构造方法将数据传入线程。
 * 并将传入的数据使用类变量保存起来，以便线程使用(其实就是在run方法中使用)。
 *
 * 方法二：通过set方法
 *
 * 方法三：通过回调函数
 * 以上两种方法都是main方法中主动将数据传入线程类的。需要在线程运行的过程中动态地获取数据
 * 案例：
 * run方法中产生了3个随机数，然后通过Work类的process方法求这三个随机数的和，并通过Data类的value将结果返回。
 * 从这个例子可以看出，在返回value之前，必须要得到三个随机数。也就是说，这个 value是无法事先就传入线程类的。
 *
 *************************************************************************/
public class TransmitDataTest implements Runnable {

    class Data {
        int value = 0;
    }

    private class Work {
        private void process(Data data, int[] numbers) {
            for (int i : numbers) {
                data.value += i;
            }
        }
    }

    @Override
    public void run() {
        Random random = new Random();
        int i1 = random.nextInt(100);
        int i2 = random.nextInt(100);
        int i3 = random.nextInt(100);
        Data data = new Data();
        Work work = new Work();
        int[] a = new int[]{i1, i2, i3};
        work.process(data, a);
        System.out.println(String.valueOf(i1) + "+"
                + String.valueOf(i2) + "+"
                + String.valueOf(i3) + "="
                + data.value);
    }

    public static void main(String[] args) {
        TransmitDataTest thd = new TransmitDataTest();
        new Thread(thd).start();

    }
}
