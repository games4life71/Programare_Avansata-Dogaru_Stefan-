package swing_package;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;


public class main_menu
{
    private JButton advanceButton;
    private JPanel panel1;

    public static void main(String[] args)
    {

        //create a new frame to hold the panel
        JFrame main_frame = new JFrame("main_menu");
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_frame.pack();
        main_frame.setSize(1000, 700);
        main_frame.setVisible(true);


        //create a panel and add it to the frame

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.BLACK));
        main_frame.add(panel);
        panel.setVisible(true);

        //create a layout manager

        panel.setLayout(new BorderLayout(3,3));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);
        toolbar.add(new JButton("New Game "),BorderLayout.CENTER);
        toolbar.add(new JButton("Load Game "));
        toolbar.add(new JButton("Save Game "));
        toolbar.add(new JButton("Exit Game "));
        toolbar.setBackground(Color.darkGray);
        toolbar.setForeground(Color.white);
        //add the toolbar to the panel
        panel.add(toolbar, BorderLayout.NORTH);

        //create a panel to hold the chess board
        JPanel chess_board;

        JButton[][] chess_board_squares = new JButton[8][8];
        chess_board = new JPanel(new GridLayout(8, 8));
        chess_board.setBorder(new LineBorder(Color.BLACK));

        //add the chess board to the panel
        //add 8x8 buttons to the chess board
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                JButton b = new JButton();
                b.setBackground(Color.BLACK);
                chess_board_squares[i][j] = b;
                b.setVisible(true);
            }
        }

        panel.add(chess_board, BorderLayout.CENTER);












    }
}
