package blog.service;

import blog.entity.PageInfo;
import blog.entity.User;

public interface UserService {
    /**
     * 根据用户名或邮箱查询用户
     * @param str 用户账号或邮箱
     * @return 用户信息
     */
    User getUserByNameOrEmail(String str);

    PageInfo<User> getUserList(Integer page, int i);

    void addUser(User user);
}
