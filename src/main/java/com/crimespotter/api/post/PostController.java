package com.crimespotter.api.post;

import com.crimespotter.api.post.model.post.Post;
import com.crimespotter.api.post.model.post.PostCommunity;
import com.crimespotter.api.post.model.post.PostEvent;
import com.crimespotter.api.user.model.community.Community;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping(method = RequestMethod.PUT, value = "/post")
    public String addPost(@RequestParam("user_id") String userId,
                          @RequestParam("event_id") String eventId,
                          @RequestParam("isActive") boolean isActive) {
        return postService.addPost(userId, eventId, isActive);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/post")
    public List<PostEvent> getPostInfo(@RequestParam(value="post_id", required=false) String postId,
                                       @RequestParam(value="user_id", required=false) String userId) {
        if (!postId.isEmpty()) {
            return postService.getPostInfoByPostId(postId);
        } else if (postId.isEmpty() && !userId.isEmpty()) {
            return postService.getAllPostInfoByUserId(userId);
        } else {
            return postService.getPostInfoByPostId("");
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/post/total")
    public Integer getTotalNumberOfPosts() {
        return postService.getTotalNumberOfPosts();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/post/communitytotal")
    public List<PostCommunity> getTotalPostsInCommunity() {
        return postService.getTotalPostsInCommunity();
    }
}
