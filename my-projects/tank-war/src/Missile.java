import java.awt.*;

class Missile {
    private int x, y;
    private Tank.Direction dir;

    //子弹的长度高度
    static final int WIDTH = 10;
    static final int HEIGHT = 10;

    Missile(int x, int y, Tank.Direction dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    void draw(Graphics g) {
        if (!live){
            tc.missiles.remove(this);
            return;
        }
        Color color = g.getColor();
        g.setColor(Color.BLACK);
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(color);
        move();
    }

    private void move() {
        //步进值
        int X = 10;
        int Y = 10;
        switch (dir) {
            case L:
                x -= X;
                break;
            case LU:
                x -= X;
                y -= Y;
                break;
            case LD:
                x -= X;
                y += Y;
                break;
            case R:
                x += X;
                break;
            case RU:
                x += X;
                y -= Y;
                break;
            case RD:
                x += X;
                y += Y;
                break;
            case U:
                y -= Y;
                break;
            case D:
                y += Y;
                break;
        }
        if (x < 0 || y < 0 || x > TankClient.GAME_WIDTH || y > TankClient.GAME_HEIGHT) {
            live = false;
//            tc.missiles.remove(this);  在移动之前判断，如果已经死了，就把它移除出去
        }
    }

    private boolean live = true;

    boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }
    private TankClient tc;

    Missile(int x, int y, Tank.Direction dir, TankClient tc) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tc = tc;
    }
    /**
     * （1.6）子弹碰到敌方坦克后使其消失
     * 碰撞检测
     * 子弹和坦克后有包装的小方块
     * */
    private Rectangle getRect(){
        return new Rectangle(x,y,WIDTH,HEIGHT);
    }

    boolean hitTank(Tank t){
        //不加第二个判断条件则子弹会击中已经死了的坦克
        if (this.getRect().intersects(t.getRect())&&t.isLive()){
            t.setLive(false);
            this.live=false;
            Explode e=new Explode(x,y,tc);
            tc.explodes.add(e);
            return true;
        }
        return false;
    }
}
