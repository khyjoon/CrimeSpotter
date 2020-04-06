package com.crimespotter.api.post.model.comment;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentMapper implements RowMapper<Comment> {
    @Override
    public Comment mapRow(ResultSet resultSet, int i) throws SQLException {
        Comment comment = new Comment();
        comment.setCommentId(resultSet.getString("comment_id"));
        comment.setUserId(resultSet.getString("user_id"));
        comment.setPostId(resultSet.getString("post_id"));
        comment.setContent(resultSet.getString("content"));
        comment.setCommentTime(resultSet.getTime("time"));
        return comment;
    }
}
