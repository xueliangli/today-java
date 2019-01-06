import java.awt.*;

/**
 * 吃了就可以涨血
 */
public class Blood {
    private int x, y, w, h;
    private TankClient tc;
    private int step = 0;
    //定义血块位置
    private int[][] pos = {
            {300, 400}, {500, 600}, {200, 100}, {430, 230}, {330, 540}, {100, 300}, {70, 80}, {300, 300}, {170, 180}, {90, 300}, {210, 110}
    };
    //血块是否被吃掉
    private boolean live = true;

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public void draw(Graphics g) {
        if (!live) return;
        Color color = g.getColor();
        g.setColor(Color.MAGENTA);
        g.fillRect(x, y, w, h);
        g.setColor(color);

        move();
    }

    private void move() {
        step++;
        if (step == pos.length) {
            step = 0;
        }
        x = pos[step][0];
        y = pos[step][1];
    }

    public Blood() {
        x = pos[0][0];
        y = pos[0][1];
        w = 15;
        h = 15;
    }

    /**
     * 添加吃血块的碰撞
     */
    public Rectangle getRect() {
        return new Rectangle(x, y, w, h);
    }
}
