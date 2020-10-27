create database twitterclone;

use databse twitterclone;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `firstname` varchar(100) DEFAULT NULL,
  `lastname` varchar(100) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `creator` varchar(255) DEFAULT NULL,
  `creator_id` int(11) DEFAULT NULL,
  `last_modifier` varchar(255) DEFAULT NULL,
  `last_modifier_id` int(11) DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

CREATE TABLE `posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `post_content` varchar(140) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `creator` varchar(255) DEFAULT NULL,
  `creator_id` int(11) DEFAULT NULL,
  `last_modifier` varchar(255) DEFAULT NULL,
  `last_modifier_id` int(11) DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

CREATE TABLE `user_posts` (
  `id` int(11) NOT NULL,
  `post_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3idbfqdilj0glnid701fbbjp8` (`post_id`),
  KEY `FK9spao74qxqjkns4i8h2r0kpnj` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

CREATE TABLE `followers` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `following_to` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `created_time` datetime DEFAULT NULL,
  `creator` varchar(255) DEFAULT NULL,
  `creator_id` int(11) DEFAULT NULL,
  `last_modifier` varchar(255) DEFAULT NULL,
  `last_modifier_id` int(11) DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgkc1tiik38roa4ymkuief5h9u` (`following_to`),
  KEY `FKndvqwh40g1qt4xirl6vp2d6m6` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE `posts_activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` datetime DEFAULT NULL,
  `creator` varchar(255) DEFAULT NULL,
  `creator_id` int(11) DEFAULT NULL,
  `last_modifier` varchar(255) DEFAULT NULL,
  `last_modifier_id` int(11) DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  `like_dislike_status` int(11) DEFAULT NULL,
  `post_id` int(11) DEFAULT NULL,
  `who_id` int(11) DEFAULT NULL,
  `whose_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrmqclwhgm0eqflf5f3rqefhv1` (`post_id`),
  KEY `FKjahraw7clftep4i6vc7077dlv` (`who_id`),
  KEY `FK3lgxiq58ts5il73s38ta4cmlp` (`whose_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
