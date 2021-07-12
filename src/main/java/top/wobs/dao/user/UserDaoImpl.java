package top.wobs.dao.user;

import top.wobs.dao.baseDao;
import top.wobs.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao{

    @Override
    public User getLoginUser(Connection connection, String userNumber) throws SQLException {

        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;


        if (connection != null) {
            String sql = "select * from user where userNumber=?";
            Object[] params = {userNumber};
            rs = baseDao.execute(connection, pstm, rs, sql, params);
            if (rs.next()) {
                user = new User();
                user.setId(rs.getString("id"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setUserNumber(rs.getString("userNumber"));
                user.setUserType(rs.getString("userType"));
            }
        }
        return user;
    }
}
