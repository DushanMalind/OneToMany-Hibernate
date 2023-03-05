package lk.ijse.OneToMany.state;

import lk.ijse.OneToMany.entity.Customer;
import lk.ijse.OneToMany.entity.Item;
import lk.ijse.OneToMany.util.SessionFactoryConfiguaration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DetachStateOneToOne {

    public static void main(String[] args) {
        Session session= SessionFactoryConfiguaration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        Item item=new Item();
        item.setCode("I001");
        item.setDescription("Mouse");
        item.setQtyOnHand(10);
        item.setUnitPrice(2000);


        Customer customer=new Customer();
        customer.setId("C001");
        customer.setName("Nimal");
        customer.setAddress("Galle");
        customer.setContact("0124152454");
        customer.setItem(item);


        session.save(item);
        session.save(customer);


        transaction.commit();
        session.close();

    }


}
