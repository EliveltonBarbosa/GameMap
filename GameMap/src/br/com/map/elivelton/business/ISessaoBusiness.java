/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.elivelton.business;

import br.com.map.elivelton.exception.BusinessException;
import br.com.map.elivelton.model.Sessao;
import java.util.List;

/**
 *
 * @author Elivelton
 */
public interface ISessaoBusiness {
    
    public Sessao salvar(Sessao sessao) throws BusinessException;
    
    public Sessao editar(Sessao sessao) throws BusinessException;
    
    public Sessao remover(Sessao sessao) throws BusinessException;
    
    public List<Sessao> getAll()  throws BusinessException;
    
    public List<Sessao> getRanking() throws BusinessException;
    
}
