import java.awt.*;
import java.util.ArrayList;



public class FractalGenerator implements FractalSubject {
    ArrayList<FractalObserver> observers;


    int childCount, recursionDepth, bedlamLevel;
    double childRatio;
    private Color color;

    public FractalGenerator() {

        observers = new ArrayList<>();


    }

    /**
     * Receives updated data and stores it
     *
     * @param childRatio     the ratio of child size to parent size, e.g., 50 means 50% as big
     * @param recursionDepth how many levels out to draw children; 1 means just the one big circle
     * @param color          the color for the fractal, or null to use random colors
     * @param childCount     the number of children each circle will have
     * @param bedlamLevel    the chaos level to be used; 0 is perfect and even
     */
    @Override
    public void setData(double childRatio, int recursionDepth, Color color, int childCount, int bedlamLevel) {

        this.childRatio = childRatio;
        this.recursionDepth = recursionDepth;
        this.color = color;
        this.childCount = childCount;
        this.bedlamLevel = bedlamLevel;


        notifyObservers();
    }


    /**
     * registers a new observer
     *
     * @param observer the observer to register
     */
    @Override
    public void registerObserver(FractalObserver observer) {
        observers.add(observer);

    }

    /**
     * removes an existing observer
     *
     * @param observer the observer to unregister/unsubscribe
     */
    @Override
    public void removeObserver(FractalObserver observer) {
        observers.remove(observer);

    }

    /**
     * sends an update out to all observers on the list
     */
    @Override
    public void notifyObservers() {
        for (FractalObserver observer : observers) {
            observer.update();
        }

    }

    /**
     * retrieves all fractal data (in an ArrayList of FractalElement elements)
     *
     * @return all FractalElement objects  to be drawn
     */
    @Override
    public ArrayList<FractalElement> getData() {
        ArrayList<FractalElement> fl = new ArrayList<>();


        generateFractal(0, 0, 100, recursionDepth, fl);
        return fl;

    }

    /**
     * Fills up the array with bubbles and arcs
     * @param x value of x at position 0
     * @param y value of y at position 0
     * @param radius radius of the circle
     * @param recursionDepth recursion depth
     * @param fl list to be filled with bubbles and arcs
     */



    private void generateFractal(int x, int y, int radius, int recursionDepth, ArrayList<FractalElement> fl) {

        if (recursionDepth == 0) {
            return;
        }

        fl.add(new Bubble(x, y, color, radius));
        fl.add(new Arc(x, y, color, radius));
        double childDelta = (2 * Math.PI) / childCount;
        int childRadius = (int) (radius * childRatio);
        for (int index = 0; index < childCount; index++) {
            int childX = x + (int) (Math.cos(Math.PI / 2 + childDelta * index) * (radius + childRadius));
            int childY = y - (int) (Math.sin(Math.PI / 2 + childDelta * index) * (radius + childRadius));
            generateFractal(childX, childY, childRadius, recursionDepth - 1, fl);


        }






    }
}
