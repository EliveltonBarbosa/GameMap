/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.elivelton.business;

import br.com.map.elivelton.dao.DaoSessao;
import br.com.map.elivelton.dao.IDaoSessao;
import br.com.map.elivelton.exception.BusinessException;
import br.com.map.elivelton.exception.DaoException;
import br.com.map.elivelton.model.Sessao;
import java.util.List;

/**
 *
 * @author Elivelton
 */
public class SessaoBusiness implements ISessaoBusiness{
    
    private IDaoSessao daoSessao;
    
    public SessaoBusiness(){
        daoSessao = new DaoSessao();
    }

    @Override
    public Sessao salvar(Sessao sessao) throws BusinessException {
        try{
            return daoSessao.save(sessao);
        }catch(Exception e){
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Sessao editar(Sessao sessao) throws BusinessException {
        try{
            return daoSessao.update(sessao);
        }catch(Exception e){
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Sessao remover(Sessao sessao) throws BusinessException {
        try{
            return daoSessao.remove(sessao);
        }catch(DaoException e){
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Sessao> getAll() throws BusinessException {
        try {
            return daoSessao.getAll();
        } catch (DaoException ex) {
            ex.printStackTrace();
            throw new BusinessException(ex.getMessage());
        }
    }
    
}
