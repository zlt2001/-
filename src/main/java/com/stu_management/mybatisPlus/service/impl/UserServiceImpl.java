package com.stu_management.mybatisPlus.service.impl;

import com.stu_management.mybatisPlus.entity.User;
import com.stu_management.mybatisPlus.mapper.UserMapper;
import com.stu_management.mybatisPlus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zlt
 * @since 2024-07-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
