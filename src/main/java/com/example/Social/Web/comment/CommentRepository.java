package com.example.Social.Web.comment;

import com.example.Social.Web.content.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, CommentID> {
    boolean existsByCommentID_Content(Content content);
    Optional<Comment> findByCommentID_content(Content content);
    Comment findByCommentID_Content_ContentId(Long content_id);
}
