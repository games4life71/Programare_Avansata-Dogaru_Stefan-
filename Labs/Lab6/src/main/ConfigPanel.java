

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel
{

    final MainFrame frame;

    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton;

    //the button that has the "Exit" functionality
    public ConfigPanel(MainFrame frame)
    {

        this.frame = frame;
        init();

    }

    public void init()
    {
        //create the label and the spinner
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));

        linesLabel = new JLabel("Edge probability:");
        linesCombo = new JComboBox(new Double[]{0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0});
        linesCombo.setSelectedIndex(9);
        createButton = new JButton("Create");



        //create the rest of the components

        add(linesCombo);
        add(linesLabel);
        add(dotsLabel); //JPanel uses FlowLayout by default
        add(dotsSpinner);
        add(createButton);



        //listeners for the buttons


        createButton.addActionListener(this::createGame);
    }

    private void exitGame(ActionEvent e)
    {
        frame.dispose();
    }

    private void createGame(ActionEvent e)
    {
        //TODO
        int numVertices = (Integer) dotsSpinner.getValue();
        double edgeProbability = (Double) linesCombo.getSelectedItem();
        frame.drawingPanel.createBoard(); //call the method in the MainFrame class




    }
}
