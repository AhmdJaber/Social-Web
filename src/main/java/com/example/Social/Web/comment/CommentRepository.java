package com.example.Social.Web.comment;

import com.example.Social.Web.content.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, CommentID> {
    boolean existsByCommentID_Content(Content content);
}
