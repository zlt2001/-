package com.stu_management.mybatisPlus.controller;

import com.stu_management.mybatisPlus.entity.User;
import com.stu_management.mybatisPlus.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zlt
 * @since 2024-07-02
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/list")
    public List<User> list(){
        return iUserService.list();
    }

    //新增
//    修改
//    新增或修改
//    删除
//    查询（模糊、匹配）

}
