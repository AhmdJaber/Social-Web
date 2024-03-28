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
    public Post getPost(@PathVariable("PostID") Long id){
        return postService.getSomePost(id);
    }

    @PostMapping("/addPost")
    public Post addPost(@RequestBody Post post){
        postService.AddPost(post);
        return post;
    }

    @DeleteMapping("Delete/{PostID}")
    public String deletePost(@PathVariable("PostID") Long id){
        return postService.deletePost(id);
    }

    @PutMapping("Update/{PostID}")
    public String updatePost(
            @PathVariable("PostID") Long post_id,
            @RequestParam(required = false) String post_content){
        return postService.updatePost(post_id, post_content);
    }
}
