package com.example.Social.Web.post;

import com.example.Social.Web.content.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, PostID> {
    boolean existsByPostID_Content(Content content);
    List<Post> findByPostID_Content_User_UserId(Long userId);
    Post findByPostID_Content_ContentId(Long content_id);
}