/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.elivelton.model;

import br.com.map.elivelton.util.AssetsUtil;
import br.com.map.elivelton.view.Game;
import br.com.map.elivelton.view.TabelaRanking;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Elivelton
 */
public class GameOver extends JPanel {

    private Image fundo,play,lista;
    private Sessao sessao;
    private GameOverContainer game;
    private int x,y;

    public GameOver(Sessao sessao, GameOverContainer frame) {
        this.sessao = sessao;
        this.game = frame;
        setFocusable(true);
        setDoubleBuffered(true);
        addKeyListener(new TecladoAdapter());
        addMouseListener(new MouseAdapter());
        addMouseMotionListener(new MouseAdapter());
        ImageIcon ref = new ImageIcon(AssetsUtil.GAME_OVER);
        fundo = ref.getImage();
    }


    public void paint(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo, 0, 0, null);
        ImageIcon playref = new ImageIcon(AssetsUtil.ICO_PLAY);
        play = playref.getImage();
        graficos.drawImage(play, 800, 520, null);
        ImageIcon listaref = new ImageIcon(AssetsUtil.ICO_LISTA);
        lista = listaref.getImage();
        graficos.drawImage(lista, 880, 520, null);
        graficos.setColor(Color.WHITE);
        graficos.drawString(sessao.getUser() + ": " + sessao.getPontos(), 600, 540);
    }

    private class TecladoAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent tecla) {
            int codigo = tecla.getKeyCode();
            if (codigo == KeyEvent.VK_ENTER) {
                new Game(sessao.getUser()).setVisible(true);
                game.dispose();
            }
        }

        @Override
        public void keyReleased(KeyEvent tecla) {

        }
    }
    
    private class MouseAdapter implements MouseListener, MouseMotionListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            
            if(x >= 800 && x<=828 && y>=520 && y <= 548){
                new Game(sessao.getUser()).setVisible(true);
                game.dispose();
                game.setEnabled(false);
            }
            if( x>=880 && x<=908 && y>=520 && y <= 548){
                new TabelaRanking(sessao.getUser()).setVisible(true);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            x = e.getX();
            y = e.getY();
        }
    }

}
