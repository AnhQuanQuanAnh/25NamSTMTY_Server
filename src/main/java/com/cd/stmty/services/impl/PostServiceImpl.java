package com.cd.stmty.services.impl;

import com.cd.stmty.exception.StmtyException;
import com.cd.stmty.model.BaseListRequest;
import com.cd.stmty.model.Post;
import com.cd.stmty.repository.PostRepository;
import com.cd.stmty.services.PostService;
import com.cd.stmty.util.Const;
import com.cd.stmty.util.ObjectUtil;
import com.cd.stmty.util.StringUtil;
import com.cd.stmty.util.UriParam;
import com.cd.stmty.util.UtilBase64Image;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PostServiceImpl implements PostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostServiceImpl.class);

    @Autowired
    private PostRepository postRepository;

    @Override
    public Page<Post> getAll(BaseListRequest request) {
        try {
            LOGGER.info(Const.LOG_BEGIN_SERVICE + UriParam.LIST);
            PageRequest pageRequest = request.createPageRequest(UriParam.ID);
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
            if (!StringUtil.isEmpty(post.getImage())) {
            	post.setImage(UtilBase64Image.encoder(post.getImage()));
            }
            post.setCreateDate(new Date());
            post.setUpdateDate(new Date());
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
            if (ObjectUtil.isEmpty(post.getId())) {
            	throw new StmtyException("Id is not empty");
            }
            Post postUpdated = postRepository.findPostById(post.getId());
            postUpdated.setDepartmentNo(post.getDepartmentNo());
            postUpdated.setTitle(post.getTitle());
            postUpdated.setDescription(post.getDescription());
            if (!StringUtil.isEmpty(post.getImage())) {
            	postUpdated.setImage(UtilBase64Image.encoder(post.getImage()));
            }
            postUpdated.setUpdateDate(new Date());
            Post result = postRepository.save(postUpdated);
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
            if (ObjectUtil.isNotEmpty(id)){
                postRepository.deleteById(id);
            }
        } finally {
            LOGGER.info(Const.LOG_END_SERVICE + UriParam.DELETE);
        }
    }

    @Override
    public Post getById(Long id) {
        try {
            LOGGER.info(Const.LOG_BEGIN_SERVICE + UriParam.GET_WITH_ID);
            Post post = null;
            if (ObjectUtil.isNotEmpty(id)){
                post = postRepository.findPostById(id);
                if (ObjectUtil.isEmpty(post)) {
                    throw new StmtyException("No data");
                }
            }
            return post;
        } finally {
            LOGGER.info(Const.LOG_END_SERVICE + UriParam.GET_WITH_ID);
        }
    }

}
