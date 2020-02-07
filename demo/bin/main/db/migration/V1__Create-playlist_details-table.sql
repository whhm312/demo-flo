--
-- V2: Create Playlist Details TABLE
--
--
CREATE TABLE playlist_details (
  id INT NOT NULL AUTO_INCREMENT,
  playlist_id INT NOT NULL,
  album_id INT NULL,
  song_id INT NULL,
  register_date DATETIME NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE
) DEFAULT CHARACTER SET = utf8mb4;