package lk.ijse.OneToMany.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "OrderDetails")
public class OrderDeatils {
    @Id
    @GenericGenerator(name = "string_based",strategy = "lk.ijse.OneToMany.Generator.OrderDetailsIDGenerator")
    @GeneratedValue(generator = "string_based")
    @Column(name = "orderDetails_code",length = 10)
    private String code;
    @Column(name = "itemCode")
    private String itemCode;
    @Column(name = "unitPrice")
    private double unitPrice;
    @Column(name = "qty")
    private int qty;


    @ManyToMany(mappedBy = "orderDeatilsList")
    private List<Orders>ordersList=new ArrayList<>();

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }


    public OrderDeatils() {
    }

    public OrderDeatils(String code, String itemCode, double unitPrice, int qty) {
        this.code = code;
        this.itemCode = itemCode;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "OrderDeatils{" +
                "code='" + code + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", unitPrice=" + unitPrice +
                ", qty=" + qty +
                '}';
    }
}
