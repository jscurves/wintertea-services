package com.wintertea.service.user.services.controller;

import com.github.pagehelper.PageInfo;
import com.wintertea.service.user.commons.exception.WinterTeaException;
import com.wintertea.service.user.services.service.IUserService;
import com.wintertea.service.user.services.vo.UserResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api("用户接口模块")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    IUserService userService;

    @GetMapping("/{pageNo}/{pageSize}")
    @ApiOperation(value="分页查询用户信息", notes = "分页查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "条数", required = true, dataType = "Integer")
    })
    public PageInfo<UserResp> selectByPage(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize) throws InstantiationException, IllegalAccessException, WinterTeaException {
        LOGGER.info("selectByPage {} {}", pageNo, pageSize);
        return userService.selectByPage(pageNo, pageSize);
    }
}
