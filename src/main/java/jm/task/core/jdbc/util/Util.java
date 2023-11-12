package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import javax.imageio.spi.ServiceRegistry;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static final String url = "jdbc:mysql://localhost:3306/pp1134";
    private static final String user = "root";
    private static final String pass = "Bay7013782!";
    private static Connection connection;
    private static SessionFactory sessionFactory;

    public static SessionFactory getHibernateConnection(){
        return new Configuration()
                .setProperty(Environment.URL, url)
                .setProperty(Environment.USER, user)
                .setProperty(Environment.PASS, pass)
                .addAnnotatedClass(User.class).buildSessionFactory();

    }

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url, user, pass);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return connection;
    }
}