package com.example.Social.Web.post;

import com.example.Social.Web.content.ContentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private ContentRepository contentRepository;
    private final PostRepository postRepository;
    @Autowired
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public List<Post> allPosts(){
        return postRepository.findAll();
    }

    public Post getSomePost(Long post_id){
        return postRepository.findById(post_id).orElseThrow(
                () -> new IllegalStateException("There is no Student with ID = " + post_id)
        );
    }

    public void AddPost(Post post){
        if (post.getContent().getType() != null){
            throw new IllegalStateException("This post id: " +
                    post.getContent().getContent_id()
                    + " is already used for another content");
        }

        post.setContent(contentRepository.findById(
                        post.getContent().getContent_id()).orElseThrow(
                        () -> new IllegalStateException("There is not content with this id")
                )
        );
        post.getContent().setType("post");
        postRepository.save(post);
    }

    public String deletePost(Long post_id){
        boolean chk = postRepository.existsById(post_id);
        if (chk){
            postRepository.deleteById(post_id);
            return "The Post with ID = " + post_id + " has been deleted!";
        }

        return "There is not post with id = " + post_id;
    }

    @Transactional
    public String updatePost(Long post_id, String post_content){
        Post post = postRepository.findById(post_id).orElseThrow(
                () -> new IllegalStateException("There is no Post with ID = " + post_id)
        );

        post.setPost_content(post_content);
        return "Action is done";
    }


}
