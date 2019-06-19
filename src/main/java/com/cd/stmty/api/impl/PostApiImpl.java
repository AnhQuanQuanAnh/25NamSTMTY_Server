package com.cd.stmty.api.impl;

import com.cd.stmty.api.PostApi;
import com.cd.stmty.exception.StmtyException;
import com.cd.stmty.model.ApiResponse;
import com.cd.stmty.model.BaseListRequest;
import com.cd.stmty.model.Post;
import com.cd.stmty.services.PostService;
import com.cd.stmty.util.Const;
import com.cd.stmty.util.ObjectUtil;
import com.cd.stmty.util.UriParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Component
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

    @Override
    public ApiResponse<Post> insert(@RequestBody Post post) {
        try {
            LOGGER.info(Const.LOG_BEGIN_API + UriParam.INSERT);
            Post result = postService.insert(post);
            return new ApiResponse<>(result);
        } finally {
            LOGGER.info(Const.LOG_END_API + UriParam.INSERT);
        }
    }

    @Override
    public ApiResponse<Post> update(@RequestBody Post post) {
        try {
            LOGGER.info(Const.LOG_BEGIN_API + UriParam.UPDATE);
            Post result = postService.update(post);
            return new ApiResponse<>(result);
        } finally {
            LOGGER.info(Const.LOG_END_API + UriParam.UPDATE);
        }
    }

    @Override
    public ApiResponse<Boolean> delete(Long postId) {
        try {
            LOGGER.info(Const.LOG_BEGIN_API + UriParam.DELETE);
            postService.delete(postId);
            return new ApiResponse<>(true);
        } finally {
            LOGGER.info(Const.LOG_END_API + UriParam.DELETE);
        }
    }

    @Override
    public ApiResponse<Post> getById(@PathVariable(value = UriParam.ID) Long id) {
        try {
            LOGGER.info(Const.LOG_BEGIN_API + UriParam.GET_WITH_ID);
            if (ObjectUtil.isEmpty(id)) {
                throw new StmtyException("Id not empty");
            }
            Post result = postService.getById(id);
            return new ApiResponse<>(result);
        } finally {
            LOGGER.info(Const.LOG_END_API + UriParam.GET_WITH_ID);
        }
    }

}
