/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

//import org.hibernate.Session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

//import org.hibernate.SessionFactory;

/**
 *
 * @author u04853004190
 */
public abstract class AbstractDao {
    public Session session;
    public AbstractDao(){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
    }
    
    public abstract void insert(Object object);
    public abstract void update(Object object);
    public abstract void delete(Object object);
    public abstract Object list(int codigo);
    public abstract Object listAll();
}
