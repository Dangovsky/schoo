package dao;

import entity.CourseEntity;
import entity.TeacherEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TeacherDao extends ObjectDao{

    public TeacherDao(){}

    public void Add(String name, Integer contactNumber, Collection<CourseEntity> courses){
        super.Add(new TeacherEntity(name, contactNumber, courses));
    }

    public void Update(int id, String name, Integer contactNumber, Collection<CourseEntity> courses){
        super.Update(new TeacherEntity(id, name, contactNumber, courses));
    }

    public void Delete(int id) {
        List<TeacherEntity> object = (List<TeacherEntity>)getById(id);
        Delete(object.get(0));
    }

    public List<TeacherEntity> getAll() {
        Transaction trns = null;
        Session session = HibernateUtil.getSession();
        List<TeacherEntity> objects = new ArrayList<TeacherEntity>();
        try {
            trns = session.beginTransaction();
            objects = session.createCriteria(TeacherEntity.class).list();
            session.getTransaction().commit();
        }  catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            //session.flush();
            session.close();
        }
        return objects;
    }

    public List<TeacherEntity> getById(int id) {
        Transaction trns = null;
        Session session = HibernateUtil.getSession();
        List<TeacherEntity> objects = new ArrayList<TeacherEntity>();
        try {
            trns = session.beginTransaction();
            objects = session.createCriteria(TeacherEntity.class)
                    .add(Restrictions.like("id", id))
                    .list();
            session.getTransaction().commit();
        }  catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            //session.flush();
            session.close();
        }
        return objects;
    }
}
