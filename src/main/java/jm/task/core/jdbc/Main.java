package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        User user = new User("Alexey", "Baryshev", (byte) 40);

        UserDaoHibernateImpl userDao = new UserDaoHibernateImpl();
        userDao.dropUsersTable();
        userDao.createUsersTable();
        userDao.saveUser("Alexey",  "Baryshev", (byte) 40);
    }
}