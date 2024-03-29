package com.cd.stmty.repository;

import com.cd.stmty.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post, Long> {
	
	Post findPostById(Long id);
}
