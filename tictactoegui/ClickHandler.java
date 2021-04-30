/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoegui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author s.zhuang
 */
public class ClickHandler implements ActionListener {
    TicTacToeGui game;
    
    public ClickHandler(TicTacToeGui game) {
        this.game = game;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Button b = (Button) e.getSource();
        game.move(b);
    }
}
