package com.crimespotter.api.post;

import com.crimespotter.api.event.model.caraccidentinfo.CarAccidentMapper;
import com.crimespotter.api.event.model.crimeinfo.CrimeMapper;
import com.crimespotter.api.event.model.eventinfo.Event;
import com.crimespotter.api.event.model.eventinfo.EventMapper;
import com.crimespotter.api.event.model.naturaldisasterinfo.NaturalDisasterMapper;
import com.crimespotter.api.post.model.comment.Comment;
import com.crimespotter.api.post.model.comment.CommentMapper;
import com.crimespotter.api.post.model.post.Post;
import com.crimespotter.api.post.model.post.PostEvent;
import com.crimespotter.api.post.model.post.PostEventMapper;
import com.crimespotter.api.post.model.post.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public List<Comment> addCommentOnPost(String comment_id, String user_id, String post_id, String content) {
        String query =
                "INSERT INTO UserPostComment (comment_id, user_id, post_id, content, time)\n" +
                        "VALUES (?,?,?,?,CURRENT_TIME)";
        jdbcTemplate.update(query, comment_id, user_id, post_id, content);
        return getCommentById(comment_id);
    }

    @Override
    public List<Comment> getCommentById(String comment_id) {
        String readQuery =
                "SELECT comment_id\n" +
                        "FROM UserPostComment\n" +
                                "WHERE comment_id = ?";
        List<Comment> comment = jdbcTemplate.query(readQuery, new CommentMapper(), comment_id);
        return comment;
    }

    @Override
    public List<PostEvent> getAllPosts() {
        String readQuery =
                "SELECT post_id\n" +
                        "FROM Post";

        List<Post> posts = jdbcTemplate.query(readQuery, new PostMapper());
        List<String> postIdList = posts.stream().map(Post::getPostId).collect(Collectors.toList());
        return getPostInfoByPostId(postIdList);
    }

    @Override
    public List<PostEvent> getPostsInfoByUserId(String userId) {
        String readQuery =
                "SELECT post_id\n" +
                        "FROM Post\n" +
                                "WHERE user_id = ?";

        List<Post> posts = jdbcTemplate.query(readQuery, new PostMapper(), userId);
        List<String> postIdList = posts.stream().map(Post::getPostId).collect(Collectors.toList());
        return getPostInfoByPostId(postIdList);
    }

    @Override
    public List<PostEvent> getPostInfoByPostId(List<String> postId) {
        String crimePostEventQuery =
                "SELECT *\n" +
                        "FROM Post p\n" +
                                "JOIN Event e ON e.event_id = p.event_id\n" +
                                        "JOIN Crime c ON c.event_id = p.event_id\n" +
                                                "WHERE p.post_id IN (?);";
        List<PostEvent> crimePostEventList = jdbcTemplate.query(crimePostEventQuery, postId.toArray(), new PostEventMapper());

        String carAccidentPostEventQuery =
                "SELECT *\n" +
                        "FROM Post p\n" +
                                "JOIN Event e ON e.event_id = p.event_id\n" +
                                        "JOIN CarAccident ca ON ca.event_id = p.event_id\n" +
                                                "WHERE p.post_id IN (?);";
        List<PostEvent> carAccidentPostEventList = jdbcTemplate.query(carAccidentPostEventQuery, postId.toArray(), new PostEventMapper());

        String naturalDisasterPostEventQuery =
                "SELECT *\n" +
                        "FROM Post p\n" +
                                "JOIN Event e ON e.event_id = p.event_id\n" +
                                        "JOIN NaturalDisaster nd ON nd.event_id = p.event_id\n" +
                                                "WHERE p.post_id IN (?);";
        List<PostEvent> naturalDisasterPostEventList = jdbcTemplate.query(naturalDisasterPostEventQuery,  postId.toArray(), new PostEventMapper());
        return Stream.of(crimePostEventList,carAccidentPostEventList,naturalDisasterPostEventList).flatMap(Collection::stream).collect(Collectors.toList());
    }

    @Override
    public Integer getTotalNumberOfPosts() {
        String readQuery =
                "SELECT COUNT(post_id)\n" +
                        "FROM Posts\n";
        Integer numPosts = jdbcTemplate.queryForObject(readQuery, Integer.class);
        return numPosts;
    }
}
