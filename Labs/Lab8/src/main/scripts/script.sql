drop table if exists albums;
drop table if exists artist;


CREATE TABLE IF NOT EXISTS artist(
  id INT NOT NULL PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS  albums (
  id INT NOT NULL PRIMARY KEY,
  release_year VARCHAR(255) NOT NULL,
  title VARCHAR(255) NOT NULL,
  artistID INT NOT NULL,
  FOREIGN KEY (artistID) REFERENCES artist(id)
);

