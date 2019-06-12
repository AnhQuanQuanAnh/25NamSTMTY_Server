package com.nam.cd.stmty.api;

import com.nam.cd.stmty.model.ApiResponse;
import com.nam.cd.stmty.model.BaseListRequest;
import com.nam.cd.stmty.model.Post;
import com.nam.cd.stmty.util.UriParam;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = UriParam.POST)
public interface PostApi {

    @RequestMapping(value = UriParam.FORWARD_SLASH, method = RequestMethod.GET)
    ApiResponse<Page<Post>> list(BaseListRequest request);
}
