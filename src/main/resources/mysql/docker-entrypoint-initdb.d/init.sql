drop database if exists `choistory`;
create database if not exists `choistory` character set = 'utf8mb4' collate = utf8mb4_general_ci;
use `choistory`;
create table if not exists `TB_USER` (
	`id` varchar(36) not null primary key,
	`username` varchar(30) not null,
	`password` varchar(100) not null,
	`nickname` varchar(30) not null,
	`email` varchar(50) not null,
	`email_check` boolean not null default false,
	`profile_img` varchar(100),
	`bio` varchar(100),
	`status` char(1) not null default 1,
	`created_at` datetime default now(),
    `updated_at` datetime default null,
	`deleted_at` datetime default null
);
create table if not exists `TB_FOLLOW` (
	`follower` varchar(36) not null,
	`followee` varchar(36) not null,
	constraint `TB_FOLLOW_PRIMARY_KEY` primary key (`follower`, `followee`),
	constraint `TB_FOLLOW_FOREIGN_KEY_01` foreign key (`follower`) references `TB_USER` (`id`),
	constraint `TB_FOLLOW_FOREIGN_KEY_02` foreign key (`followee`) references `TB_USER` (`id`),
	constraint `TB_FOLLOW_UNIQUE_KEY` unique (`followee`, `follower`)
);
create table if not exists `TB_COMMENT` (
	`id` varchar(36) not null primary key,
	`parent` varchar(36) default null,
	`content` varchar(200) not null,
	`user_id` varchar(36) not null,
	`created_at` datetime default now(),
	`duration` int(10) default 0,
	`expire_at` datetime default null,
	`deleted_at` datetime default null,
	constraint `TB_COMMENT_FOREIGN_KEY_01` foreign key (`parent`) references `TB_COMMENT` (`id`),
	constraint `TB_COMMENT_FOREIGN_KEY_02` foreign key (`user_id`) references `TB_USER` (`id`)
);
create table if not exists `TB_IMAGE` (
	`id` varchar(36) not null primary key,
	`comment_id` varchar(36) not null,
	`path` varchar(200) not null,
	`filename` varchar(100) not null,
	`alt` varchar(100) default null,
	constraint `TB_IMAGE_FOREIGN_KEY_01` foreign key (`comment_id`) references `TB_COMMENT` (`id`)
);

# CHANGE REPLICATION SOURCE TO SOURCE_HOST='172.17.0.2',
#     SOURCE_USER='root',
#     SOURCE_PASSWORD='1234',
#     SOURCE_LOG_FILE='mysql-bin.000004',
#     SOURCE_LOG_POS=758;