package com.example.Social.Web.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("Post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("allPosts")
    public List<Post> getPosts(){
        return postService.allPosts();
    }

    @GetMapping("getPost/{PostID}")
    public Post getPost(@PathVariable("PostID") PostID id){
        return postService.getSomePost(id);
    }

    @GetMapping("getUserPosts/{UserID}")
    public List<Post> userPosts(@PathVariable("UserID") Long userID){
        return postService.getUserPosts(userID);
    }

    @GetMapping("visiblePosts/{UserID}")
    public List<Post> accessiblePosts(@PathVariable("UserID") Long userID){
        return postService.getAccessiblePosts(userID);
    }
    @PostMapping("/addPost/{UserID}")
    public Post addPost(@PathVariable("UserID") Long userID,
                        @RequestBody Post post){
        return postService.AddPost(post, userID);
    }

    @DeleteMapping("Delete/{PostID}")
    public String deletePost(@PathVariable("PostID") PostID post_id){
        return postService.deletePost(post_id);
    }

    @PutMapping("Update/{PostID}")
    public String updatePost(
            @PathVariable("PostID") PostID post_id,
            @RequestParam(required = false) String post_content){
        return postService.updatePost(post_id, post_content);
    }
}
