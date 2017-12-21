package dao;

import entity.ApprenticeEntity;
import entity.EducationalContractEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ApprenticeDao extends ObjectDao{

    public ApprenticeDao(){}

    public void Add(String name, Integer contactNumber, Collection<EducationalContractEntity> educationalContracts){
        super.Add(new ApprenticeEntity(name, contactNumber, educationalContracts));
    }

    public void Update(int id, String name, Integer contactNumber, Collection<EducationalContractEntity> educationalContracts){
        super.Update(new ApprenticeEntity(id, name, contactNumber, educationalContracts));
    }

    public void Delete(int id) {
        List<ApprenticeEntity> object = (List<ApprenticeEntity>)getById(id);
        Delete(object.get(0));
    }

    public List<ApprenticeEntity> getAll() {
        Transaction trns = null;
        Session session = HibernateUtil.getSession();
        List<ApprenticeEntity> objects = new ArrayList<ApprenticeEntity>();
        try {
            trns = session.beginTransaction();
            objects = session.createCriteria(ApprenticeEntity.class).list();
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

    public List<ApprenticeEntity> getById(int id) {
        Transaction trns = null;
        Session session = HibernateUtil.getSession();
        List<ApprenticeEntity> objects = new ArrayList<ApprenticeEntity>();
        try {
            trns = session.beginTransaction();
            objects = session.createCriteria(ApprenticeEntity.class)
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
