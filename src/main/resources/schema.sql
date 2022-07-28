DROP TABLE IF EXISTS `metadata` ;
CREATE TABLE `metadata` (
                         `id` bigint(20) NOT NULL AUTO_INCREMENT,
                         `song_name` varchar(100) NOT NULL,
                         `artist` varchar(50) ,
                         `album` varchar(50) ,
                         `length` varchar(10) NOT NULL,
                         `resource_id` bigint(20) NOT NULL,
                         `year` bigint(4) ,
                          PRIMARY KEY (`id`));
