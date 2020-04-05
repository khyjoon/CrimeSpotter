# add users
INSERT INTO User (user_id, password, user_name, user_email, isBanned, isAdmin) VALUES (?,?,?,?,?,?);

INSERT INTO User(user_id, password, user_name, user_email, isBanned, isAdmin) VALUES

('d1de76c2-bbc5-41ce-8eb0-416743415a8c','1a92asb', 'Henry Tang','henryt@hotmail.com', 0, 0),
('c89215b2-7b1c-449a-969b-0751e3c92ba3','12345','Sal','hello@yahoo.com', 0, 0),
('21b6f6c3-9c98-4ddf-8598-d7b75fc4fe20','1928301abc','citizentoday','mwest@hotmail.com', 0, 0),
('121f8dd8-cbf8-47b8-a7fc-7cbe7401bcd0','1234567','kim','kim@hotmail.com', 0, 0),
('0beb8b97-3118-49bc-a26d-ca729d8456c6','12345hs', 'everyday','marky@gmail.com', 0, 0),
('08d9b98f-aa0d-49e7-bb98-9953b197f71c','111222333', 'everydayme','markymark@gmail.com', 0, 0),
('4e7f1bed-5bfa-4359-b2ad-114e63d2a761','pass234','Katy Lee','kbe@gmail.com',0,1),
('6aacda6f-4684-4fca-ae97-1e72d0e5e334','1234','Bob','yahoo', 0, 0),
('4a662bcb-16b1-4196-a510-a23cf50f8ee4','password123','Bob Lee','bob@gmail.com', 0, 1),
('8ebca006-9a8d-45e5-9bbe-a8d45400bff6','kimpeter','peter','kimpeter@hotmail.com', 0, 0),
('3ea3142d-b749-4c1e-9eb4-d838828419fd','goldentime','spambot','beepboop@gmail.com',1,0),
('05117b70-09dd-4702-b268-6873afe864ca','55555','test2','test2@test2.com', 0, 1);

#add community
INSERT INTO Community (c_name) VALUES (?);

INSERT INTO Community (c_name) VALUES
 ('Vancouver'),
 ('Calgary'),
 ('Edmonton'),
 ('Toronto',
 ('Montreal');

#add users to communities
INSERT INTO UserCommunity (user_id, c_id) VALUES (?,?);

INSERT INTO UserCommunity (user_id, c_id) VALUES
 ('4a662bcb-16b1-4196-a510-a23cf50f8ee4',1),
 ('08d9b98f-aa0d-49e7-bb98-9953b197f71c',2),
 ('4e7f1bed-5bfa-4359-b2ad-114e63d2a761',3),
 ('0beb8b97-3118-49bc-a26d-ca729d8456c6',4),
 ('d1de76c2-bbc5-41ce-8eb0-416743415a8c',5);


#post


#add posts
INSERT INTO Post (post_id, user_id, event_id, post_time, isActive) VALUES (?,?,?,CURRENT_TIME,?);

INSERT INTO Post (post_id, user_id, event_id, post_time, isActive) VALUES
('e57eda22-e733-4d13-86a9-3c643e744f14','4a662bcb-16b1-4196-a510-a23cf50f8ee4','45424d99-60af-4356-8e04-fc93cbef7a24',CURRENT_TIME,1),         #caraccident
('02d7d5d0-7f8f-48b5-9352-f425be72afcd','d1de76c2-bbc5-41ce-8eb0-416743415a8c','8fb2d08d-a53c-4f40-b4b4-39851b59d69c',CURRENT_TIME,1),
('cad5d975-0cf6-4fc8-9d6c-e446bcb391a8','c89215b2-7b1c-449a-969b-0751e3c92ba3','5f95f12b-d537-4f92-9a8a-d8e46948d11a',CURRENT_TIME,1),
('6ed07128-637f-4a9b-966b-903a21c57d1c','21b6f6c3-9c98-4ddf-8598-d7b75fc4fe20','5f28e001-221f-46d1-8d53-a9794cc0b90d',CURRENT_TIME,1),
('1d475d45-fca2-489d-a015-b56f7999ac37','121f8dd8-cbf8-47b8-a7fc-7cbe7401bcd0','0c521d91-5eee-435e-abce-9d477bf29795',CURRENT_TIME,1),

('39ff0551-c6c9-46d6-baad-a5bf0c9089af','3ea3142d-b749-4c1e-9eb4-d838828419fd','0763a291-dba5-4725-ab95-653316da1bec',CURRENT_TIME,1),        #crime
('2de2fc9b-ff26-4663-8b84-506887d75d5d','0beb8b97-3118-49bc-a26d-ca729d8456c6','51a454eb-49d0-4ba0-9c1d-18cf48e907ae',CURRENT_TIME,1),
('6bf8457e-9596-4314-84fd-bd9e94aed5c0','08d9b98f-aa0d-49e7-bb98-9953b197f71c','3e129336-1eba-46cd-ad74-6593439361c3',CURRENT_TIME,1),
('8315e639-b6db-4759-bfd7-babcda0eec51','4e7f1bed-5bfa-4359-b2ad-114e63d2a761','395a75f0-3f39-4b9c-8ad2-e9ce8797c073',CURRENT_TIME,1),
('43344354-eeda-44ca-bcde-2c7feb53e0e6','6aacda6f-4684-4fca-ae97-1e72d0e5e334','e97b37bd-5081-4b2f-b10e-553938eb3fc9',CURRENT_TIME,1),

('6f57feed-09b9-49a3-83f4-1ca813847827','8ebca006-9a8d-45e5-9bbe-a8d45400bff6','a05c07f5-9659-478d-965c-2074d1892f0e',CURRENT_TIME,1),
('c0671449-b536-406d-9c4d-4d161425dee4','4a662bcb-16b1-4196-a510-a23cf50f8ee4','7b40ebac-7e93-40d9-bc6f-ee74347742f8',CURRENT_TIME,1),
('29e987df-6dd7-4154-944b-92ebbb5a9aec','4e7f1bed-5bfa-4359-b2ad-114e63d2a761','509fc28b-0690-4f16-ad66-e0c5e579bcb4',CURRENT_TIME,1),
('85ed9352-0766-4c73-9b89-596d34012939','4e7f1bed-5bfa-4359-b2ad-114e63d2a761','dac21682-6b40-46fe-8acd-1b776ba0d74b',CURRENT_TIME,1),
('35580337-3791-4197-a1d5-02dec4e048ab','121f8dd8-cbf8-47b8-a7fc-7cbe7401bcd0','282ce9fe-ed7d-46f0-8b58-280367e0e95f',CURRENT_TIME,1); #natural disaster


#add comments on posts
INSERT INTO UserPostComment (comment_id, user_id, post_id, content, time) VALUES (?,?,?,?,CURRENT_TIME);
INSERT INTO UserPostComment (comment_id, user_id, post_id, content, time) VALUES
('b14b3667-8b59-467f-aee0-311e65f6666f','d1de76c2-bbc5-41ce-8eb0-416743415a8c','e57eda22-e733-4d13-86a9-3c643e744f14','I cannot believe this happened here',CURRENT_TIME),
('2f431502-87d6-4210-9bb1-c37dcf15f694','4a662bcb-16b1-4196-a510-a23cf50f8ee4','ae06c713-f497-4b19-a2c1-5c7ba42ce194','Thank you users for supporting',CURRENT_TIME),
('36290475-a94d-4f64-934d-fb04ea4f5703','08d9b98f-aa0d-49e7-bb98-9953b197f71c','39ff0551-c6c9-46d6-baad-a5bf0c9089af','What is this',CURRENT_TIME),
('48048f6f-11a8-4421-946d-f78dfdaeab7b','4e7f1bed-5bfa-4359-b2ad-114e63d2a761','39ff0551-c6c9-46d6-baad-a5bf0c9089af','It is a car accident',CURRENT_TIME),
('17ecdd99-3d82-4354-806e-e2d0c69051db','0beb8b97-3118-49bc-a26d-ca729d8456c6','7c0ce50c-26f4-455c-bf4a-5cd07d158939','Hello I am new',CURRENT_TIME);



#Event

#add location
INSERT INTO Location (location_id, latitude, longitude) VALUES (?,?,?);

INSERT INTO Location (location_id, latitude, longitude) VALUES
('228bf32b-2740-43f8-9a74-5b4f40e020e9',49.266513,-123.245298),
('0e6466fd-8054-45b7-8cb2-208ac4055411',49.283234,-123.131279),
('ea9e56b1-e7c8-4bf3-a9f5-561f18fe7f34',49.170187,-123.139630),
('ac7ce33f-2696-4c2d-a22c-aa5620fa0125',49.245614,-122.975034),
('90069077-2dab-4473-a440-927f35ab49ef',49.191667,-122.842381);

#add coordinates
INSERT INTO Coordinates (latitude, longitude, location_name) VALUES (?,?,?);

INSERT INTO Coordinates (latitude, longitude, location_name) VALUES
(49.266513,-123.245298,'5885 University Blvd, Vancouver, BC'),
(49.283234,-123.131279,'1205 Comox Street,Vancouver, BC'),
(49.170187,-123.139630,'7771-7631 WestminsterHwy, Richmond, BC'),
(49.245614,-122.975034,'4925-4939 Canada Way,Burnaby, BC V5G 1M1'),
(49.191667,-122.842381,'104 Ave, Surrey, BC');

#add events
INSERT INTO Event (event_id, location_id, c_id, time, title, severity, caused_injury) VALUES (?,?,?,CURRENT_TIME,?,?,?);

INSERT INTO Event (event_id, location_id, c_id, time, title, severity, caused_injury) VALUES
('45424d99-60af-4356-8e04-fc93cbef7a24','228bf32b-2740-43f8-9a74-5b4f40e020e9',1,CURRENT_TIME,'Car Accident in Vancouver',6,1),
('5f95f12b-d537-4f92-9a8a-d8e46948d11a','90069077-2dab-4473-a440-927f35ab49ef',5,CURRENT_TIME,'Car Accident in Montreal',10,1),
('8fb2d08d-a53c-4f40-b4b4-39851b59d69c','90069077-2dab-4473-a440-927f35ab49ef',2,CURRENT_TIME,'Car accident in Calgary',2,1),
('5f28e001-221f-46d1-8d53-a9794cc0b90d','228bf32b-2740-43f8-9a74-5b4f40e020e9',6,CURRENT_TIME,'Car accident in Saskatoon',2,1),
('0c521d91-5eee-435e-abce-9d477bf29795','90069077-2dab-4473-a440-927f35ab49ef',3,CURRENT_TIME,'Car accident in Edmonton',2,1),

('0763a291-dba5-4725-ab95-653316da1bec','0e6466fd-8054-45b7-8cb2-208ac4055411',2,CURRENT_TIME,'The theft stole the food',2,1),
('51a454eb-49d0-4ba0-9c1d-18cf48e907ae','ac7ce33f-2696-4c2d-a22c-aa5620fa0125',4,CURRENT_TIME,'Suicide',8,1),
('3e129336-1eba-46cd-ad74-6593439361c3','90069077-2dab-4473-a440-927f35ab49ef',5,CURRENT_TIME,'Homicide in the building',10,1),
('395a75f0-3f39-4b9c-8ad2-e9ce8797c073','ea9e56b1-e7c8-4bf3-a9f5-561f18fe7f34',3,CURRENT_TIME,'Hit_and_Run accident',2,1),
('e97b37bd-5081-4b2f-b10e-553938eb3fc9','228bf32b-2740-43f8-9a74-5b4f40e020e9',2,CURRENT_TIME,'Found the victims in the park',6,1),

('282ce9fe-ed7d-46f0-8b58-280367e0e95f','ea9e56b1-e7c8-4bf3-a9f5-561f18fe7f34',3,CURRENT_TIME,'Earthquakes in Metro',4,1),
('dac21682-6b40-46fe-8acd-1b776ba0d74b','228bf32b-2740-43f8-9a74-5b4f40e020e9',4,CURRENT_TIME,'Heavy SnowFall',2,1),
('509fc28b-0690-4f16-ad66-e0c5e579bcb4','ea9e56b1-e7c8-4bf3-a9f5-561f18fe7f34',2,CURRENT_TIME,'Heavy SnowFall',4,1),
('7b40ebac-7e93-40d9-bc6f-ee74347742f8','ac7ce33f-2696-4c2d-a22c-aa5620fa0125',6,CURRENT_TIME,'Hails',8,1),
('a05c07f5-9659-478d-965c-2074d1892f0e','90069077-2dab-4473-a440-927f35ab49ef',5,CURRENT_TIME,'Heavy Rain',2,1);


#add crimes
INSERT INTO Crime (event_id, suspect_description, crime_type) VALUES (?,?,?);

INSERT INTO Crime (event_id, suspect_description, crime_type) VALUES
 ('0763a291-dba5-4725-ab95-653316da1bec','The theft stole the food from the store','Theft'),
 ('3e129336-1eba-46cd-ad74-6593439361c3','Stranger got into the building and I heard the scream','Homicide'),
 ('51a454eb-49d0-4ba0-9c1d-18cf48e907ae','Found in her house','Suicide'),
 ('395a75f0-3f39-4b9c-8ad2-e9ce8797c073','The car type was Toyata and it was black color','hit and run'),
 ('e97b37bd-5081-4b2f-b10e-553938eb3fc9','Found the victims in the park', 'Sex offences');

#add natural disaster
INSERT INTO NaturalDisaster (event_id, type, magnitude) VALUES (?,?,?);

INSERT INTO NaturalDisaster (event_id, type, magnitude) VALUES
('282ce9fe-ed7d-46f0-8b58-280367e0e95f','Earthquakes',4),
('dac21682-6b40-46fe-8acd-1b776ba0d74b','Heavy Snowfall',3),
('509fc28b-0690-4f16-ad66-e0c5e579bcb4','Heavy Snowfall',3),
('7b40ebac-7e93-40d9-bc6f-ee74347742f8','Hails',3),
('a05c07f5-9659-478d-965c-2074d1892f0e','Heavy Rains',2);

#add car accident
INSERT INTO CarAccident (event_id, collision_type, pedestrians_involved) VALUES (?,?,?);

INSERT INTO CarAccident (event_id, collision_type, pedestrians_involved) VALUES
('45424d99-60af-4356-8e04-fc93cbef7a24','Rear ended',2),
('8fb2d08d-a53c-4f40-b4b4-39851b59d69c','Frontal',3),
('5f28e001-221f-46d1-8d53-a9794cc0b90d','T-boned',5),
('0c521d91-5eee-435e-abce-9d477bf29795','Frontal',2),
('5f95f12b-d537-4f92-9a8a-d8e46948d11a','Rear ended',6);

#add car details
INSERT INTO CarDetails (event_id, license, make, model, colour) VALUES (?,?,?,?,?);

INSERT INTO CarDetails (event_id, license, make, model, colour) VALUES
('45424d99-60af-4356-8e04-fc93cbef7a24','V4N033','Toyota','Camry','Red'),
('8fb2d08d-a53c-4f40-b4b4-39851b59d69c','RDS37D','Kia','Optima','Grey'),
('5f28e001-221f-46d1-8d53-a9794cc0b90d','Y178S0','Honda','Civic','Blue'),
('0c521d91-5eee-435e-abce-9d477bf29795','Z102JU','Honda','Civic','Green'),
('5f95f12b-d537-4f92-9a8a-d8e46948d11a','MAX292','Hyundai','Sante Fe','Black');