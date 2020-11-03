package Entity;

import javax.persistence.*;
import java.util.Properties;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_title")
    private String productTitle;

    @Column(name = "product_price")
    private int productPrice;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Order productOrder;

    public Product() {

    }

    public Product(String productTitle, int productPrice) {
        this.productTitle = productTitle;
        this.productPrice = productPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public Order getOrder() {
        return productOrder;
    }

    public void setOrder(Order productOrder) {
        this.productOrder = productOrder;
    }

    @Override
    public String toString() {
        return "Product: id=" + productId + ", title=" + productTitle + ", price="+ productPrice;
    }
}
