/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.elivelton.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Elivelton
 */

@Entity
public class Sessao {

    @Id
    @GeneratedValue
    private long id;
    private String usuario;
    private int pontos;

    
    public Sessao() {
        
    }
    
    public Sessao(String usuario, int pontos) {
        this.usuario = usuario;
        this.pontos = pontos;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser() {
        return usuario;
    }

    public void setUser(String user) {
        this.usuario = user;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    
}
