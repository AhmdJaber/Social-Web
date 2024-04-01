package com.example.Social.Web.reply;

import com.example.Social.Web.content.Content;
import com.example.Social.Web.content.ContentRepository;
import com.example.Social.Web.post.PostID;
import com.example.Social.Web.user.User;
import com.example.Social.Web.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ContentRepository contentRepository;
    private final ReplyRepository replyRepository;
    @Autowired
    public ReplyService(ReplyRepository replyRepository){
        this.replyRepository = replyRepository;
    }

    public List<Reply> getAllReplies(){
        return replyRepository.findAll();
    }

    public Reply getSomeReply(ReplyID reply_id){
        return replyRepository.findById(reply_id).orElseThrow(
                () -> new IllegalStateException("There is no Reply with ID = " + reply_id)
        );
    }

    public Reply AddReply(Reply reply, Long userID){
        User user = userRepository.findById(userID).orElseThrow(
                () -> new IllegalStateException("There is no User with ID = " + userID)
        );

        Content newContent= new Content(user, "post");
        contentRepository.save(newContent);
        ReplyID replyID = new ReplyID(newContent);
        reply.setReplyID(replyID);

        return replyRepository.save(reply);
    }

    public String deleteReply(ReplyID reply_id){
        boolean chk = replyRepository.existsById(reply_id);
        if (chk){
            replyRepository.deleteById(reply_id);
            return "The Reply with ID = " + reply_id + " has been deleted!";
        }

        return "There is not reply with id = " + reply_id;
    }

    @Transactional
    public String updateReply(ReplyID reply_id, String reply_content){
        Reply reply = replyRepository.findById(reply_id).orElseThrow(
                () -> new IllegalStateException("There is no Reply with ID = " + reply_id)
        );

        reply.setReply_content(reply_content);
        return "Action is done";
    }
}
