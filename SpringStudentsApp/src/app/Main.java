package app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        App app = applicationContext.getBean(App.class);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String request = "";

        while (!request.equals("exit")) {
            request = bufferedReader.readLine();
            System.out.println(app.response(request));
        }
    }
}
