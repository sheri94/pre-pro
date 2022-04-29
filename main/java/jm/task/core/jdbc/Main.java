package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserService userServiceImpl = new UserServiceImpl();

        userServiceImpl.createUsersTable();

        userServiceImpl.saveUser("Andrey", "Volsky", (byte) 28);
        userServiceImpl.saveUser("Katya", "Volk", (byte) 23);
        userServiceImpl.saveUser("Macha", "Kun", (byte) 34);
        userServiceImpl.saveUser("Tolua", "Bel", (byte) 29);

        userServiceImpl.getAllUsers();

        userServiceImpl.removeUserById(3);

        userServiceImpl.cleanUsersTable();

      //  userServiceImpl.dropUsersTable();

    }
}
