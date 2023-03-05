package lk.ijse.OneToMany.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GenericGenerator(name = "string_based",strategy = "lk.ijse.OneToMany.Generator.CustomerIDGenerator")
    @GeneratedValue(generator = "string_based")
    @Column(name = "Customer_Id",length = 10)
    private String id;
    @Column(name = "Customer_name")
    private String name;
    @Column(name = "Customer_address")
    private String address;
    @Column(name = "Customer_contact")
    private String contact;

//    cascade = CascadeType.REFRESH,fetch = FetchType.EAGER
    @OneToOne()
    private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Customer() {
    }

    public Customer(String id, String name, String address, String contact) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
