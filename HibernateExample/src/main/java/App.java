import models.Message;
import models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/user_message");
        configuration.setProperty("hibernate.connection.username", "postgres");
        configuration.setProperty("hibernate.connection.password", "postgres");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
//        configuration.addAnnotatedClass(User.class);
        configuration.addResource("User.hbm.xml");
        configuration.addAnnotatedClass(Message.class);
        configuration.setProperty("hibernate.show_sql", "true");
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        List<Message> messages = session.createQuery("from Message message", Message.class).getResultList();
        System.out.println(messages);

//        User user = session.createQuery("from User user where user.id = 2", User.class).getSingleResult();

//        session.beginTransaction();
//        session.save(new User("Aina", "ainaard@mail.ru", "aina1"));
//        session.getTransaction().commit();
    }
}
