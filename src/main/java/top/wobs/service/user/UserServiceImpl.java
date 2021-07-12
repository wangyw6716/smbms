package top.wobs.service.user;

import org.junit.Test;
import top.wobs.dao.baseDao;
import top.wobs.dao.user.UserDao;
import top.wobs.dao.user.UserDaoImpl;
import top.wobs.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService{

    //调用Dao
    private UserDao userDao;
    public  UserServiceImpl(){
        userDao = new UserDaoImpl();
    }

    @Override
    public User login(String userNumber, String pwd) {
        Connection connection = null;
        User user = null;


        try {
            connection = baseDao.getConnection();
            //通过业务层调用对应的具体的数据库操作
           user = userDao.getLoginUser(connection, userNumber);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            baseDao.closeResource(connection,null,null);
        }
        return user;
    }

    @Test
    public void test(){
        UserServiceImpl userService = new UserServiceImpl();
        User admin = userService.login("10001","123456");
        System.out.println(admin.getUserPassword());
    }


}
