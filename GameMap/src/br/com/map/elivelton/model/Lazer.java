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
import javax.swing.ImageIcon;

/**
 *
 * @author Elivelton
 */
public class Lazer {
    private int x,y;
    private int dx,dy;
    private boolean visivel;
    private Image imagem;
    
    public Lazer(int x,int y){
        this.x = x;
        this.y = y;
        
        ImageIcon ref = new ImageIcon(AssetsUtil.LAZER);
        this.imagem = ref.getImage();
        visivel = true;
    }
    
    public void mover(){
        this.y -= MedidasUtil.VELOCIDADE;
        if(this.y > MedidasUtil.ALTURA){
            visivel = false;
        }
    }

    public boolean isVisivel() {
        return visivel;
    }

    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public Image getImagem() {
        return imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x,y,imagem.getWidth(null),imagem.getHeight(null));
    }
}
