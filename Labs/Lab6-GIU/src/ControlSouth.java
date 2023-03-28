import javax.swing.*;

public class ControlSouth extends  JPanel
{
    final MainFrame frame;

    JButton loadButton;
    JButton saveButton;
    JButton exitButton;
    JButton resetButton;
    public ControlSouth(MainFrame frame)
    {
        this.frame = frame;
        init();

    }

    public void init()
    {
        loadButton = new JButton("Load");
        saveButton = new JButton("Save");
        exitButton = new JButton("Exit");
        resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> frame.drawingPanel.reset());
        exitButton.addActionListener(e -> frame.dispose());
        add(loadButton);
        add(resetButton);
        add(saveButton);
        add(exitButton);


    }
}
