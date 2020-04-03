package com.crimespotter.api.post;

import com.crimespotter.api.post.model.comment.Comment;
import com.crimespotter.api.post.model.post.Post;
import com.crimespotter.api.post.model.post.PostCommunity;
import com.crimespotter.api.post.model.post.PostEvent;
import com.crimespotter.api.user.model.userinfo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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

    public List<Comment> addCommentOnPost(String user_id, String post_id, String content) {
        UUID uuid = UUID.randomUUID();
        String comment_id = uuid.toString();
        return postRepository.addCommentOnPost(comment_id, user_id, post_id, content);
    }

    public List<PostEvent> getAllPosts() {
        return postRepository.getAllPosts();
    }

    public List<PostEvent> getPostInfoByPostId(String postId) {
        return postRepository.getPostInfoByPostId(new ArrayList<>(Arrays.asList(postId)));
    }

    public List<PostEvent> getAllPostInfoByUserId(String userId) {
        return postRepository.getPostsInfoByUserId(userId);
    }

    public Integer getTotalNumberOfPosts() {
        return postRepository.getTotalNumberOfPosts();
    }

    public List<PostCommunity> getTotalPostsInCommunity() {
        return postRepository.getTotalPostsInEachCommunity();
    }
}
