package blog.mapper;

import blog.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserMapper {
    /**
     * 根据用户名或邮箱查询用户
     * @param str 用户账号或邮箱
     * @return 用户信息
     */
    User getUserByNameOrEmail(String str);

    int getUserCount();

    List<User> getUserList();

    void addUser(User user);
}
