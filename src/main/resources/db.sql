CREATE DATABASE  IF NOT EXISTS 'vanhackchallenge';
USE 'vanhackchallenge';

--
-- Table structure for table 'position'
--

DROP TABLE IF EXISTS 'position';
CREATE TABLE 'position' (
  'id' int(11) unsigned NOT NULL AUTO_INCREMENT,
  'x' double(11) DEFAULT NULL,
  'y' double(11) DEFAULT NULL,
  PRIMARY KEY ('id')
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Table structure for table 'Restaurant'
--

DROP TABLE IF EXISTS 'restaurant';
CREATE TABLE 'restaurant' (
  'id' int(11) unsigned NOT NULL AUTO_INCREMENT,
  'name' varchar(255) DEFAULT NULL,
  'pos_id' double(11) unsigned DEFAULT NULL,
  PRIMARY KEY ('id'),
  KEY 'fk_restaurant_position' ('pos_id'),
  CONSTRAINT 'fk_restaurant_position' FOREIGN KEY ('pos_id') REFERENCES 'position' ('id') ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;