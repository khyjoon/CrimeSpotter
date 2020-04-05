#Users (selection and projection)
SELECT *
FROM User
WHERE user_id = <"user_id">

#get all users (selection and projection)
SELECT *
FROM User
ORDER BY user_id DESC;

#get user by user password (selection and projection)
SELECT *
FROM User
WHERE user_name = <"user_name"> AND password = <"password">;
_

#get user by user id (selection and projection)
SELECT *
FROM User
WHERE user_id = <"user_id">;

#get user by user name (selection and projection)
SELECT *
FROM User
WHERE user_name = <"user_name">;

#get all communities (selection and projection)
SELECT *
FROM Community
ORDER BY c_id ASC;

#Post

#get comment by Id (selection and projection)
SELECT comment_id
FROM UserPostComment
WHERE comment_id = <"community_id">;

#get all posts
SELECT post_id
FROM Post;

#get post info by user Id (selection and projection)
SELECT post_id
FROM Post
WHERE user_id = <"user_id">;

#get post info by post Id (crime post event) (Join)
SELECT *
FROM Post p
JOIN Event e ON e.event_id = p.event_id
JOIN Crime c ON c.event_id = p.event_id
WHERE p.post_id IN <"post_id">;

#get post info by post Id(car accident event) (Join)
SELECT *
FROM Post p
JOIN Event e ON e.event_id = p.event_id
JOIN CarAccident ca ON ca.event_id = p.event_id
WHERE p.post_id IN <"post_id">;

#get post info by post Id(natural disaster) (Join)
SELECT *
FROM Post p
JOIN Event e ON e.event_id = p.event_id
JOIN NaturalDisaster nd ON nd.event_id = p.event_id
WHERE p.post_id IN <"post_id">;

#get total number of posts (Aggregation)
SELECT COUNT(post_id)
FROM Post;

#get total posts in each community (Nested Aggregation)
SELECT COUNT(post_id) as total_posts, c.c_name
FROM Post p
JOIN Event e ON p.event_id = e.event_id
JOIN Community c ON c.c_id = e.c_id
GROUP BY c.c_name
ORDER BY COUNT(post_id) DESC;

#Events

#get location by Location_Id
SELECT *
FROM Location
WHERE location_id = <"location_id">;

#car accident events
SELECT *
FROM Event e
JOIN CarAccident ca ON ca.event_id = e.event_id
WHERE e.event_id IN <"event_id">;

#crime events
SELECT *
FROM Event e
JOIN Crime c ON c.event_id = e.event_id
WHERE e.event_id IN <"event_id">;

#natural disaster events
SELECT *
FROM Event e
JOIN NaturalDisaster nd ON nd.event_id = e.event_id
WHERE e.event_id IN <"event_id">;

#get events by community Id
SELECT event_id
FROM Event e
WHERE e.c_id = <"c_id">;





