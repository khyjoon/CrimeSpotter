package com.crimespotter.api.post;

import com.crimespotter.api.post.model.post.Post;

import java.util.List;

interface PostRepository {
    void addPost(String post_id, String user_id, String event_id, boolean isActive);

    void addCommentOnPost(String comment_id, String user_id, String post_id, String content);

    List<Post> getAllPosts();
}
