CREATE TABLE blog
(
  uuid   CHAR(20),
  title VARCHAR(100),
  createdBy VARCHAR(40),
  createdAt DATETIME,
  blogStatus VARCHAR(20) 
);
CREATE TABLE post
(
  uuid   CHAR(20),
  blogUUID CHAR(20),
  title VARCHAR(100),
  header VARCHAR(400),
  content VARCHAR(4000),
  tags VARCHAR(200),
  categories VARCHAR(200),
  createdBy VARCHAR(40),
  createdAt DATETIME,
  postStatus VARCHAR(20) 
);
