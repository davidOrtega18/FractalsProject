import java.awt.*;

public record Arc( int x, int y, Color color,int radius) implements FractalElement {
    /**
     * draws the fractal element
     *
     * @param g             the Graphics reference for this drawing context
     * @param displayWidth  the width of the display window
     * @param displayHeight the height of the display window
     */
    @Override
    public void draw(Graphics g, int displayWidth, int displayHeight) {
        int graphX =  displayWidth / 2 + x;
        int graphY = displayHeight / 2 + y;

        int newRadius = radius * 75 / 100;

        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setStroke(new BasicStroke(radius /10.f));
        g.drawArc(graphX - newRadius ,graphY - newRadius , newRadius * 2 ,newRadius * 2,40,10);
        graphics2D.setStroke(new BasicStroke());



    }
}
