package com.crimespotter.api.post;

import com.crimespotter.api.post.model.post.Post;
import com.crimespotter.api.user.model.userinfo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public String addPost(String userId, String eventId, boolean isActive) {
        UUID uuid = UUID.randomUUID();
        String post_id = uuid.toString();
        postRepository.addPost(post_id, userId, eventId, isActive);
        return post_id;
    }

    public List<Post> getAllPosts() {
        return postRepository.getAllPosts();
    }
}
