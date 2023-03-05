package lk.ijse.OneToMany.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Item")
public class Item {
    @Id
    @GenericGenerator(name = "string_based",strategy = "lk.ijse.OneToMany.Generator.ItemIDGenerator")
    @GeneratedValue(generator = "string_based")
    @Column(name = "item_id",length = 10)
    private String code;
    @Column(name = "description")
    private String description;
    @Column(name = "unitPrice")
    private double unitPrice;
    @Column(name = "QtyOnHand")
    private int qtyOnHand;

   /* private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }*/

    public Item() {
    }

    public Item(String code, String description, double unitPrice, int qtyOnHand) {
        this.code = code;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qtyOnHand = qtyOnHand;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }
}
