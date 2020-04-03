package com.crimespotter.api.post.model.post;

import com.crimespotter.api.event.model.eventinfo.Event;
import com.crimespotter.api.event.model.eventinfo.EventMapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostEventMapper implements RowMapper<PostEvent> {

    @Override
    public PostEvent mapRow(ResultSet resultSet, int i) throws SQLException {
        PostEvent postEvent;
        if (resultSet.getString("suspect_description") == null) {
            postEvent = new PostCrimeEvent();
            ((PostCrimeEvent) postEvent).setSuspectDesription(resultSet.getString("suspect_description"));
            ((PostCrimeEvent) postEvent).setCrimeType(resultSet.getString("crime_type"));
        } else if (resultSet.getString("magnitude") == null) {
            postEvent = new PostNaturalDisasterEvent();
            ((PostNaturalDisasterEvent) postEvent).setType(resultSet.getString("type"));
            ((PostNaturalDisasterEvent) postEvent).setMagnitude(resultSet.getInt("magnitude"));
        } else {
            postEvent = new PostCarAccidentEvent();
            ((PostCarAccidentEvent) postEvent).setCollisionType(resultSet.getString("collision_type"));
            ((PostCarAccidentEvent) postEvent).setPedestriansInvolved(resultSet.getInt("pedestrians_involved"));
        }
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

        return postEvent;
    }
}
