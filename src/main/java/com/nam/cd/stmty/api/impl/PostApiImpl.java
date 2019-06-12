package com.nam.cd.stmty.api.impl;

import com.nam.cd.stmty.api.PostApi;
import com.nam.cd.stmty.model.ApiResponse;
import com.nam.cd.stmty.model.BaseListRequest;
import com.nam.cd.stmty.model.Post;
import com.nam.cd.stmty.services.PostService;
import com.nam.cd.stmty.util.Const;
import com.nam.cd.stmty.util.UriParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

public class PostApiImpl implements PostApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostApiImpl.class);

    @Autowired
    private PostService postService;

    @Override
    public ApiResponse<Page<Post>> list(BaseListRequest request) {
        try {
            LOGGER.info(Const.LOG_BEGIN_API + UriParam.LIST);
            Page<Post> posts = postService.getAll(request);
            return new ApiResponse<>(posts);
        } finally {
            LOGGER.info(Const.LOG_END_API + UriParam.LIST);
        }
    }
}
