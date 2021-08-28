CREATE TABLE `book` (
  `id` INT(10) AUTO_INCREMENT PRIMARY KEY,
  `author` longtext NOT NULL,
  `launch_date` datetime NOT NULL,
  `price` decimal(65,2) NOT NULL,
  `title` longtext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
