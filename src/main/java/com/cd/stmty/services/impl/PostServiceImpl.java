package com.cd.stmty.services.impl;

import com.cd.stmty.model.BaseListRequest;
import com.cd.stmty.model.Post;
import com.cd.stmty.repository.PostRepository;
import com.cd.stmty.services.PostService;
import com.cd.stmty.util.Const;
import com.cd.stmty.util.UriParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
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
    public Post insert(Post post) {
        try {
            LOGGER.info(Const.LOG_BEGIN_SERVICE + UriParam.INSERT);
            Post result = postRepository.save(post);
            LOGGER.debug(result.toString());
            return result;
        } finally {
            LOGGER.info(Const.LOG_END_SERVICE + UriParam.INSERT);
        }
    }

    @Override
    public Post update(Post post) {
        try {
            LOGGER.info(Const.LOG_BEGIN_SERVICE + UriParam.UPDATE);
            Post result = postRepository.save(post);
            LOGGER.debug(result.toString());
            return result;
        } finally {
            LOGGER.info(Const.LOG_END_SERVICE + UriParam.UPDATE);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            LOGGER.info(Const.LOG_BEGIN_SERVICE + UriParam.DELETE);
            if (id != null){
                postRepository.deleteById(id);
            }
        } finally {
            LOGGER.info(Const.LOG_END_SERVICE + UriParam.DELETE);
        }
    }

}