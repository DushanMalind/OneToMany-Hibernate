package lk.ijse.OneToMany.util;

import lk.ijse.OneToMany.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfiguaration {

    private static SessionFactoryConfiguaration factoryConfiguaration;
    private final SessionFactory sessionFactory;

    private SessionFactoryConfiguaration(){
        sessionFactory=new Configuration().configure().addAnnotatedClass(Customer.class).buildSessionFactory();

    }

    public static SessionFactoryConfiguaration getInstance(){
        return null==factoryConfiguaration ? factoryConfiguaration=new SessionFactoryConfiguaration() : factoryConfiguaration;

    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}