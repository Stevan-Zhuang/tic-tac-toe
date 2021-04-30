/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;

/**
 *
 * @author s.zhuang
 */


public class TicTacToeGui extends JFrame {
    Button[][] grid;
    static int EMPTY = -1;
    static int X = 0;
    static int O = 1;
    static int ROWS = 3;
    static int COLS = 3;
    Player curPlayer;
    boolean inProgress;
    JLabel message;
    
    public TicTacToeGui() {
        super("TicTacToe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        JPanel messagePanel = new JPanel();
        messagePanel.setBackground(Color.BLACK);
        
        message = new JLabel();
        message.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        message.setForeground(Color.WHITE);
        message.setText("Player X's turn");
        messagePanel.add(message);
        
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(COLS, ROWS));

        grid = new Button[ROWS][COLS];
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                grid[row][col] = new Button();
                grid[row][col].addActionListener(new ClickHandler(this));
                gridPanel.add(grid[row][col]);
            }
        }
        
        this.add(messagePanel, BorderLayout.NORTH);
        this.add(gridPanel, BorderLayout.SOUTH);
        this.pack();
        
        curPlayer = Player.X;
        inProgress = true;
    }
    
    public void move(Button b) {
        if (!b.isClaimed() && this.inProgress) {
            b.claim(curPlayer);
            curPlayer = (curPlayer == Player.X) ? Player.O : Player.X;
            message.setText("Player " + (curPlayer == Player.X ? "X" : "O") + "'s turn");
            boolean allFilled = true;
            for (int row = 0; row < ROWS; row++) {
                for (int col = 0; col < COLS; col++) {
                    if (    grid[row][col].getOwner() != Player.X
                            && grid[row][col].getOwner() != Player.O)
                        allFilled = false;
                }
            }
            if (allFilled) {
                message.setText("Draw!");
                this.inProgress = false;
            }
            Player winner = winner();
            if (winner != null) {
                message.setText("Player " + winner + " has won!");
                this.inProgress = false;
            }            
        }
    }
    
    private Player winner() {
        // Horizontal
        for (int row = 0; row < 3; row++) {
            if (grid[row][0].getOwner() == grid[row][1].getOwner()
                    && grid[row][1].getOwner() == grid[row][2].getOwner())
                return grid[row][0].getOwner();
        }
        // Vertical
        for (int col = 0; col < 3; col++) {   
            if (grid[0][col].getOwner() == grid[1][col].getOwner()
                    && grid[1][col].getOwner() == grid[2][col].getOwner())
                return grid[0][col].getOwner();
        }
        // Diagonal
        if (grid[0][0].getOwner() == grid[1][1].getOwner()
                && grid[1][1].getOwner() == grid[2][2].getOwner())
            return grid[0][0].getOwner();
        if (grid[0][2].getOwner() == grid[1][1].getOwner()
                && grid[1][1].getOwner() == grid[2][0].getOwner())
            return grid[0][2].getOwner();
        // No winner
        return null;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TicTacToeGui game = new TicTacToeGui();
    }
    
}
