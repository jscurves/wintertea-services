package com.wintertea.service.user.services.service;

import com.github.pagehelper.PageInfo;
import com.wintertea.service.user.commons.exception.WinterTeaException;
import com.wintertea.service.user.services.vo.UserResp;

public interface IUserService {

    PageInfo<UserResp> selectByPage(int pageNo, int pageSize) throws WinterTeaException, IllegalAccessException, InstantiationException;

}
