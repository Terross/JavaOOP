package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productOrder")
    private List<Product> products;

    @ManyToOne(fetch = FetchType.LAZY)
    private Buyer buyer;

    @Column(name = "price")
    private int price;

    public Order() {

    }

    public Order(Buyer buyer, List<Product> products) {
        this.buyer = buyer;
        this.products = products;
        for (Product product:
             products) {
            price+=product.getProductPrice();
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Buyer getBuyer() {
       return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
