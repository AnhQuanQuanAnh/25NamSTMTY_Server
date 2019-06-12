package com.nam.cd.stmty.services.impl;

import com.nam.cd.stmty.model.BaseListRequest;
import com.nam.cd.stmty.model.Post;
import com.nam.cd.stmty.repository.PostRepository;
import com.nam.cd.stmty.services.PostService;
import com.nam.cd.stmty.util.Const;
import com.nam.cd.stmty.util.UriParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class PostServiceImpl implements PostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostServiceImpl.class);

    @Autowired
    private PostRepository postRepository;

    @Override
    public Page<Post> getAll(BaseListRequest request) {
        try {
            LOGGER.info(Const.LOG_BEGIN_SERVICE + UriParam.LIST);
            PageRequest pageRequest = request.createPageRequest(UriParam.POST_ID);
            Page<Post> posts = postRepository.findAll(pageRequest);
            LOGGER.debug(posts.toString());
            return posts;
        } finally {
            LOGGER.info(Const.LOG_END_SERVICE + UriParam.LIST);
        }
    }

    @Override
    public void create(Post post) {

    }

    @Override
    public void update(Post post) {

    }

    @Override
    public void delete(Long id) {

    }
}
