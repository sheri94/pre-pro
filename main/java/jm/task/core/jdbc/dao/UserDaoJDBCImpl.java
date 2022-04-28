package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJDBCImpl implements UserDao {
    Util util = new Util();
    Connection conn = util.getConnection();
    PreparedStatement stm = null;


    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() throws SQLException {
        final String CREATE =
                "CREATE TABLE IF NOT EXISTS `user` (\n" +
                        "  `id` int NOT NULL AUTO_INCREMENT,\n" +
                        "  `name` varchar(45) NOT NULL,\n" +
                        "  `lastName` varchar(45) NOT NULL,\n" +
                        "  `age` int DEFAULT NULL,\n" +
                        "  PRIMARY KEY (`id`),\n" +
                        "  UNIQUE KEY `id_UNIQUE` (`id`)\n" +
                        ");";
        try {
            stm = conn.prepareStatement(CREATE);
            stm.execute();
            System.out.println("Открытие в поле криет " + conn.isClosed());
        } catch (SQLException e) {
            throw new RuntimeException();
        }/*finally {
            conn.close();
            System.out.println("Закрытие в поле криет " + conn.isClosed());
        }*/
    }

    public void dropUsersTable() throws SQLException {
        final String DROP =
                "DROP TABLE IF EXISTS user;";
        try {
            stm = conn.prepareStatement(DROP);
            stm.executeUpdate();
            System.out.println("Открытие в поле дроп " + conn.isClosed());
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            conn.close();
            System.out.println("Закрытие в поле дроп " + conn.isClosed());
        }
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {


        final String SAVEUSER =
                "insert into user(name, lastName, age) values (?, ?, ?)";

        try {
            stm = conn.prepareStatement(SAVEUSER);
            stm.setString(1, name);
            stm.setString(2, lastName);
            stm.setInt(3, age);
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        } /*finally {
            conn.close();
            System.out.println("Закрытие в поле сейв " + conn.isClosed());
        }*/
    }

    public void removeUserById(long id) throws SQLException {
        final String REMOVE = "DELETE FROM user WHERE id = ?;";
        try {
            stm = conn.prepareStatement(REMOVE);
            stm.setLong(1, id);
            stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        } /*finally {
            conn.close();
            System.out.println("Закрытие в поле удалить пользователя " + conn.isClosed());
        }*/
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        final String GETALLUSERS = "SELECT id, name, lastName, age FROM user;";
        Statement statement = null;

        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(GETALLUSERS);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge((byte) resultSet.getInt("age"));

                users.add(user);

            }
            System.out.print(users);
        } catch (SQLException e) {
            e.printStackTrace();
        } /*finally {
            conn.close();
            System.out.println("Закрытие в поле вывод всех пользователей " + conn.isClosed());
        }*/
        return users;
    }

    public void cleanUsersTable() throws SQLException {
        final String DELETE = "TRUNCATE TABLE user;";
        try {
            stm = conn.prepareStatement(DELETE);
            stm.executeUpdate();
            System.out.println("Открытие в поле криет " + conn.isClosed());
        } catch (SQLException e) {
            throw new RuntimeException();
        }/*finally {
            conn.close();
            System.out.println("Закрытие в поле клин " + conn.isClosed());
        }*/

    }
}
