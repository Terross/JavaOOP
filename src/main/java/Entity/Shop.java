package Entity;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.*;
import java.util.List;


public class Shop {

    private int revenue = 0;
    private String adminName;

    public Shop() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Order> orders = session.createQuery("FROM Order", Order.class).list();
        for (Order order:
                orders) {
            revenue += order.getPrice();
        }
    }
    public Shop (String adminName) {
        this.adminName = adminName;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Order> orders = session.createQuery("FROM Order", Order.class).list();
        for (Order order:
             orders) {
            revenue += order.getPrice();
        }
    }

    public int getRevenue() {
        return revenue;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public void showWorkers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Worker> workers = session.createQuery("FROM Worker", Worker.class).list();
        workers.forEach((w) -> {
            System.out.println(w.getId()+" " +w.getFirstName() + " " + w.getSecondName());
        });
    }

    public void addWorker(Worker worker) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(worker);
        transaction.commit();
    }

    public void removeWorker(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Worker worker = session.get(Worker.class, id);
        if(worker != null) {
            session.delete(worker);
        } else {
            System.out.println("Worker doesn't exist");
        }
        transaction.commit();
    }

    public void showBuyers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Buyer> buyers = session.createQuery("FROM Buyer", Buyer.class).list();
        buyers.forEach((b) -> {
            System.out.println(b.getId()+" " +b.getFirstName() + " " + b.getSecondName());
        });
    }

    public void addBuyer(Buyer buyer) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(buyer);
        transaction.commit();
    }

    public void removeBuyer(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Buyer buyer = session.get(Buyer.class, id);
        if(buyer != null) {
            session.delete(buyer);
        } else {
            System.out.println("Buyer doesn't exist");
        }
        transaction.commit();
    }

    public void showProducts() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Product> products = session.createQuery("FROM Product", Product.class).list();
        products.forEach((p) -> {
            System.out.println(p.getProductId() + " "+p.getProductTitle()+" " + p.getClass()+" " +p.getProductPrice());
        });
    }

    public void addProduct(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(product);
        transaction.commit();
    }

    public void removeProduct(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Product product = session.get(Product.class, id);
        if(product != null) {
            session.delete(product);
        } else {
            System.out.println("Product doesn't exist");
        }
        transaction.commit();
    }

    public void showOrders() {
        Session session= HibernateUtil.getSessionFactory().openSession();
        List<Order> orders = session.createQuery("FROM Order", Order.class).list();
        orders.forEach((o) -> {
            System.out.println(o.getBuyer().getFirstName() + " " + o.getPrice());
        });
    }

    public void addOrder(Order order) {
        revenue += order.getPrice();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(order.getBuyer());
        session.save(order);
        transaction.commit();
    }

    public void removeOrder(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Order order = session.get(Order.class, id);
        if(order != null){
            revenue -= order.getPrice();
            session.delete(order);
        } else {
            System.out.println("Order doesn't exist");
        }
    }
}
