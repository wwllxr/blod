package blog.service.impl;

import blog.entity.Tag;
import blog.entity.User;
import blog.mapper.TagMapper;
import blog.mapper.UserMapper;
import blog.service.TagService;
import blog.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Resource
    private TagMapper mapper;

    @Override
    public List<Tag> getAllTag() {
        return mapper.getAllTag();
    }
}
