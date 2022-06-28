package ru.flawden.SocialMediaAPI.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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

    @GetMapping("ebalabla")
    public List<Post> getAllSubscribbersPost(@RequestParam Long user_id) {
        return postService.getAllSubscribbersPost(user_id);
    }

    @PostMapping
    public void addPosts(@RequestParam String tag,@RequestParam String text, @RequestParam Long author_id,  @RequestParam(name = "file", required = false) MultipartFile file) {
        postService.addPosts(text, tag, author_id, file);
    }
}
