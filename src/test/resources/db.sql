# Add User Table
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
COMMENT = 'save user info';

INSERT INTO `user` (`id`, `username`, `password`, `phone`, `email`) 
VALUES ('1', 'chen', '1234', '13646514654', 'chenpeiyuan1987@163.com');