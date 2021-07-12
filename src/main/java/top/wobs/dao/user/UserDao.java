package top.wobs.dao.user;


import top.wobs.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDao {
    public User getLoginUser(Connection connection, String userNumber) throws SQLException;
}
