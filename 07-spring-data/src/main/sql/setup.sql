use bookstore;

DROP TABLE IF EXISTS `books`;

CREATE TABLE `books` (
  `isbn` varchar(45) NOT NULL,
  `author` varchar(45) DEFAULT NULL,
  `title` varchar(45) NOT NULL,
  `price` decimal(2,0) DEFAULT NULL,
  `publisher` varchar(45) DEFAULT 'Techno Books Ltd.',
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `books` VALUES ('1','John Smith','Java Overview',13,'Techno Books Ltd.'),
('2','Jasmine Andrews','Java Unleashed',12,'Techno Books Ltd.'),
('3','Adam Jones','JQuery Today',14,'Wizzo Publishers'),
('4','Denise Byrne','JavaScript Live',15,'Techno Books Ltd.'),
('5','Phoebe Richmond','Python',26,'Wizzo Publishers'),
('6','Gryff Pritchard','Kotlin Introduction',13,'Techno Books Ltd.');
