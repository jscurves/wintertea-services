package com.wintertea.service.user.services.controller;

import com.github.pagehelper.PageInfo;
import com.wintertea.service.user.commons.exception.WinterTeaException;
import com.wintertea.service.user.services.service.IUserService;
import com.wintertea.service.user.services.vo.UserResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author woody
 */
@RestController
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/{pageNo}/{pageSize}")
    public PageInfo<UserResp> selectByPage(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize) throws InstantiationException, IllegalAccessException, WinterTeaException {
        return userService.selectByPage(pageNo, pageSize);
    }
}
