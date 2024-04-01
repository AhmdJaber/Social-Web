package com.example.Social.Web.reply;

import com.example.Social.Web.comment.Comment;
import com.example.Social.Web.content.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, ReplyID> {
    boolean existsByReplyID_Content(Content content);
}
