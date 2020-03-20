package com.crimespotter.api.post;

import com.crimespotter.api.post.model.post.Post;
import com.crimespotter.api.post.model.post.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addPost(String post_id, String user_id, String event_id, boolean isActive) {
        String query =
                "INSERT INTO Post (post_id, user_id, event_id, post_time, isActive)\n" +
                        "VALUES (?,?,?,CURRENT_TIME,?)";
        jdbcTemplate.update(query, post_id, user_id, event_id, isActive);
    }

    @Override
    public void addCommentOnPost(String comment_id, String user_id, String post_id, String content) {
        String query =
                "INSERT INTO UserPostComment (comment_id, user_id, post_id, content, time)\n" +
                        "VALUES (?,?,?,?,CURRENT_TIME)";
        jdbcTemplate.update(query, comment_id, user_id, post_id, content);
    }

    @Override
    public List<Post> getAllPosts() {
        String readQuery =
                "SELECT *\n" +
                        "FROM Post";

        List<Post> posts = jdbcTemplate.query(readQuery, new PostMapper());
        return posts;
    }


}
