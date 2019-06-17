package com.cd.stmty.services.impl;

import com.cd.stmty.model.BaseListRequest;
import com.cd.stmty.model.Post;
import com.cd.stmty.repository.PostRepository;
import com.cd.stmty.services.PostService;
import com.cd.stmty.util.Const;
import com.cd.stmty.util.StringUtil;
import com.cd.stmty.util.UriParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Base64;

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
//            posts.forEach(post -> {
//                String imagePath = post.getImagePath();
//                String base64Image = UtilBase64Image.encoder(imagePath);
//                UtilBase64Image.decoder(base64Image, imagePath);
//            });
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
            if (!StringUtil.isEmpty(post.getImagePath())) {
                File file = new File(post.getImagePath());
                try (FileInputStream imageInFile = new FileInputStream(file)) {
                    // Reading a Image file from file system
                    byte imageData[] = new byte[(int) file.length()];
                    imageInFile.read(imageData);
                    String base64Image = Base64.getEncoder().encodeToString(imageData);
                    post.setImagePath(base64Image);
                } catch (FileNotFoundException e) {
                    System.out.println("Image not found" + e);
                } catch (IOException ioe) {
                    System.out.println("Exception while reading the Image " + ioe);
                }
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
            post.setUpdateDate(new Date());
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
