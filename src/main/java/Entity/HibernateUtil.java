package Entity;

import com.mysql.cj.Session;
import com.sun.org.apache.xalan.internal.xsltc.dom.KeyIndex;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import java.util.Properties;


public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties setting = new Properties();
                setting.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                setting.put(Environment.URL, "jdbc:mysql://localhost:3306/shop?serverTimezone=UTC");
                setting.put(Environment.USER, "dmitry");
                setting.put(Environment.PASS, "root");
                setting.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
                setting.put(Environment.SHOW_SQL, "true");
                setting.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                setting.put(Environment.HBM2DDL_AUTO, "update");

                configuration.setProperties(setting);
                configuration.addAnnotatedClass(Phone.class);
                configuration.addAnnotatedClass(Kettle.class);
                configuration.addAnnotatedClass(Order.class);
                configuration.addAnnotatedClass(Buyer.class);
                configuration.addAnnotatedClass(Product.class);

                configuration.addAnnotatedClass(Worker.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
