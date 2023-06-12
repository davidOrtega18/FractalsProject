/**
 * Interface for an Observer in our fractal world
 *
 * @author      David Ortega
 * @version     12/14/2021
 */
public interface FractalObserver {

    /**
     * Tells the observer that an update has occurred, permitting
     * it to act on that update if it desires
     */
    public void update();
}