package com.nam.cd.stmty.services.impl;

import com.nam.cd.stmty.repository.UserRepository;
import com.nam.cd.stmty.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
}
