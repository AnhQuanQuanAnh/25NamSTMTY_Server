package com.nam.cd.stmty.services;

import com.nam.cd.stmty.model.BaseListRequest;
import com.nam.cd.stmty.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface PostService {

    Page<Post> getAll(BaseListRequest request);

    void create(Post post);

    void update(Post post);

    void delete(Long id);
}
