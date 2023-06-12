import java.awt.Color;
import java.util.ArrayList;

/**
 * Interface for a Subject in our fractal world
 *
 * @author       David Ortega
 * @version    12/14/2021
 */
public interface FractalSubject {

    /**
     * Receives updated data and stores it
     * @param childRatio        the ratio of child size to parent size, e.g., 50 means 50% as big
     * @param recursionDepth    how many levels out to draw children; 1 means just the one big circle
     * @param color             the color for the fractal, or null to use random colors
     * @param childCount        the number of children each circle will have
     * @param bedlamLevel       the chaos level to be used; 0 is perfect and even
     */
    public void setData(double childRatio, int recursionDepth, Color color, int childCount, int bedlamLevel);

    /**
     * registers a new observer
     * @param observer          the observer to register
     */
    public void registerObserver(FractalObserver observer);

    /**
     * removes an existing observer
     * @param observer          the observer to unregister/unsubscribe
     */
    public void removeObserver(FractalObserver observer);

    /**
     * sends an update out to all observers on the list
     */
    public void notifyObservers();

    /**
     * retrieves all fractal data (in an ArrayList of FractalElement elements)
     * @return      all FractalElement objects  to be drawn
     */
    public ArrayList<FractalElement> getData();
}