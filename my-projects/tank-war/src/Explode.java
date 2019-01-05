import java.awt.*;

class Explode {
    private int x,y;
    private boolean live=true;
    private int[] diameter={4,7,12,16,26,32,49,30,14,6};
    //现在画到第几步了
    private int step=0;
    private TankClient tc;

    Explode(int x, int y, TankClient tc) {
        this.x = x;
        this.y = y;
        this.tc = tc;
    }

    void draw(Graphics g){
        if (!live) {
            tc.explodes.remove(this);
            return;
        }
        if (step==diameter.length){
            live=false;
            step=0;
            return;
        }
        Color color = g.getColor();
        g.setColor(Color.ORANGE);
        g.fillOval(x,y,diameter[step],diameter[step]);
        g.setColor(color);
        step++;
    }
}
