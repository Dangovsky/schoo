package dao;

import entity.ScheduleEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDao extends ObjectDao{

    public ScheduleDao(){}

    public void Add(int courseId, int roomId, Time startTime){
        super.Add(new ScheduleEntity(courseId, roomId, startTime));
    }

    public void Delete(int courseId, int roomId, Time startTime){
        super.Delete(new ScheduleEntity(courseId, roomId, startTime));
    }

    public List<ScheduleEntity> getAll() {
        Transaction trns = null;
        Session session = HibernateUtil.getSession();
        List<ScheduleEntity> objects = new ArrayList<ScheduleEntity>();
        try {
            trns = session.beginTransaction();
            objects = session.createCriteria(ScheduleEntity.class).list();
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

    public List<ScheduleEntity> getById(int courseId, int roomId, Time startTime) {
        Transaction trns = null;
        Session session = HibernateUtil.getSession();
        List<ScheduleEntity> objectsCourse = new ArrayList<ScheduleEntity>();
        List<ScheduleEntity> objectsRoom = new ArrayList<ScheduleEntity>();
        List<ScheduleEntity> objectsTime = new ArrayList<ScheduleEntity>();
        try {
            trns = session.beginTransaction();
            objectsCourse = session.createCriteria(ScheduleEntity.class)
                    .add(Restrictions.like("courseId", courseId))
                    .list();
            objectsRoom = session.createCriteria(ScheduleEntity.class)
                    .add(Restrictions.like("roomId", roomId))
                    .list();
            objectsTime = session.createCriteria(ScheduleEntity.class)
                    .add(Restrictions.like("startTime", startTime))
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
        objectsCourse.retainAll(objectsRoom);
        objectsCourse.retainAll(objectsTime);
        return objectsCourse;
    }
}
