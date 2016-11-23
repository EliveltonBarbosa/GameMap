/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.elivelton.dao;

import br.com.map.elivelton.exception.DaoException;
import br.com.map.elivelton.persistenceSingleton.PersistenceUtil;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author elive
 */
public class DaoGeneric<T> implements IDaoGeneric<T> {

    private Class classe;

    public DaoGeneric() {
        this.classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        
    }

    @Override
    public T save(T t) throws DaoException {
        EntityManager manager = PersistenceUtil.getEntityManager();
        try {
            
            manager.getTransaction().begin();
            manager.persist(t);
            manager.flush();
            manager.refresh(t);
            PersistenceUtil.closeEntityManager();
            return t;
        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
            throw new DaoException("Erro ao salvar arquivo.");
        }
    }

    @Override
    public T update(T t) throws DaoException {
        EntityManager manager = PersistenceUtil.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.merge(t);
            manager.flush();
            manager.refresh(t);
            PersistenceUtil.closeEntityManager();

            return t;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DaoException("Erro ao tentar atualisar arquivo.");
        }
    }

    @Override
    public T remove(T t) throws DaoException {
        EntityManager manager = PersistenceUtil.getEntityManager();
        try {
            manager.getTransaction().begin();
            t = manager.merge(t);
            manager.remove(t);
            manager.flush();
            PersistenceUtil.closeEntityManager();
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DaoException("Erro ocorrido durante a remoção do arquivo.");
        }
    }

    @Override
    public T getById(Long id) throws DaoException {
        T resultado = null;
        try {
            Criteria criteria = getCriteria();
            criteria.add(Restrictions.eq("id", id));
            resultado = (T) criteria.uniqueResult();
            return resultado;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DaoException("Erro ao tentar encontrar arquivo.");
        }
    }

    @Override
    public List<T> getAll() throws DaoException {
        List<T> resultado = null;
        try {
            Criteria criteria = getCriteria();
            criteria.addOrder(Order.asc("id"));
            resultado = (List<T>) criteria.list();
            return resultado;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DaoException("Erro ao tentar listar arquivos.");
        }
    }

    @Override
    public Criteria getCriteria() {
        EntityManager manager = PersistenceUtil.getEntityManager();
        Session session = ((Session) manager.getDelegate());
        return session.createCriteria(classe);
    }

}
