import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FractalGui extends JFrame {
    FractalSubject subject;
    Color color;
    JSlider recursionDepthSlider, childRatioSlider, childCountSlider, bedlamLevelSlider;
    JLabel recursionDepthLabel, childToParentRatio, childCountLabel, bedLamLevelLabel;


    FractalGui(FractalSubject subject) {
        this.subject = subject;

        setTitle("Bubbles and BedLam fractal settings");
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JPanel mainPanel = new JPanel();
        setContentPane(mainPanel);
        mainPanel.setLayout(null);

        recursionDepthLabel = new JLabel("Recursion Depth");
        recursionDepthSlider = new JSlider(
                JSlider.HORIZONTAL, 2, 8, 2);
        recursionDepthSlider.setMajorTickSpacing(1);
        recursionDepthSlider.setMinorTickSpacing(1);
        recursionDepthSlider.setPaintTicks(true);
        recursionDepthSlider.setPaintLabels(true);
        recursionDepthSlider.setBounds(30, 50, 300, 50);
        recursionDepthLabel.setBounds(40, 20, 200, 50);
        recursionDepthSlider.setValue(3);
        mainPanel.add(recursionDepthLabel);
        mainPanel.add(recursionDepthSlider);
        recursionDepthSlider.addChangeListener(new updateCanvas());







        childToParentRatio = new JLabel("Child to parent ratio");
        childRatioSlider = new JSlider(JSlider.HORIZONTAL, 20, 70, 20);
        childRatioSlider.setMajorTickSpacing(10);
        childRatioSlider.setMinorTickSpacing(5);
        childRatioSlider.setPaintTicks(true);
        childRatioSlider.setPaintLabels(true);
        childRatioSlider.setBounds(30, 130, 300, 50);
        childToParentRatio.setBounds(40, 100, 200, 50);
        childRatioSlider.addChangeListener(new updateCanvas());

        mainPanel.add(childRatioSlider);
        mainPanel.add(childToParentRatio);


        childCountLabel = new JLabel("Child count");
        childCountSlider = new JSlider(JSlider.HORIZONTAL, 1, 11, 1);
        childCountSlider.setMajorTickSpacing(2);
        childCountSlider.setMinorTickSpacing(1);
        childCountSlider.setPaintTicks(true);
        childCountSlider.setPaintLabels(true);
        childCountSlider.setBounds(30, 210, 300, 50);
        childCountLabel.setBounds(40, 180, 200, 50);
        childRatioSlider.setValue(3);
        mainPanel.add(childCountSlider);
        mainPanel.add(childCountLabel);
        childCountSlider.addChangeListener(new updateCanvas());


        bedLamLevelLabel = new JLabel("Bedlam level");
        bedlamLevelSlider = new JSlider(JSlider.HORIZONTAL, 0, 4, 0);
        bedlamLevelSlider.setMajorTickSpacing(1);
        bedlamLevelSlider.setMinorTickSpacing(1);
        bedlamLevelSlider.setPaintTicks(true);
        bedlamLevelSlider.setPaintLabels(true);
        bedlamLevelSlider.setBounds(30, 290, 300, 50);
        bedLamLevelLabel.setBounds(40, 260, 200, 50);


        mainPanel.add(bedlamLevelSlider);
        mainPanel.add(bedLamLevelLabel);



        JCheckBox checkBox = new JCheckBox("Random Pastels");
        mainPanel.add(checkBox);
        checkBox.setBounds(40, 435, 180, 20);
        checkBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Color pastelColor = JColorChooser.showDialog(null, "Random Pastels ", color);
                if(pastelColor!= null){
                    color = pastelColor;
                }
            }
        });




        setVisible(true);
        JButton drawButton = new JButton("Fractal Color!");
        color = Color.GREEN;
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color coloCh = JColorChooser.showDialog(null, "Fractal Color", color);
                if (coloCh != null) {
                    color = coloCh;
                }

            }
        });

        drawButton.setBounds(40, 380, 200, 35);
        mainPanel.add(drawButton);



        JButton drawFractal = new JButton("DRAW FRACTAL!");
        drawFractal.setBounds(40, 480, 200, 35);
        drawFractal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subject.setData(childRatioSlider.getValue() / 100.0, recursionDepthSlider.getValue(), color, childCountSlider.getValue(), bedlamLevelSlider.getValue());


            }
        });

        mainPanel.add(drawFractal);
        subject.setData(childRatioSlider.getValue() / 100.0, recursionDepthSlider.getValue(), color, childCountSlider.getValue(), bedlamLevelSlider.getValue());


    }

    private class updateCanvas implements  ChangeListener{


        /**
         * Invoked when the target of the listener has changed its state.
         *
         * @param e a ChangeEvent object
         */
        @Override
        public void stateChanged(ChangeEvent e) {
            subject.setData(childRatioSlider.getValue() / 100.0, recursionDepthSlider.getValue(), color, childCountSlider.getValue(), bedlamLevelSlider.getValue());

        }
    }





}