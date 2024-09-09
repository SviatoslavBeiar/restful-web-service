-- insert into user_details(id,birth_date,name)
-- values(10001,current_date(),'Valera');
-- insert into user_details(id,birth_date,name)
-- values(10002,current_date(),'Vasiy');
-- insert into user_details(id,birth_date,name)
-- values(10003,current_date(),'LOh');
-- insert into user_details(id,birth_date,name)
-- values(10004,current_date(),'ищищи');
--
-- insert into post(id, description, user_id)
--  values(20001, 'I want to learn AWS', 10001);
-- insert into post(id, description, user_id)
--  values(20002, 'I want to learn pornhub', 10001);
--  insert into post(id, description, user_id)
--   values(20003, 'I want to learn dede', 10002);
--  insert into post(id, description, user_id)
--   values(20004, 'I want to learn cdcdd', 10002);
--
--
-- Insert data into the user_details table
INSERT INTO user_details (id, birth_date, name)
VALUES
    (10001, CURRENT_DATE, 'Valera'),
    (10002, CURRENT_DATE, 'Vasiy'),
    (10003, CURRENT_DATE, 'LOh'),
    (10004, CURRENT_DATE, 'ищищи');

-- Insert data into the post table
INSERT INTO post (id, description, user_id)
VALUES
    (20001, 'I want to learn AWS', 10001),
    (20002, 'I want to learn pornhub', 10001),
    (20003, 'I want to learn dede', 10002),
    (20004, 'I want to learn cdcdd', 10002);
