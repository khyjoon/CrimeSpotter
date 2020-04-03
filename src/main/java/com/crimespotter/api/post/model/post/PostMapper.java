package com.crimespotter.api.post.model.post;

import com.crimespotter.api.event.model.eventinfo.Event;
import com.crimespotter.api.event.model.eventinfo.EventMapper;
import com.crimespotter.api.event.model.locationinfo.Location;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostMapper implements RowMapper<Post> {
    @Override
    public Post mapRow(ResultSet resultSet, int i) throws SQLException {
        Post post = new Post();
        post.setPostId(resultSet.getString("post_id"));
        post.setEventId(resultSet.getString("event_id"));
        post.setUserId(resultSet.getString("user_id"));
        post.setPostTime(resultSet.getTime("post_time"));
        post.setActive(resultSet.getBoolean("isActive"));
        return post;
    }
}
