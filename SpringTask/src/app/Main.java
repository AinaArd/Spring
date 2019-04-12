package app;

import db.DBUsers;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import view.View;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");

//          file db
//        DBUsers dbTxt = (DBUsers) applicationContext.getBean("dbTxt");
//        View view = applicationContext.getBean(View.class);
//        System.out.println(view.showUser(dbTxt.getUser("aina")));
//        System.out.println(view.showUsers(dbTxt.getUsers()));

//         postgres db
        DBUsers dbPostgres = (DBUsers) applicationContext.getBean("dbPostgres");
        View view2 = (View) applicationContext.getBean("view");
        System.out.println(view2.showUser(dbPostgres.getUser("aina")));
        System.out.println(view2.showUsers(dbPostgres.getUsers()));

//        App app = applicationContext.getBean(App.class);
    }
}
