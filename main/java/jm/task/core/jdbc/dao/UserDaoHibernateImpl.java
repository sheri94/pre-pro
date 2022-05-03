package jm.task.core.jdbc.dao;

import com.mysql.cj.Query;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import javax.security.auth.login.Configuration;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    Util util = new Util();
    SessionFactory sessionFactory = util.getSessionFactory();
    Session session = null;

    public UserDaoHibernateImpl() {
    }


    @Override
    public void createUsersTable() {
      try {
          session = sessionFactory.getCurrentSession();
          Transaction transaction = session.beginTransaction();
          String sql = "CREATE TABLE IF NOT EXISTS `user` (\n" +
                  "  `id` int NOT NULL AUTO_INCREMENT,\n" +
                  "  `name` varchar(45) NOT NULL,\n" +
                  "  `lastName` varchar(45) NOT NULL,\n" +
                  "  `age` int DEFAULT NULL,\n" +
                  "  PRIMARY KEY (`id`),\n" +
                  "  UNIQUE KEY `id_UNIQUE` (`id`)\n" +
                  ");";
          Query query = (Query) session.createSQLQuery(sql).addEntity(User.class);

          transaction.commit();
          session.close();


      }catch (Exception e){
          e.printStackTrace();
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
