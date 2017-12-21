package dao;

import entity.EducationalContractEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class EducationalContractDao extends ObjectDao {

    public EducationalContractDao(){}

    public void Add(int apprenticeId, int courseId, Date condusionDate, int price, String paymentInformation){
        super.Add(new EducationalContractEntity(apprenticeId, courseId, condusionDate, price, paymentInformation));
    }

    public void Update(int apprenticeId, int courseId, Date condusionDate, int price, String paymentInformation){
        super.Update(new EducationalContractEntity(apprenticeId, courseId, condusionDate, price, paymentInformation));
    }

    public void Delete(int apprenticeId, int courseId) {
        List<EducationalContractEntity> object = (List<EducationalContractEntity>)getById(apprenticeId, courseId);
        Delete(object.get(0));
    }

    public List<EducationalContractEntity> getAll() {
        Transaction trns = null;
        Session session = HibernateUtil.getSession();
        List<EducationalContractEntity> objects = new ArrayList<EducationalContractEntity>();
        try {
            trns = session.beginTransaction();
            objects = session.createCriteria(EducationalContractEntity.class).list();
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

    public List<EducationalContractEntity> getById(int apprenticeId, int courseId) {
        Transaction trns = null;
        Session session = HibernateUtil.getSession();
        List<EducationalContractEntity> objectsA = new ArrayList<EducationalContractEntity>();
        List<EducationalContractEntity> objectsB = new ArrayList<EducationalContractEntity>();
        try {
            trns = session.beginTransaction();
            objectsA = session.createCriteria(EducationalContractEntity.class)
                    .add(Restrictions.like("apprenticeId", apprenticeId))
                    .list();
            objectsB = session.createCriteria(EducationalContractEntity.class)
                    .add(Restrictions.like("courseId", courseId))
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
        objectsA.retainAll(objectsB);
        return objectsA;
    }
}