import java.awt.Graphics;

/**
 * Requirements for fractal elements that will be drawn
 *
 * @author     David Ortega
 * @version    12/14/2021
 */
public interface FractalElement {

    /**
     * draws the fractal element
     * @param g                 the Graphics reference for this drawing context
     * @param displayWidth      the width of the display window
     * @param displayHeight     the height of the display window
     */
    void draw(Graphics g, int displayWidth, int displayHeight);

}