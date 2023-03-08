package lk.ijse.OneToMany.state;

import lk.ijse.OneToMany.entity.Customer;
import lk.ijse.OneToMany.entity.Item;
import lk.ijse.OneToMany.entity.Orders;
import lk.ijse.OneToMany.util.SessionFactoryConfiguaration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ManyTOmany {
    public static void main(String[] args) {

        Session session= SessionFactoryConfiguaration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        Customer customer=new Customer();
        customer.setId("C001");
        customer.setName("Kamal");
        customer.setAddress("Galle");
        customer.setContact("0124152454");

        Item item=new Item();
        item.setCode("I001");
        item.setDescription("Mouse");
        item.setQtyOnHand(10);
        item.setUnitPrice(2000);

        Orders orders=new Orders();
        orders.setOrderId("O001");
        orders.setCustomer(customer);

        item.getOrdersList().add(orders);
        orders.getItemList().add(item);

        session.save(customer);
        session.save(item);
        session.save(orders);

        transaction.commit();
        session.close();


    }
}
