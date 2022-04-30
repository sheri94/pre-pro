package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJDBCImpl implements UserDao {
    Util util = new Util();
    PreparedStatement pstm = null;
    Statement stm = null;
    Connection conn = null;

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        final String CREATE =
                "CREATE TABLE IF NOT EXISTS `user` (\n" +
                        "  `id` int NOT NULL AUTO_INCREMENT,\n" +
                        "  `name` varchar(45) NOT NULL,\n" +
                        "  `lastName` varchar(45) NOT NULL,\n" +
                        "  `age` int DEFAULT NULL,\n" +
                        "  PRIMARY KEY (`id`),\n" +
                        "  UNIQUE KEY `id_UNIQUE` (`id`)\n" +
                        ");";

        try (Connection conn = util.getConnection()) {
            stm = conn.createStatement();
            stm.executeUpdate(CREATE);
            conn.close();
            stm.close();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void dropUsersTable() {
        final String DROP = "DROP TABLE IF EXISTS user;";
        try (Connection conn = util.getConnection()) {
            stm = conn.createStatement();
            stm.executeUpdate(DROP);
            conn.close();
            stm.close();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        final String SAVEUSER = "insert into user(name, lastName, age) values (?, ?, ?)";

        try (Connection conn = util.getConnection()) {
            pstm = conn.prepareStatement(SAVEUSER);
            pstm.setString(1, name);
            pstm.setString(2, lastName);
            pstm.setInt(3, age);
            pstm.execute();
            conn.close();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void removeUserById(long id) {
        final String REMOVE = "DELETE FROM user WHERE id = ?;";
        try (Connection conn = util.getConnection()) {
            pstm = conn.prepareStatement(REMOVE);
            pstm.setLong(1, id);
            pstm.executeUpdate();
            conn.close();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        final String GETALLUSERS = "SELECT id, name, lastName, age FROM user;";

        try (Connection conn = util.getConnection()) {
            stm = conn.createStatement();
            ResultSet resultSet = stm.executeQuery(GETALLUSERS);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge((byte) resultSet.getInt("age"));
                users.add(user);
            }
            System.out.print(users);
            conn.close();
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void cleanUsersTable() {
        final String DELETE = "TRUNCATE TABLE user;";
        try (Connection conn = util.getConnection()) {
            stm = conn.createStatement();
            stm.executeUpdate(DELETE);
            conn.close();
            stm.close();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
