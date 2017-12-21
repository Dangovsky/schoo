package dao;

import entity.RoomEntity;
import entity.ScheduleEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RoomDao extends ObjectDao{

    public RoomDao(){}

    public void Add(String information, Collection<ScheduleEntity> schedules){
        super.Add(new RoomEntity(information, schedules));
    }

    public void Update(int id, String information, Collection<ScheduleEntity> schedules){
        super.Update(new RoomEntity(id, information, schedules));
    }

    public void Delete(int id) {
        List<RoomEntity> object = (List<RoomEntity>)getById(id);
        Delete(object.get(0));
    }

    public List<RoomEntity> getAll() {
        Transaction trns = null;
        Session session = HibernateUtil.getSession();
        List<RoomEntity> objects = new ArrayList<RoomEntity>();
        try {
            trns = session.beginTransaction();
            objects = session.createCriteria(RoomEntity.class).list();
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

    public List<RoomEntity> getById(int id) {
        Transaction trns = null;
        Session session = HibernateUtil.getSession();
        List<RoomEntity> objects = new ArrayList<RoomEntity>();
        try {
            trns = session.beginTransaction();
            objects = session.createCriteria(RoomEntity.class)
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

