/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.elivelton.factory;

import br.com.map.elivelton.business.ISessaoBusiness;
import br.com.map.elivelton.business.SessaoBusiness;
import br.com.map.elivelton.dao.IDaoSessao;

/**
 *
 * @author Elivelton
 */
public class BusinessFactory {
    
    private static ISessaoBusiness sessaoBusiness;
    
    private BusinessFactory(){
        
    }
    
    public static ISessaoBusiness getSessaoBusiness(){
        if(sessaoBusiness == null){
            sessaoBusiness = new SessaoBusiness();
        }
        return sessaoBusiness;
    } 
    
}
