package com.crimespotter.api.post;

import com.crimespotter.api.event.model.eventinfo.Event;
import com.crimespotter.api.post.model.comment.Comment;
import com.crimespotter.api.post.model.post.Post;
import com.crimespotter.api.post.model.post.PostEvent;

import java.util.List;

interface PostRepository {
    void addPost(String post_id, String user_id, String event_id, boolean isActive);

    List<Comment> addCommentOnPost(String comment_id, String user_id, String post_id, String content);

    List<Comment> getCommentById(String comment_id);

    List<PostEvent> getAllPosts();

    List<PostEvent> getPostsInfoByUserId(String userId);

    List<PostEvent> getPostInfoByPostId(List<String> postId);
}
