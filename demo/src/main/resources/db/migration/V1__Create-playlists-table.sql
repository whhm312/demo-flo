--
-- V2: Create Playlists TABLE
--
--
CREATE TABLE playlists (
  id int NOT NULL AUTO_INCREMENT,
  user_id varchar(100) NOT NULL,
  title varchar(600) NOT NULL,
  created_date datetime DEFAULT NULL,
  PRIMARY KEY (id)
) DEFAULT CHARSET=utf8mb4;
