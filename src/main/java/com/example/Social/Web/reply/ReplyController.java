package com.example.Social.Web.reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @GetMapping("/allReplies")
    public List<Reply> getReplies(){
        return replyService.getAllReplies();
    }

    @GetMapping("getReply/{ReplyID}")
    public Reply getReply(@PathVariable("ReplyID") ReplyID id){
        return replyService.getSomeReply(id);
    }

    @PostMapping("/addReply/{UserID}")
    public Reply addReply(@PathVariable("UserID") Long userID,
                          @RequestBody Reply reply){
        return replyService.AddReply(reply, userID);
    }

    @DeleteMapping("Delete/{ReplyID}")
    public String deleteReply(@PathVariable("ReplyID") ReplyID id){
        return replyService.deleteReply(id);
    }

    @PutMapping("Update/{ReplyID}")
    public String updateReply(
            @PathVariable("ReplyID") ReplyID reply_id,
            @RequestParam(required = false) String reply_content){
        return replyService.updateReply(reply_id, reply_content);
    }
}
