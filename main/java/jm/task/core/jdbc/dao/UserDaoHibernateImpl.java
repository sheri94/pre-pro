package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.hibernate.query.Query;

import javax.security.auth.login.Configuration;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    Util util = new Util();
    /*SessionFactory sessionFactory = util.getSessionFactory();
    Session session = null;*/

    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {
        SessionFactory sessionFactory = util.getSessionFactory();
        Session session = null;
        session = sessionFactory.openSession();
      try {
          session.beginTransaction();

          String sql = "CREATE TABLE IF NOT EXISTS `user` (\n" +
                  "  `id` int NOT NULL AUTO_INCREMENT,\n" +
                  "  `name` varchar(45) NOT NULL,\n" +
                  "  `lastName` varchar(45) NOT NULL,\n" +
                  "  `age` int DEFAULT NULL,\n" +
                  "  PRIMARY KEY (`id`),\n" +
                  "  UNIQUE KEY `id_UNIQUE` (`id`)\n" +
                  ");";

          Query query = session.createSQLQuery(sql).addEntity(User.class);
          query.executeUpdate();
          System.out.println(query);
          session.getTransaction().commit();
      }catch (Exception e){
          session.getTransaction().rollback();
          e.printStackTrace();
      }finally {
          session.close();
          sessionFactory.close();
      }
    }

    @Override
    public void dropUsersTable() {


    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }
}
