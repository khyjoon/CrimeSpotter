package com.crimespotter.api.post;

import com.crimespotter.api.post.model.post.Post;
import com.crimespotter.api.user.model.userinfo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }
}
