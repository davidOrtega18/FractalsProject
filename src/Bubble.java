import java.awt.*;

public record Bubble(int x, int y, Color color, int radius) implements FractalElement {





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
        g.setColor(new Color(color.getRed()/255.f, color.getGreen()/255.f,color.getBlue()/255.f,.4f));
        g.fillOval(  graphX - radius ,graphY - radius , radius * 2 ,radius * 2 );

        g.setColor(color);
        
        g.drawOval(  graphX - radius ,graphY - radius ,radius * 2 ,radius * 2 );







    }
}