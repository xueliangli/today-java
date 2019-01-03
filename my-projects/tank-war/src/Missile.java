import java.awt.*;

class Missile {
    private int x,y;
    private Tank.Direction dir;

    //子弹的长度高度
    static final int WIDTH=10;
    static final int HEIGHT=10;

    Missile(int x, int y, Tank.Direction dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    void draw(Graphics g){
        Color color = g.getColor();
        g.setColor(Color.BLACK);
        g.fillOval(x,y,WIDTH,HEIGHT);
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
    }
}
