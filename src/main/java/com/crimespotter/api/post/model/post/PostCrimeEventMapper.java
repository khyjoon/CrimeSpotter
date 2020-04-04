package com.crimespotter.api.post.model.post;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostCrimeEventMapper extends PostEventMapper {

    @Override
    public PostCrimeEvent mapRow(ResultSet resultSet, int i) throws SQLException {
        PostCrimeEvent postEvent = new PostCrimeEvent();
        postEvent.setEventType("crime");
        postEvent.setPostId(resultSet.getString("post_id"));
        postEvent.setEventId(resultSet.getString("event_id"));
        postEvent.setUserId(resultSet.getString("user_id"));
        postEvent.setPostTime(resultSet.getTime("post_time"));
        postEvent.setActive(resultSet.getBoolean("isActive"));
        postEvent.setLocationId(resultSet.getString("location_id"));
        postEvent.setCommunityId(resultSet.getInt("c_id"));
        postEvent.setTime(resultSet.getTime("time"));
        postEvent.setTitle(resultSet.getString("title"));
        postEvent.setSeverity(resultSet.getInt("severity"));
        postEvent.setCausedInjury(resultSet.getBoolean("caused_injury"));
        postEvent.setSuspectDesription(resultSet.getString("suspect_description"));
        postEvent.setCrimeType(resultSet.getString("crime_type"));
        return postEvent;
    }
}
