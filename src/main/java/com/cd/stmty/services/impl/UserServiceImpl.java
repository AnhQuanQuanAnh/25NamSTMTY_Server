package com.cd.stmty.services.impl;

import com.cd.stmty.model.User;
import com.cd.stmty.repository.UserRepository;
import com.cd.stmty.services.UserService;
import com.cd.stmty.util.Const;
import com.cd.stmty.util.UriParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUserName(String userName) {
        try {
            LOGGER.info(Const.LOG_BEGIN_SERVICE + UriParam.GET_WITH_USER_NAME);
            return userRepository.findUserByUserName(userName);
        } finally {
            LOGGER.info(Const.LOG_END_SERVICE + UriParam.GET_WITH_USER_NAME);
        }
    }
}
