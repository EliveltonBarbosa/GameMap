/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.elivelton.facade;

import br.com.map.elivelton.exception.BusinessException;
import br.com.map.elivelton.factory.BusinessFactory;
import br.com.map.elivelton.model.Sessao;
import java.util.List;

/**
 *
 * @author Elivelton
 */
public class Facade implements IFacade{

    @Override
    public Sessao salvarSessao(Sessao sessao) throws BusinessException {
        return BusinessFactory.getSessaoBusiness().salvar(sessao);
    }

    @Override
    public Sessao editarSessao(Sessao sessao) throws BusinessException {
        return BusinessFactory.getSessaoBusiness().editar(sessao);
    }

    @Override
    public Sessao removerSessao(Sessao sessao) throws BusinessException {
        return BusinessFactory.getSessaoBusiness().remover(sessao);
    }

    @Override
    public List<Sessao> listarSessoes() throws BusinessException {
            return BusinessFactory.getSessaoBusiness().getAll();
    }
    
}
