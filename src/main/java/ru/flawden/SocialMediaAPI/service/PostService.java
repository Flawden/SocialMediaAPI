package ru.flawden.SocialMediaAPI.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.flawden.SocialMediaAPI.entity.Post;
import ru.flawden.SocialMediaAPI.entity.User;
import ru.flawden.SocialMediaAPI.repository.PostRepository;
import ru.flawden.SocialMediaAPI.repository.UserRepository;
import ru.flawden.SocialMediaAPI.util.ConverterUtil;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final ConverterUtil converter;

    @Value("${upload.path}")
    private String uploadPath;

    public PostService(PostRepository postRepository, UserRepository userRepository, ConverterUtil converter) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.converter = converter;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public List<Post> getAllPostsFromUser(Long user_id) {
        return postRepository.findPostsByAuthorid(user_id);
    }

    public void addPosts(String text, String tag, Long author_id, MultipartFile file) {

        String filename;
        Post newPost;

        if (file != null && !file.getOriginalFilename().isEmpty()) {

            File uploadDirMain = new File(uploadPath + File.separator);
            File uploadDir = new File(uploadPath + File.separator + author_id);
            if (!uploadDirMain.exists()) {
                boolean a = uploadDirMain.mkdir();
            }
            if (!uploadDir.exists()) {
                boolean a = uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            filename = uuidFile + "_" + file.getOriginalFilename();

            filename = converter.convert(filename);

            try {
                file.transferTo(new File(uploadPath + "/" + author_id + "/" + filename));
            } catch (IOException e) {
                System.out.println("Uups");
            }
            newPost = new Post(text, tag, author_id, filename);
        } else {
            newPost = new Post(text, tag, author_id);
        }

        postRepository.save(newPost);
    }

    public List<Post> getAllSubscribbersPost(Long user_id) {
        User user = userRepository.findById(user_id).stream().findFirst().get();
        List<User> subscribers = user.getSubscribers();

        List<Post> list = new ArrayList<>();

        for (User subscriber: subscribers) {
            list.addAll(postRepository.findPostsByAuthorid(subscriber.getId()));
        }

        return list;

    }
}
