package dao;

import entity.CourseEntity;
import entity.EducationalContractEntity;
import entity.ScheduleEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CourseDao extends ObjectDao{

    public CourseDao(){}

    public void Add(String name, Time durability, Integer teacherId, Collection<EducationalContractEntity> educationalContracts, Collection<ScheduleEntity> schedule){
        super.Add(new CourseEntity(name, durability, teacherId,  educationalContracts, schedule));
    }

    public void Update(int id, String name, Time durability, Integer teacherId, Collection<EducationalContractEntity> educationalContracts, Collection<ScheduleEntity> schedule){
        super.Update(new CourseEntity(id, name, durability, teacherId,  educationalContracts, schedule));
    }

    public void Delete(int id) {
        List<CourseEntity> object = (List<CourseEntity>)getById(id);
        Delete(object.get(0));
    }

    public List<CourseEntity> getAll() {
        Transaction trns = null;
        Session session = HibernateUtil.getSession();
        List<CourseEntity> objects = new ArrayList<CourseEntity>();
        try {
            trns = session.beginTransaction();
            objects = session.createCriteria(CourseEntity.class).list();
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

    public List<CourseEntity> getById(int id) {
        Transaction trns = null;
        Session session = HibernateUtil.getSession();
        List<CourseEntity> objects = new ArrayList<CourseEntity>();
        try {
            trns = session.beginTransaction();
            objects = session.createCriteria(CourseEntity.class)
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
