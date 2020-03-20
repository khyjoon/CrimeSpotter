package com.crimespotter.api.user.model.community;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommunityMapper implements RowMapper<Community> {
    @Override
    public Community mapRow(ResultSet resultSet, int i) throws SQLException {
        Community community = new Community();
        community.setCommunityId(resultSet.getInt("c_id"));
        community.setName(resultSet.getString("c_name"));
        return community;
    }
}
