package com.wintertea.service.user.services.controller;

import com.github.pagehelper.PageInfo;
import com.wintertea.service.user.commons.exception.WinterTeaException;
import com.wintertea.service.user.services.service.IUserService;
import com.wintertea.service.user.services.vo.UserResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author woody
 */
@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    IUserService userService;

    @GetMapping("/{pageNo}/{pageSize}")
    public PageInfo<UserResp> selectByPage(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize) throws InstantiationException, IllegalAccessException, WinterTeaException {
        LOGGER.info("selectByPage {} {}", pageNo, pageSize);
        return userService.selectByPage(pageNo, pageSize);
    }
}
