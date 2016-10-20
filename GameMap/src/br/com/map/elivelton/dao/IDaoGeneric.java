/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.elivelton.dao;

import br.com.map.elivelton.exception.DaoException;
import java.util.List;
import org.hibernate.Criteria;

/**
 *
 * @author Elivelton
 */
public interface IDaoGeneric<T> {
    
    T save(T t) throws DaoException;

    T update(T t) throws DaoException;

    T remove(T t) throws DaoException;

    T getById(Long id) throws DaoException;
    
    List<T> getAll() throws DaoException;

    Criteria getCriteria();
    
}
