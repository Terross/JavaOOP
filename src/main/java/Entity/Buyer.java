package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Buyer")
public class Buyer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int buyerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "adress")
    private String adress;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "buyer",orphanRemoval = true, cascade = CascadeType.REMOVE)
    private List<Order> productOrders;

    public Buyer() {

    }

    public Buyer(String firstName, String secondName, String adress, String status){
        this.firstName = firstName;
        this.secondName = secondName;
        this.adress = adress;
        this.status = status;
    }

    public void setId(int id) {
        this.buyerId= id;
    }

    public int getId() {
        return buyerId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAdress() {
        return adress;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setProductOrder(List<Order> productOrder) {
        this.productOrders = productOrder;
    }

    public List<Order> getProductOrder() {
        return productOrders;
    }
}
