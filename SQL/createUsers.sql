CREATE TABLE `collection`.`user` (
  `UID` int(255) auto_increment key,
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(255) NOT NULL,
  `salt` VARCHAR(45) NULL
  );