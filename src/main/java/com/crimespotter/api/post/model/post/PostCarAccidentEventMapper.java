package com.crimespotter.api.post.model.post;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostCarAccidentEventMapper extends PostEventMapper {
    @Override
    public PostCarAccidentEvent mapRow(ResultSet resultSet, int i) throws SQLException {
        PostCarAccidentEvent postEvent = new PostCarAccidentEvent();
        postEvent.setEventType("car_accident");
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
        postEvent.setCollisionType(resultSet.getString("collision_type"));
        postEvent.setPedestriansInvolved(resultSet.getInt("pedestrians_involved"));
        return postEvent;
    }
}
