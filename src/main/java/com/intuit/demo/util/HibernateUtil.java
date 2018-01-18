package com.intuit.demo.util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateUtil {
	
	@Autowired
    private SessionFactory sessionFactory;
		
    public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public <T> Serializable create(final T entity) {
        return sessionFactory.getCurrentSession().save(entity);        
    }
    
    public <T> T update(final T entity) {
        sessionFactory.getCurrentSession().update(entity);   
        return entity;
    }
    
	public <T> void delete(final T entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	public <T> void delete(Serializable id, Class<T> entityClass) {
		T entity = fetchById(id, entityClass);
		delete(entity);
	}
    
	/**
	 * This method will execute a Named HQL query and return the number of
	 * affected entities.
	 */
    @SuppressWarnings("unchecked")	
	public List executeSelectNamedQuery(String namedQuery, String namedParams[],
			Object params[]) {
		
    	Query q = sessionFactory.getCurrentSession().getNamedQuery(namedQuery);

		if (namedParams != null) {
			for (int i = 0; i < namedParams.length; i++) {
				q.setParameter(namedParams[i], params[i]);
			}
		}

		return q.list();
	}	
    
    @SuppressWarnings("unchecked")	
    public <T> List<T> fetchAll(Class<T> entityClass) {        
        return sessionFactory.getCurrentSession().createQuery(" FROM "+entityClass.getName()).list();        
    }
  
    @SuppressWarnings("rawtypes")
	public <T> List fetchAll(String query) {        
        return sessionFactory.getCurrentSession().createSQLQuery(query).list();        
    }
    
    @SuppressWarnings("unchecked")
	public <T> T fetchById(Serializable id, Class<T> entityClass) {
        return (T)sessionFactory.getCurrentSession().get(entityClass, id);
    }
    
    @SuppressWarnings("unchecked")
	public <T> T loadById(Serializable id, Class<T> entityClass) {
        return (T)sessionFactory.getCurrentSession().load(entityClass, id);
    }
    
    
	
}
