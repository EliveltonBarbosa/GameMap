
package br.com.map.elivelton.model;

import br.com.map.elivelton.business.ISessaoBusiness;
import br.com.map.elivelton.business.SessaoBusiness;
import br.com.map.elivelton.exception.BusinessException;
import br.com.map.elivelton.util.AssetsUtil;
import br.com.map.elivelton.util.MedidasUtil;
import br.com.map.elivelton.view.Game;
import br.com.map.elivelton.view.TabelaRanking;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Elivelton
 */
public class Fase extends JPanel implements ActionListener {

    private Game frame;
    private Image fundo;
    private Timer timer;
    private Player nave;
    private boolean emJogo;
    private List<Inimigo> inimigos;
    private String player;
    private int pontuacao;
    private ISessaoBusiness sessaoBus;

    public Fase(String nome,Game frame) {
        this.frame = frame;
        setFocusable(true);
        setDoubleBuffered(true);
        addKeyListener(new TecladoAdapter());
        ImageIcon ref = new ImageIcon(AssetsUtil.FASE1);
        fundo = ref.getImage();
        nave = new Player();
        player = nome;
        inimigos = new ArrayList<Inimigo>();
        emJogo = true;
        sessaoBus = new SessaoBusiness();
        timer = new Timer(5, this);
        pontuacao = 0;
        try {
            sessaoBus.getAll();
        } catch (BusinessException ex) {
            System.out.println(ex);
        }
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

        for (int i = 0; i < lazers.size(); i++) {
            //for(LazerPlayer l : lazers){
            Lazer l = (Lazer) lazers.get(i);
            graficos.drawImage(l.getImagem(), l.getX(), l.getY(), this);
        }

        for (int i = 0; i < inimigos.size(); i++) {
            Inimigo m = inimigos.get(i);
            graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
        }
        graficos.setColor(Color.WHITE);
        graficos.drawString("Player: " + player, 20, 15);
        graficos.drawString("Pontos: " + pontuacao, 150, 15);
        g.dispose();

    }

    ///*
    private class GerarInimigos extends Thread {

        public void run() {
            try {
                for (int i = 0; i < 6; i++) {
                    if (inimigos.size() <= 8) {
                        inimigos.add(new Inimigo(1 + (int) (950 * Math.random()), -80));
                        //inimigos.add(new Inimigo(120+(150* i),0));
                    }
                    this.sleep(5000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    //*/

    /*
    public void GerarInimigos() {

        while (emJogo) { 
            try {
                inimigos.add(new Inimigo(1 + (int) (950 * Math.random()), 0));
                timer.wait(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
     */
    @Override
    public void actionPerformed(ActionEvent e) {
            List<Lazer> lazers = nave.getMunicao();
            new GerarInimigos().start();

            for (int i = 0; i < lazers.size(); i++) {
                //for(LazerPlayer l : lazers){
                Lazer l = (Lazer) lazers.get(i);
                if (l.isVisivel()) {
                    l.mover();
                } else {
                    lazers.remove(l);
                }
            }

            for (int i = 0; i < inimigos.size(); i++) {
                //for(LazerPlayer l : lazers){
                Inimigo g = (Inimigo) inimigos.get(i);
                if (g.isVisivel()) {
                    g.mover();
                } else {
                    inimigos.remove(g);
                }
            }

            nave.mover();
            checarColisoes();
            repaint();
    }

    public void checarColisoes() {
        Rectangle formaNave = nave.getBounds();
        Rectangle formaLazer;
        Rectangle formaInimigo;

        for (int i = 0; i < inimigos.size(); i++) {
            Inimigo tempIni = inimigos.get(i);
            formaInimigo = tempIni.getBounds();

            if (formaNave.intersects(formaInimigo)) {
                nave.setVisivel(false);
                tempIni.setVisivel(false);
                Sessao sessao = new Sessao(this.player, this.pontuacao);
                try {
                    sessaoBus.salvar(sessao);
                    this.emJogo = false;
                    new GameOverContainer(sessao).setVisible(true);
                    frame.dispose();
                    this.setEnabled(false);
                    GerarInimigos.currentThread().stop();
                } catch (BusinessException ex) {
                    ex.printStackTrace();
                    System.out.println(ex.getMessage());
                }
            }
        }

        List<Lazer> municao = nave.getMunicao();
        for (int i = 0; i < municao.size(); i++) {
            Lazer tempLazer = municao.get(i);
            formaLazer = tempLazer.getBounds();

            for (int j = 0; j < inimigos.size(); j++) {
                Inimigo tempIni = inimigos.get(j);
                formaInimigo = tempIni.getBounds();

                if (formaLazer.intersects(formaInimigo)) {
                    tempIni.setVisivel(false);
                    tempLazer.setVisivel(false);
                    this.pontuacao += 2;
                }
            }
        }
    }

    public boolean getEmJogo() {
        return this.emJogo;
    }

    private class TecladoAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent tecla) {
            int codigo = tecla.getKeyCode();
            nave.keyPressed(tecla);
            if (codigo == KeyEvent.VK_ENTER && !emJogo) {

            }
        }

        @Override
        public void keyReleased(KeyEvent tecla) {
            nave.keyReleased(tecla);
        }
    }

}
