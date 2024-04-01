package com.example.Social.Web.reply;

import com.example.Social.Web.content.Content;
import com.example.Social.Web.content.ContentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {
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

    public void AddReply(Reply reply){
        if (replyRepository.existsByReplyID_Content(reply.getReplyID().getContent())){
            throw new IllegalStateException("This content id: " +
                    reply.getReplyID().getContent().getContent_id()
                    + " is already used for another content");
        }

        replyRepository.save(reply);

        Content content = contentRepository.findById(reply.getReplyID().getContent().getContent_id())
                .orElseThrow(() -> new IllegalStateException("Content not found"));

        content.setType("reply");
        contentRepository.save(content);
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
