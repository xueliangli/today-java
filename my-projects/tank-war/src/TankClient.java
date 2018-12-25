import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*************************************************************************
 * 标号模板：
 *（1）（2）（3）（4）（5）（6）（7）（8）
 *（Ⅰ）（Ⅱ）（Ⅲ）（Ⅳ）（Ⅴ）（Ⅵ）（Ⅶ）（Ⅷ）（Ⅸ）（Ⅹ）（Ⅺ）（Ⅻ）
 *（一）（二）（三）（四）（五）（六）（七）（八）（九）（十）
 *
 *************************************************************************/
public class TankClient extends Frame {
    /**
     * （一）
     * 产生一个窗口，不考虑关闭窗口功能
     * （二）
     * 1、可以关闭窗口
     * 2、不改变窗口大小
     *
     */
    private void launchFrame() {
        this.setLocation(400, 300);
        this.setSize(800, 600);
        this.setTitle("tank war");
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setResizable(false);
        this.setBackground(Color.green);
        setVisible(true);

        new Thread(new PaintThread()).start();
    }
    /**
     * （三）
     *  画出代表坦克的实心圆
     *  注意：不要改变原来的前景色，x 轴，y 轴的方向
     * */
    private int x=50;
    private int y=50;
    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x,y,30,30);
        g.setColor(color);
        //坐标怎么变化
        y+=5;
    }
    /**
     * （四）让坦克动起来
     * 将坐标改成变量(paint 方法中的变量)，创建一个线程(属于创建窗口的线程)，使用内部类
     * 定时不断的刷新
     * repaint()方法直接调用父类中的 paint 方法
     * */
    private class PaintThread implements Runnable{
        @Override
        public void run() {
            while (true){
                repaint();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        TankClient tc = new TankClient();
        tc.launchFrame();
    }
}
