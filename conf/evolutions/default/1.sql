CREATE TABLE `post`
(
    `id`         int(11)      NOT NULL AUTO_INCREMENT,
    `title`      varchar(255) NOT NULL,
    `content`    text         NOT NULL,
    `created_at` datetime     DEFAULT CURRENT_TIMESTAMP,
    `user_email` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `fk_user_email_idx` (`user_email`),
    CONSTRAINT `fk_user_email` FOREIGN KEY (`user_email`) REFERENCES `user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE
)