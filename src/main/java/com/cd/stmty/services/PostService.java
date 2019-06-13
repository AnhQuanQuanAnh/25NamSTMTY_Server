package com.cd.stmty.services;

import com.cd.stmty.model.BaseListRequest;
import com.cd.stmty.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface PostService {

    Page<Post> getAll(BaseListRequest request);

    Post insert(Post post);

    Post update(Post post);

    void delete(Long id);
}
