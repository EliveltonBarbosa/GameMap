/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.elivelton.model;

import br.com.map.elivelton.util.MedidasUtil;
import javax.swing.JFrame;

/**
 *
 * @author Elivelton
 */
public class GameOverContainer extends JFrame{
    
    private GameOver gameOver; 
    public GameOverContainer(Sessao sessao){
        gameOver = new GameOver(sessao,this);
        add(gameOver);
        setTitle("Galactic Warriors");
        setSize(MedidasUtil.LARGURA, MedidasUtil.ALTURA);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
