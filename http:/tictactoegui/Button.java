/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegui;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Font;

/**
 *
 * @author s.zhuang
 */
public class Button extends JButton {
    private boolean claimed;
    private Player owner;
    
    public Button() {
        this.setPreferredSize(new Dimension(100, 100));
        this.setBackground(Color.BLACK);
        this.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
        this.setForeground(Color.WHITE);
        this.setFocusPainted(false);
        claimed = false;
        //owner = Player.X;
    }
    
    public void claim(Player curPlayer) {
        if (curPlayer == Player.X) this.setText("X");
        if (curPlayer == Player.O) this.setText("O");
        this.claimed = true;
        this.owner = curPlayer;
    }
    
    public boolean isClaimed() {
        return this.claimed;
    }
    
    public Player getOwner() {
        return this.owner;
    }
}
