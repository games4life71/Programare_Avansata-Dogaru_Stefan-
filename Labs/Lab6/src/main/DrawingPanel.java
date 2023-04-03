import com.fasterxml.jackson.databind.ObjectMapper;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class DrawingPanel extends JPanel implements Serializable
{
    final MainFrame frame; //the frame that contains this panel
    final static int W = 800, H = 500; //the width and the height of the panel
    /*private int numVertices;
    private double edgeProbability;
    private int[] x, y;*/

    /*BufferedImage image; //the offscreen image
    Graphics2D graphics; //the tools needed to draw in the image*/
    List<Lines> lines = new java.util.ArrayList<>();
    List<MyPoint> points = new java.util.ArrayList<>();
    //final MyPoint[] points = new MyPoint[10];
    private final int numVertices;

    private final double edgeProbability;
    private int player = 0; //player turns  0 ->red, 1 -> blue
    private int WIN = 0; //win flag

    private GameState gameState;

    //adjacency matrix for the graph
    private static int[][] adjMatrix = new int[100][100];


    /**
     * Checks for a vertical line if the mouse is in proximity of it
     *
     * @param x
     * @param y
     * @param x1
     * @param y1
     * @param y2
     * @return
     */
    private Boolean isNearLine(int x, int y, double x1, double y1, double y2)
    {
        if (y < y1 && y > y2)
        {
            if (Math.abs(x - x1) < 15)
            {
                return true;
            }

        }
        return false;
    }


    public DrawingPanel(MainFrame frame, int numVertices, int x, int y, double edgeProbability)
    {
        this.frame = frame;
        this.numVertices = numVertices;

        this.edgeProbability = edgeProbability;

        this.gameState = new GameState(numVertices, edgeProbability);

        init();
        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                //when the mouse is pressed the line at the given coordoanete is colored

                int mouse_x = e.getX();
                int mouse_y = e.getY();

                //check if the mouse is pressed on a line
                for (Lines line : lines)
                {

                    //compute the slope
                    double slope = (line.getP1().getY() - line.getP2().getY()) / (line.getP1().getX() - line.getP2().getX());
                    //case for vertical lines
                    int isVertical = 0;
                    if (slope == Double.POSITIVE_INFINITY || slope == Double.NEGATIVE_INFINITY)
                    {
                        //set the slope to max value

                        isVertical = 1;
                    }


                    double left_hand = mouse_y - line.getP1().getY(); //y-y1
                    double right_hand = slope * (mouse_x - line.getP1().getX()); //m(x-x1)


                    if (Math.abs(left_hand - right_hand) < 15 || (isVertical == 1 && isNearLine(mouse_x, mouse_y, line.getP1().getX(), line.getP1().getY(), line.getP2().getY())))
                    {


                        //color the line
                        if (line.getColored())
                        {
                            System.out.printf("[ERROR] Line already colored!");
                            break;
                        }

                        Graphics g = getGraphics();

                        if (player == 0)
                        {
                            //color the line with blue
                            g.setColor(Color.BLUE);
                            line.setColored(true);
                            line.setColor("blue");
                            //complete the adjacency matrix
                            adjMatrix[line.getP1().getId()][line.getP2().getId()] = 1;
                            adjMatrix[line.getP2().getId()][line.getP1().getId()] = 1;


                            //check if the game is over --> game is over when a cycle of length 3 is formed

                            detectWin(adjMatrix, new boolean[100], 2, line.getP1().getId(), line.getP1().getId(), 1);
                            if (WIN == 1)
                            {
                                // System.out.println("[DEBUG] win detected ! " );
                                JOptionPane.showMessageDialog(null, "Blue player won!");
                                WIN = 0;
                                //make a scrrenshot of the game
//                                BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
//
//                                Graphics2D g2 = image.createGraphics();
//                                paint(g2);
//                                try
//                                {
//
//                                    ImageIO.write(image, "png", new File("D:\\Projects\\Java\\Programare_Avansata-Dogaru_Stefan-\\Labs\\Lab6-GIU\\resources"));
//                                } catch (IOException ex)
//                                {
//                                    System.out.println("[ERROR] Could not save the image!");
//                                }
                                takeScreenshot();
                            }
                            //change the player
                            player = 1;

                        } else
                        {
                            g.setColor(Color.RED);
                            line.setColored(true);
                            line.setColor("red");

                            //complete the adjacency matrix
                            adjMatrix[line.getP1().getId()][line.getP2().getId()] = 2;
                            adjMatrix[line.getP2().getId()][line.getP1().getId()] = 2;
                            //check if the game is over --> game is over when a cycle of length 3 is formed
                            detectWin(adjMatrix, new boolean[100], 2, line.getP1().getId(), line.getP1().getId(), 2);
                            if (WIN == 1)
                            {
                                // System.out.println("[DEBUG] win detected ! " );
                                JOptionPane.showMessageDialog(null, "Red player won!");
                                WIN = 0;
//                                //make a scrrenshot of the game
//                                BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
//
//                                Graphics2D g2 = image.createGraphics();
//                                paint(g2);
//                                try
//                                {
//
//                                    ImageIO.write(image, "png", new File("D:\\Projects\\Java\\Programare_Avansata-Dogaru_Stefan-\\Labs\\Lab6-GIU\\resources"));
//                                } catch (IOException ex)
//                                {
//                                    System.out.println("[ERROR] Could not save the image!");
//                                }
                                takeScreenshot();
                            }
                            player = 0;
                        }
                        //print the adjacency matrix
//                        for (int i = 0; i < 10; i++)
//                        {
//                            for (int j = 0; j < 10; j++)
//                            {
//                                System.out.print(adjMatrix[i][j] + " ");
//                            }
//                            System.out.println();
//                        }
                        // System.out.println("----------------------------------------------------");
                        //save the color of the line

                        g.drawLine(line.getP1().x, line.getP1().y, line.getP2().x, line.getP2().y);
                    }


                }


            }
        });

    }


    /**
     * Checks if the game is over by checking if a cycle of length 3 is formed
     *
     * @param graph
     * @param marked
     * @param n
     * @param vert
     * @param start
     * @param color
     */
    private void detectWin(int graph[][], boolean marked[], int n, int vert, int start, int color)
    {

        // mark the vertex vert as visited
        marked[vert] = true;

        // if the path of length (n-1) is found BASE CASE
        if (n == 0)
        {

            // mark vert as un-visited to
            // make it usable again


            // Check if vertex vert end
            // with vertex start
            if (graph[vert][start] == color)
            {
                System.out.println("[DEBUG] win detected ! ");
                WIN = 1;


            }
            return;
        }

        // For searching every possible
        // path of length (n-1)
        for (int i = 0; i < 10; i++)

            //if it is not visited and it is adjacent to vert
            if (!marked[i] && graph[vert][i] == color)
            {
                // decreasing length by 1
                detectWin(graph, marked, n - 1, i, start, color);


            }

        // marking vert as unvisited to make it
        // usable again


    }

    /**
     * Initializes the board
     */
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

        int x0 = W / 2;
        int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numVertices; // the angle
        x = new int[numVertices];
        y = new int[numVertices];


        for (int i = 0; i < numVertices; i++)
        {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }


        //get the probability that two dots form a line (edgeProbability)
        //draw the board, that is:
        //compute the coordinates of the dots
        //draw the dots
        for (int i = 0; i < numVertices; i++)
        {
            g.drawOval(x[i], y[i], 10, 10);
            //add the point to the points array
            points.add(new MyPoint(x[i], y[i], i));
        }
        //draw the lines
        for (int i = 0; i < numVertices; i++)
        {

            for (int j = i + 1; j < numVertices; j++)
            {
                if (Math.random() < edgeProbability)
                {

                    ((Graphics2D) g).setStroke(new BasicStroke(3));
                    g.drawLine(x[i], y[i], x[j], y[j]);
                    //add the line to the lines array

                    lines.add(new Lines(new MyPoint(x[i], y[i], i), new MyPoint(x[j], y[j], j)));

                }
            }
        }
    }


    public void createBoard()
    {
        paintComponent(this.getGraphics());
        //create a board from the json file
        //read the json file

    }

    /**
     * clears the drawing panel
     */
    public void reset()
    {
        Graphics g = this.getGraphics();
        g.clearRect(0, 0, W, H);
        lines.clear();
        points.clear();
        //reset the adjacency matrix
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                adjMatrix[i][j] = 0;
            }
        }
    }

    /**
     * takes a screenshot of the current game
     */
    private void takeScreenshot()
    {

        BufferedImage screenshotImage = new BufferedImage(
                this.getBounds().width, this.getBounds().height,
                BufferedImage.TYPE_4BYTE_ABGR_PRE);
        this.paint(screenshotImage.getGraphics());
        try
        {
            ImageIO.write(screenshotImage, "png", new File("screenShot.png"));
        } catch (IOException ex)
        {
            System.err.println("ImageIsuues");
        }
    }

    /**
     * saves the current game configuration to a json file
     */
    public void save()
    {
        //save adjaceny matrix to a json file
        //copy lines to game state
        gameState.setLines(lines);
        //copy adjaceny matrix to game state
        gameState.setAdjacencyMatrix(adjMatrix);
        //copy points to game state
        //print all the points
        for (MyPoint p : points)
        {
            System.out.println(p);
        }

        gameState.setPoints(points);

        ObjectMapper mapper = new ObjectMapper();
        try
        {
            mapper.writeValue(new File("game_state.json"), gameState);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * loads a game configuration from a json file
     */
    public void load()
    {
        Graphics g = this.getGraphics();

        GameState gameState = new GameState();
        ObjectMapper mapper = new ObjectMapper();

        try
        {
            gameState = mapper.readValue(new File("game_state.json"), GameState.class);
        } catch (IOException e)
        {
            e.printStackTrace();
        }


        //copy lines from game state to lines
        lines = gameState.getLines();

        //copy adjaceny matrix from game state to adjaceny matrix
        adjMatrix = gameState.getAdjacencyMatrix();

        //copy points from game state to points
        points = gameState.getPoints();


        //set the controls to the values from the json file
        //frame.configPanel.dotsSpinner.setValue(points.size());
        frame.configPanel.linesCombo.setSelectedItem(1.0);


        for (Lines line : lines)
        {


            ((Graphics2D) g).setStroke(new BasicStroke(3));
            //set the color
            if (Objects.equals(line.getColor(), "red"))
            {
                g.setColor(Color.RED);
            } else if (Objects.equals(line.getColor(), "blue"))
            {
                g.setColor(Color.BLUE);
            } else
            {
                g.setColor(Color.BLACK);
            }

            g.drawLine(line.getP1().x, line.getP1().y, line.getP2().x, line.getP2().y);
            //set the stroke

        }
        //draw the points
        for (MyPoint point : points)
        {
            g.drawOval(point.x, point.y, 10, 10);
        }


    }
}
