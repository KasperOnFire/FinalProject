CREATE TABLE `collection`.`music` (
  `identifier` VARCHAR(255) unique NOT NULL,
  `UID` int(255) NOT NULL,
  `artist` VARCHAR(255) NULL,
  `album` VARCHAR(255) NULL
  );