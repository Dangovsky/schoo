package util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static final SessionFactory ourSessionFactory;

    static {
        try {
            //ourSessionFactory = new Configuration().configure().buildSessionFactory(new StandardServiceRegistryBuilder().build() );


            // Create the SessionFactory from hibernate.cfg.xml
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(entity.ApprenticeEntity.class);
            configuration.addAnnotatedClass(entity.CourseEntity.class);
            configuration.addAnnotatedClass(entity.EducationalContractEntity.class);
            configuration.addAnnotatedClass(entity.RoomEntity.class);
            configuration.addAnnotatedClass(entity.ScheduleEntity.class);
            configuration.addAnnotatedClass(entity.TeacherEntity.class);

            //apply configuration property settings to StandardServiceRegistryBuilder
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }
}
