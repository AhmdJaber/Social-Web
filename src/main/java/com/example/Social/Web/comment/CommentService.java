package com.example.Social.Web.comment;

import com.example.Social.Web.content.Content;
import com.example.Social.Web.content.ContentRepository;
import com.example.Social.Web.post.PostID;
import com.example.Social.Web.reply.ReplyRepository;
import com.example.Social.Web.user.User;
import com.example.Social.Web.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ContentRepository contentRepository;
    private final CommentRepository commentRepository;
    @Autowired
    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    public Comment getSomeComment(CommentID commentId){
        return commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalStateException("There is no Comment with ID = " + commentId)
        );
    }

    public Comment AddComment(Comment comment, Long userID){
        User user = userRepository.findById(userID).orElseThrow(
                () -> new IllegalStateException("There is no User with ID = " + userID)
        );

        Content newContent= new Content(user, "comment");
        contentRepository.save(newContent);
        CommentID commentID= new CommentID(newContent);
        comment.setCommentID(commentID);

        return commentRepository.save(comment);
    }

    public String deleteComment(CommentID commentId){
        boolean chk = commentRepository.existsById(commentId);
        if (chk){
            commentRepository.deleteById(commentId);
            return "The Comment with ID = " + commentId + " has been deleted!";
        }

        return "There is not comment with id = " + commentId;
    }

    @Transactional
    public String updateComment(CommentID commentId, String comment_content){
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalStateException("There is no Comment with ID = " + commentId)
        );

        comment.setCommentContent(comment_content);
        return "Action is done";
    }

}
