/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.elivelton.view;

import br.com.map.elivelton.model.Fase;
import br.com.map.elivelton.model.GameOver;
import br.com.map.elivelton.model.Sessao;
import br.com.map.elivelton.util.MedidasUtil;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Elivelton
 */
public class Game extends JFrame{
    private Fase fase;
    private GameOver over;
    
    public Game(String nome) {
        fase = new Fase(nome,this);
        add(fase);
        setTitle("Galactic Warriors");
        setSize(MedidasUtil.LARGURA, MedidasUtil.ALTURA);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void checarEmJogo(Sessao sessao){
        if(!fase.getEmJogo()){
            this.dispose();
        }
    }
}
