/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.elivelton.dao;

import br.com.map.elivelton.exception.DaoException;
import br.com.map.elivelton.model.Sessao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Elivelton
 */
public class DaoSessao extends DaoGeneric<Sessao> implements IDaoSessao{

    @Override
    public List<Sessao> getPorData(String data) throws DaoException {
        List<Sessao> sessoes = null;
        try {
            Criteria criteria = getCriteria(); 
            criteria.add(Restrictions.ilike("data", data, MatchMode.ANYWHERE)); 
            sessoes = (List<Sessao>) criteria.list();
            return sessoes;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DaoException("Erro durante a busca dos arquivos.");
        }
    }
    
}
