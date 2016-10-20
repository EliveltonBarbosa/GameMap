/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.elivelton.facade;

import br.com.map.elivelton.exception.BusinessException;
import br.com.map.elivelton.model.Sessao;
import java.util.List;

/**
 *
 * @author Elivelton
 */
public interface IFacade {
    
    Sessao salvarSessao(Sessao sessao) throws BusinessException;
    
    Sessao editarSessao(Sessao sessao) throws BusinessException;
    
    Sessao removerSessao(Sessao sessao) throws BusinessException;
    
    List<Sessao> listarSessoes() throws BusinessException;
}
