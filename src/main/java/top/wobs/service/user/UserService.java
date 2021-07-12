package top.wobs.service.user;

import top.wobs.pojo.User;

public interface UserService {
    //用户登录
    public User login(String userNumber, String pwd);
}
