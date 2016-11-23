/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.elivelton.dao;

import br.com.map.elivelton.exception.DaoException;
import br.com.map.elivelton.model.Sessao;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Elivelton
 */
public interface IDaoSessao extends IDaoGeneric<Sessao>{
    
    public List<Sessao> getPorRanking() throws DaoException;
    
}
