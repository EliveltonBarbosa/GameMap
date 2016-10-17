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
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Elivelton
 */
public class Inimigo {
    private int x, y;
    private int dx, dy;
    private Image imagem;
    private boolean isVisivel;
    private int altura;
    private int largura;
    public static int cont;
    private List<Lazer> municao;
    private ImageIcon ref;

    public Inimigo(int sx,int sy) {
        
        if(cont++ % 2 == 0){
            ref = new ImageIcon(AssetsUtil.INIMIGO_1);
        }
        if(cont++ % 3 == 0){
            ref = new ImageIcon(AssetsUtil.INIMIGO_2);
        }
        if(cont++ % 4 == 1){
            ref = new ImageIcon(AssetsUtil.INIMIGO_3);
        }
        if(cont++ % 5 == 1){
            ref = new ImageIcon(AssetsUtil.INIMIGO_4);
        }
        if(cont++ % 6 == 2){
            ref = new ImageIcon(AssetsUtil.INIMIGO_5);
        }
        this.imagem = ref.getImage();
        this.altura = imagem.getHeight(null);
        this.largura = imagem.getWidth(null);
        municao = new ArrayList<Lazer>();
        this.x = sx;
        this.y = sy;
    }

    public void mover() {
        if(this.y > MedidasUtil.ALTURA){
            this.y = 0;
        }else{
            this.y += MedidasUtil.VELOCIDADE;
        }
    }
    
    public void atira(){
        this.municao.add(new Lazer((this.x +largura/2),this.y + altura));
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x,y,largura,altura);
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

    public boolean isVisivel() {
        return isVisivel;
    }

    public void setVisivel(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }
    
}