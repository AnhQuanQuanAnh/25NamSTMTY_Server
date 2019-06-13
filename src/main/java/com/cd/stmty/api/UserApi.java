package com.cd.stmty.api;

import com.cd.stmty.model.ApiResponse;
import com.cd.stmty.model.User;
import com.cd.stmty.util.UriParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = UriParam.USER)
public interface UserApi {

    @RequestMapping(value = UriParam.GET_WITH_USER_NAME, method = RequestMethod.GET)
    ApiResponse<User> findByUserName(String userName);
}
