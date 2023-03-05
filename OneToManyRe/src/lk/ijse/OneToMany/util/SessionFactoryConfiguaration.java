package lk.ijse.OneToMany.util;

import lk.ijse.OneToMany.entity.Customer;
import lk.ijse.OneToMany.entity.Item;
import lk.ijse.OneToMany.entity.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfiguaration {

    private static SessionFactoryConfiguaration factoryConfiguaration;
    private final SessionFactory sessionFactory;

    private SessionFactoryConfiguaration(){
        sessionFactory=new Configuration().configure().addAnnotatedClass(Customer.class).addAnnotatedClass(Item.class).addAnnotatedClass(Orders.class).buildSessionFactory();

    }

    public static SessionFactoryConfiguaration getInstance(){
        return null==factoryConfiguaration ? factoryConfiguaration=new SessionFactoryConfiguaration() : factoryConfiguaration;

    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}
