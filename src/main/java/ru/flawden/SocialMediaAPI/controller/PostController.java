package ru.flawden.SocialMediaAPI.controller;

import org.springframework.web.bind.annotation.*;
import ru.flawden.SocialMediaAPI.dto.PostDTO;
import ru.flawden.SocialMediaAPI.entity.Post;
import ru.flawden.SocialMediaAPI.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{user_id}")
    public List<Post> getAllPostsFromUser(@PathVariable Long user_id) {
        return postService.getAllPostsFromUser(user_id);
    }

    @PostMapping
    public void addPosts(@RequestBody PostDTO post, @RequestParam Long author_id) {
        postService.addMessage(post, author_id);
    }
}
