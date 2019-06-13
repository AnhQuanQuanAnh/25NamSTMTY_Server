package com.cd.stmty.api.impl;

import com.cd.stmty.api.UserApi;
import com.cd.stmty.model.ApiResponse;
import com.cd.stmty.model.User;
import com.cd.stmty.services.UserService;
import com.cd.stmty.util.Const;
import com.cd.stmty.util.UriParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserApiImpl implements UserApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserApiImpl.class);

    @Autowired
    private UserService userService;

    @Override
    public ApiResponse<User> findByUserName(String userName) {
        try {
            LOGGER.info(Const.LOG_BEGIN_API + UriParam.GET_WITH_USER_NAME);
            User result = userService.findByUserName(userName);
            return new ApiResponse<>(result);
        } finally {
            LOGGER.info(Const.LOG_END_API + UriParam.GET_WITH_USER_NAME);
        }
    }
}
