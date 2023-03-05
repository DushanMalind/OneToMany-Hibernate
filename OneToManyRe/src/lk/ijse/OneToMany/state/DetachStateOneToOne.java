package lk.ijse.OneToMany.state;

import lk.ijse.OneToMany.entity.Customer;
import lk.ijse.OneToMany.entity.Item;
import lk.ijse.OneToMany.entity.Orders;
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
        customer.setName("Kamal");
        customer.setAddress("Galle");
        customer.setContact("0124152454");
        customer.setItem(item);

        Orders orders=new Orders();
        orders.setOrderId("O001");
        orders.setCustomerId("C001");
        orders.setCustomer(customer);

        customer.getOrdersList().add(orders);

        session.save(item);
        session.save(customer);
        session.save(orders);


        transaction.commit();
        session.close();

    }


}
