package com.crimespotter.api.post;

import com.crimespotter.api.post.model.comment.Comment;
import com.crimespotter.api.post.model.post.Post;
import com.crimespotter.api.post.model.post.PostCommunity;
import com.crimespotter.api.post.model.post.PostEvent;
import com.crimespotter.api.user.model.community.Community;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping(method = RequestMethod.PUT, value = "/post")
    public String addPost(@RequestParam("user_id") String userId,
                          @RequestParam("event_id") String eventId,
                          @RequestParam("isActive") boolean isActive) {
        return postService.addPost(userId, eventId, isActive);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/post/comment")
    public List<Comment> addCommentToPost(@RequestParam("post_id") String postId,
                                          @RequestParam("user_id") String userId,
                                          @RequestParam("comment") String comment) {
        return postService.addCommentOnPost(userId, postId, comment);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/post/comment")
    public List<Comment> addCommentToPost(@RequestParam("post_id") String postId) {
        return postService.getCommentByPostId(postId);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/post")
    public List<PostEvent> getPostInfo(@RequestParam(value="post_id", required=false) String postId,
                                       @RequestParam(value="user_id", required=false) String userId,
                                       @RequestParam(value="community_id", required=false) String communityId) {
        if (postId != null) {
            return postService.getPostInfoByPostId(postId);
        } else if (userId != null) {
            return postService.getAllPostInfoByUserId(userId);
        } else {
            return postService.getPostsByCommunityId(communityId);
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
