package com.example.Social.Web.reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @GetMapping("/allReply")
    public List<Reply> getReplies(){
        return replyService.getAllReplies();
    }

    @GetMapping("getReply/{ReplyID}")
    public Reply getReply(@PathVariable("ReplyID") Long id){
        return replyService.getSomeReply(id);
    }

    @PostMapping("/addReply")
    public Reply addReply(@RequestBody Reply reply){
        replyService.AddReply(reply);
        return reply;
    }

    @DeleteMapping("Delete/{ReplyID}")
    public String deleteReply(@PathVariable("ReplyID") Long id){
        return replyService.deleteReply(id);
    }

    @PutMapping("Update/{ReplyID}")
    public String updateReply(
            @PathVariable("ReplyID") Long reply_id,
            @RequestParam(required = false) String reply_content){
        return replyService.updateReply(reply_id, reply_content);
    }
}
