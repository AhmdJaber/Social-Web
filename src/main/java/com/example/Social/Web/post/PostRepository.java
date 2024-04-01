package com.example.Social.Web.post;

import com.example.Social.Web.content.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, PostID> {
    boolean existsByPostID_Content(Content content);
}