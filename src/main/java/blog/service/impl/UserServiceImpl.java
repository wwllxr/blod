package blog.service.impl;

import blog.common.PageUtil;
import blog.entity.PageInfo;
import blog.entity.User;
import blog.mapper.UserMapper;
import blog.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper mapper;
    @Override
    public User getUserByNameOrEmail(String str) {
        return mapper.getUserByNameOrEmail(str);
    }

    @Override
    public PageInfo<User> getUserList(Integer page, int size) {
        int userCount = mapper.getUserCount();
        PageInfo<User> pageInfo=PageUtil.getPageInfo(size,page,userCount);
        PageHelper.startPage(page,size);
        List<User> userList = mapper.getUserList();
        pageInfo.setList(userList);
        return pageInfo;
    }

    @Override
    public void addUser(User user) {
        user.setUserStatus(1);
        user.setUserRegisterTime(new Date());
        mapper.addUser(user);
    }
}
