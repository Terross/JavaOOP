import Entity.*;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{

        Worker worker1 = new Worker("Dmitry", "Zaykov", 20000, 1);
        Worker worker2 = new Worker("Dmitry2", "Zaykov2", 20000, 1);
        Worker worker3 = new Worker("Dmitry3", "Zaykov3", 15000, 1);

        Buyer buyer = new Buyer("Ivan", "Ivanov", "Lenina, 23","silver");

        Product product1 = new Phone("IPhone 12", 120000, "ios", 128);
        Product product2= new Phone("OnePlus 8", 60000, "android", 512);
        Product product3 = new Phone("Sumsung 20", 80000, "android", 256);
        Product product4 = new Phone("IPhone SE", 40000, "ios", 256);
        Product product5 = new Kettle("Kitfort", 3000, 50, "yes");
        ArrayList<Product> list = new ArrayList<>();
        list.add(product1);
        list.add(product5);
        Order order = new Order(buyer, list);
        list.add(product2);
        list.add(product3);
        list.add(product4);
        Shop shop = new Shop();
        System.out.println(shop.getRevenue());
        shop.addOrder(order);
        for (Product product:
             list) {
            shop.addProduct(product);
        }
        shop.addWorker(worker1);
        shop.showProducts();
        shop.showOrders();
        shop.showBuyers();
        shop.showWorkers();;
    }
}
