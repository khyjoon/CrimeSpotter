package com.crimespotter.api.post.model.post;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostCommunityMapper implements RowMapper<PostCommunity> {
    @Override
    public PostCommunity mapRow(ResultSet resultSet, int i) throws SQLException {
        PostCommunity post = new PostCommunity();
        post.setCommunityName(resultSet.getString("c_name"));
        post.setTotalPosts(resultSet.getInt("total_posts"));
        return post;
    }
}
