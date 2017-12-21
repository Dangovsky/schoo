package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

class ObjectDao<T> {

    protected void Add(T object) {
        Transaction trns = null;
        Session session = HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            session.save(object);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            //session.flush();
            session.close();
        }
    }

    protected void Update(T object) {
        Transaction trns = null;
        Session session = HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            //session.flush();
            session.close();
        }
    }

    public void Delete(T object) {
        Transaction trns = null;
        Session session = HibernateUtil.getSession();
        try {
            trns = session.beginTransaction();
            session.delete(object);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            //session.flush();
            session.close();
        }
    }

    public List<T> getAll() {
        return null;
    }

    public List<T> getById() {
        return null;
    }


    /*
    public List<T> getAll() {
        Session session = null;
        List<T> objects = new ArrayList<Author_db>();
        try {
            session = HibernateUtil.getSession();
            objects= session.createCriteria(T.class).list();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return objects;
    }

    public List<T> getById(int id){
        Session session = null;
        List<T> authors = new ArrayList<Author_db>();;
        try {
            session = HibernateUtil.getSession();
            authors= session.createCriteria(T.class)
                    .add(Restrictions.like("id", id))
                    .list();
        } catch (Exception e) {
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return authors;

    public void Delete(int id) {
        ApprenticeEntity object = (ApprenticeEntity)getById(id);
        Delete(object);
    }
    */
}
