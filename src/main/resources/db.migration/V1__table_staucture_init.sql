DROP TABLE IF EXISTS `client_data`;
CREATE TABLE `client_data_id` (
  `client_data_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client_id` varchar(50) NOT NULL COMMENT '',
  `resource_ids` varchar(255) DEFAULT NULL COMMENT '',
  `secret_required` tinyint(1) DEFAULT NULL COMMENT '',
  `client_secret` varchar(255) DEFAULT NULL COMMENT '',
  `authorized_grant_types` varchar(255) DEFAULT NULL COMMENT '',
  `registered_redirect_uri` varchar(255) DEFAULT NULL COMMENT '',
  `access_token_validity_seconds` int(11) NOT NULL COMMENT '',
  `refresh_token_validity_seconds` int(11) DEFAULT NULL COMMENT '',
  `authorities` varchar(255) DEFAULT NULL COMMENT '',

  `created_at` datetime NOT NULL,
  `modified_at` datetime NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `company_id` bigint(20) NOT NULL,
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`claim_data_id`),
  UNIQUE KEY `claim_data_uk_1` (`claim_id`),
  INDEX `claim_data_fk_1` (`expert_data_id`),
  INDEX `claim_data_fk_2` (`project_data_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `user_data`;
CREATE TABLE `user_data_id` (
  `user_data_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '',
  `password` varchar(255) DEFAULT NULL COMMENT '',
  `account_non_expired` tinyint(1) DEFAULT NULL COMMENT '',
  `account_non_locked` tinyint(1) DEFAULT NULL COMMENT '',
  `credentials_non_expired` tinyint(1) DEFAULT NULL COMMENT '',
  `authorities` varchar(255) DEFAULT NULL COMMENT '',

  `created_at` datetime NOT NULL,
  `modified_at` datetime NOT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `company_id` bigint(20) NOT NULL,
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`claim_data_id`),
  UNIQUE KEY `claim_data_uk_1` (`claim_id`),
  INDEX `claim_data_fk_1` (`expert_data_id`),
  INDEX `claim_data_fk_2` (`project_data_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;