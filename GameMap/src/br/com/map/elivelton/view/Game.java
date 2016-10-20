/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.elivelton.view;

import br.com.map.elivelton.model.Fase;
import br.com.map.elivelton.util.MedidasUtil;
import java.awt.Graphics2D;
import java.awt.Image;
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
 
    public Game(String nome){
        add(new Fase(nome));
        setTitle("Galactic Warriors");
        setSize(MedidasUtil.LARGURA, MedidasUtil.ALTURA);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
