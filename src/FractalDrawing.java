import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Write a description of class FractalDrawing here.
 *
 * @author (David Ortega)
 * @version 12/14/2021
 */
public class FractalDrawing extends JFrame implements FractalObserver {
    FractalSubject subject;
    DrawingArea drawingArea;
    ArrayList<FractalElement> drawing;


    public FractalDrawing(FractalSubject subject) {
        this.subject = subject;
        this.subject.registerObserver(this);


        drawing = subject.getData();
        JFrame drawingFrame = new JFrame();
        drawingFrame.setTitle("Drawing Space");
        drawingFrame.setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        drawingArea = new DrawingArea();
        drawingFrame.setContentPane(drawingArea);
        drawingArea.setBackground(Color.BLACK);
        drawingFrame.setVisible(true);


    }

    @Override
    public void update() {
        drawing = subject.getData();
        drawingArea.repaint();


    }


    private class DrawingArea extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            for (FractalElement fl : drawing) {
                fl.draw(g, 800, 800);

            }
            drawing = subject.getData();


        }


    }
}








