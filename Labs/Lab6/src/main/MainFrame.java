import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{

    DrawingPanel drawingPanel;
    ConfigPanel configPanel;
    ControlSouth controlSouth;

    //constructor
    public MainFrame()
    {
        super("Super cool GUI");

        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        init();
    }

    private void init()
    {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        drawingPanel = new DrawingPanel(this, 100, 10, 10, 1);


        configPanel = new ConfigPanel(this);
        controlSouth = new ControlSouth(this);

        configPanel.setVisible(true);
        drawingPanel.setVisible(true);

        add(drawingPanel, BorderLayout.CENTER);
        add(configPanel, BorderLayout.NORTH);
        add(controlSouth, BorderLayout.SOUTH);
        pack();
    }
}
