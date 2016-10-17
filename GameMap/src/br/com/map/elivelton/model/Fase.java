/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.elivelton.model;

import br.com.map.elivelton.util.AssetsUtil;
import br.com.map.elivelton.util.MedidasUtil;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Elivelton
 */
public class Fase extends JPanel implements ActionListener {

    private Image fundo;
    private Timer timer;
    private Player nave;
    private boolean emJogo;
    private List<Inimigo> inimigos;

    public Fase() {
        setFocusable(true);
        setDoubleBuffered(true);
        addKeyListener(new TecladoAdapter());
        ImageIcon ref = new ImageIcon(AssetsUtil.FASE1);
        fundo = ref.getImage();
        nave = new Player();
        timer = new Timer(5, this);
        timer.start();
    }

    public void paint(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo, 0, 0, null);
        graficos.drawImage(nave.getImagem(), nave.getX(), nave.getY(),
                nave.getX() + nave.getLar(),
                nave.getY() + nave.getAlt(),
                1 + (nave.getPos() * nave.getLar()), 1,
                1 + (nave.getPos() * nave.getLar()) + nave.getLar(),
                nave.getAlt() + 1, null);
        List<Lazer> lazers = nave.getMunicao();
        
        for(int i =0; i < lazers.size();i++){
        //for(LazerPlayer l : lazers){
            Lazer l = (Lazer)lazers.get(i);
            graficos.drawImage(l.getImagem(),l.getX(),l.getY(),this);
        }
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        List<Lazer> lazers = nave.getMunicao();
        
        for(int i =0; i < lazers.size();i++){
        //for(LazerPlayer l : lazers){
            Lazer l = (Lazer)lazers.get(i);
           if(l.isVisivel()){
               l.mover();
           }else{
               lazers.remove(l);
           }
        }
        
        nave.mover();
        repaint();
    }
    
    public void checarColisoes(){
        Rectangle formaNave = nave.getBounds();
        Rectangle formaLazer;
        Rectangle formaInimigo;
        
        for(int i = 0 ; i < inimigos.size(); i++){
            Inimigo tempIni = inimigos.get(i);
            formaInimigo = tempIni.getBounds();
            
            if(formaNave.intersects(formaInimigo)){
                nave.setVisivel(false);
                tempIni.setVisivel(false);
                emJogo = false;
            }
        }
        List<Lazer> municao = nave.getMunicao();
        for(int i = 0 ; i < municao.size(); i++){
            Lazer tempLazer = municao.get(i);
            formaLazer = tempLazer.getBounds();
            
            for(int j =0 ; j < inimigos.size() ; j++){
                Inimigo tempIni = inimigos.get(j);
                formaInimigo = tempIni.getBounds();
                
                if(formaLazer.intersects(formaInimigo)){
                    tempIni.setVisivel(false);
                    tempLazer.setVisivel(false);
                }
            }
        }
    }

    private class TecladoAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent tecla) {
            nave.keyPressed(tecla);
        }

        @Override
        public void keyReleased(KeyEvent tecla) {
            nave.keyReleased(tecla);
        }
    }

}
