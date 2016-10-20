/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.elivelton.model;

import java.util.Calendar;

/**
 *
 * @author Elivelton
 */
public class Sessao {
    private long id;
    private String user;
    private int pontos;
    private Calendar data;

    public Sessao(long id, String user, int pontos, Calendar data) {
        this.id = id;
        this.user = user;
        this.pontos = pontos;
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }
    
}
