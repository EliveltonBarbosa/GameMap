/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.elivelton.model;

import br.com.map.elivelton.util.AssetsUtil;
import br.com.map.elivelton.util.MedidasUtil;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.List;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Elivelton
 */
public class Player {

    private int x, y;
    private int dx, dy;
    private Image imagem;
    private boolean isVisivel;
    private int pos;
    private static final int LARGURA = 52;
    private static final int ALTURA = 62;
    private List<Lazer> municao;

    public Player() {
        ImageIcon ref = new ImageIcon(AssetsUtil.PLAYER);
        this.imagem = ref.getImage();
        municao = new ArrayList<Lazer>();
        this.x = 480;
        this.y = 500;
    }

    public void mover() {
        x += dx;
        y += dy;
        if (x < 1) {
            x = 1;
        }
        if (x > 950) {
            x = 950;
        }
        if(y<1){
            y=1;
        }
        if(y >500){
            y = 500;
        }
        isVisivel = true;
    }
    
    public void atira(){
        this.municao.add(new Lazer((this.x +LARGURA/2),this.y - ALTURA));
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x,y,LARGURA,ALTURA);
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImagem() {
        return imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    public void keyPressed(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        
        if (codigo == KeyEvent.VK_SPACE){
            atira();
        }
        if (codigo == KeyEvent.VK_UP) {
            dy = -2;
        }
        if (codigo == KeyEvent.VK_DOWN) {
            dy = 2;
        }
        if (codigo == KeyEvent.VK_LEFT) {
            dx = -2;
            setPos(4);
            setPos(5);
            setPos(6);
        }
        if (codigo == KeyEvent.VK_RIGHT) {
            dx = 2;
            setPos(1);
            setPos(2);
            setPos(3);
        }
    }

    public void keyReleased(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();

        if (codigo == KeyEvent.VK_UP) {
            dy = 0;
        }
        if (codigo == KeyEvent.VK_DOWN) {
            dy = 0;
        }
        if (codigo == KeyEvent.VK_LEFT) {
            dx = 0;
            setPos(0);
        }
        if (codigo == KeyEvent.VK_RIGHT) {
            dx = 0;
            setPos(0);
        }
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int Pos) {
        pos = Pos;
    }

    public int getAlt() {
        return ALTURA;
    }

    public int getLar() {
        return LARGURA;
    }

    public boolean isVisivel() {
        return isVisivel;
    }

    public void setVisivel(boolean visivel) {
        isVisivel = visivel;
    }

    public List<Lazer> getMunicao() {
        return municao;
    }

    public void setMunicao(List<Lazer> municao) {
        this.municao = municao;
    }
    
}
