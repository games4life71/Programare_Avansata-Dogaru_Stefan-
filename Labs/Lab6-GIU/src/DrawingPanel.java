import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JPanel
{
    final MainFrame frame; //the frame that contains this panel
    final static int W = 800, H = 500; //the width and the height of the panel
    /*private int numVertices;
    private double edgeProbability;
    private int[] x, y;*/

    /*BufferedImage image; //the offscreen image
    Graphics2D graphics; //the tools needed to draw in the image*/

    public DrawingPanel(MainFrame frame)
    {
        this.frame = frame;
        init();

    }

    public void init()
    {

        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
//        this.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//                createBoard();
//                repaint();
//            }
//        });

    }

    @Override
    protected void paintComponent(Graphics g)
    {

        //get the number of dots (numVertices)
        int numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
        double edgeProbability = (Double) frame.configPanel.linesCombo.getSelectedItem();

        int[] x = new int[numVertices];
        int[] y = new int[numVertices];

        int x0 = W / 2; int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numVertices; // the angle
        x = new int[numVertices];
        y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }


        //get the probability that two dots form a line (edgeProbability)
        //draw the board, that is:
        //compute the coordinates of the dots
        //draw the dots
        for(int i = 0; i < numVertices; i++)
        {
            g.fillOval(x[i], y[i], 10, 10);
        }
        //draw the lines
        for(int i = 0; i < numVertices; i++)
        {
            for(int j = i + 1; j < numVertices; j++)
            {
                if(Math.random() < edgeProbability)
                {
                    g.drawLine(x[i], y[i], x[j], y[j]);
                }
            }
        }
    }


    public void createBoard()
    {
        paintComponent(this.getGraphics());
    }

    /**
     * clears the drawing panel
     */
    public void reset()
    {
        Graphics g = this.getGraphics();
        g.clearRect(0, 0, W, H);
    }
}
