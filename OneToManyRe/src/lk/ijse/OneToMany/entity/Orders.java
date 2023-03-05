package lk.ijse.OneToMany.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Orders {

    @Id
    @GenericGenerator(name = "string_based",strategy = "lk.ijse.OneToMany.Generator.OrdersIDGenerator")
    @GeneratedValue(generator = "string_based")
    @Column(name = "orders_id",length = 10)
    private String orderId;
    @CreationTimestamp
    private Date date;
    @Column(name = "customer_id")
    private String customerId;


    @ManyToOne
    private Customer customer;


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    @ManyToMany
    private List<OrderDeatils> orderDeatilsList=new ArrayList<>();

    public List<OrderDeatils> getOrderDeatilsList() {
        return orderDeatilsList;
    }

    public void setOrderDeatilsList(List<OrderDeatils> orderDeatilsList) {
        this.orderDeatilsList = orderDeatilsList;
    }


    public Orders() {
    }

    public Orders(String orderId, String customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId='" + orderId + '\'' +
                ", date=" + date +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
