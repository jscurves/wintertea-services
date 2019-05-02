package com.wintertea.service.user.services.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wintertea.commons.bean.BeanHelper;
import com.wintertea.service.user.commons.exception.WinterTeaException;
import com.wintertea.service.user.services.dao.UserEntityMapper;
import com.wintertea.service.user.services.entity.UserEntity;
import com.wintertea.service.user.services.service.IUserService;
import com.wintertea.service.user.services.vo.UserResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserEntityMapper userEntityMapper;

    @Override
    public PageInfo<UserResp> selectByPage(int pageNo,int pageSize) throws IllegalAccessException, InstantiationException, WinterTeaException {
        LOGGER.info(" UserServiceImpl ");
        PageHelper.startPage(pageNo,pageSize);
        List<UserEntity> userEntities = userEntityMapper.selectAll();
        return BeanHelper.toPageInfo(userEntities, UserResp.class);
    }
}
