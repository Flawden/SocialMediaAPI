package ru.flawden.SocialMediaAPI.service;

import org.springframework.stereotype.Service;
import ru.flawden.SocialMediaAPI.dto.PostDTO;
import ru.flawden.SocialMediaAPI.entity.Post;
import ru.flawden.SocialMediaAPI.repository.PostRepository;

import java.util.List;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public List<Post> getAllPostsFromUser(Long user_id) {
        return postRepository.findPostsByAuthorid(user_id);
    }

    public void addMessage(PostDTO post, Long author_id) {
        Post newPost = new Post(post.getText(), post.getTag(), author_id);
        postRepository.save(newPost);
    }
}
