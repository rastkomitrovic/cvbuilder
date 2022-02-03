drop table cvsectionsectionfield;
drop table cvsection;
drop table cv;
drop table templatesection;
drop table sectionsectionfield;
drop table template;
drop table users;
drop table role;
drop table section;
drop table sectionfield;
drop table sectionfieldtype;

/*DDL*/

CREATE TABLE `role` (
                        `id` bigint(20) NOT NULL AUTO_INCREMENT,
                        `name` varchar(255) NOT NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into role(name) values('SUPER_ADMIN');
insert into role(name) values('ADMIN');
insert into role(name) values('USER');


CREATE TABLE `users` (
                         `id` bigint(20) NOT NULL AUTO_INCREMENT,
                         `username` varchar(255) NOT NULL,
                         `password` varchar(255) NOT NULL,
                         `first_name` varchar(255) NOT NULL,
                         `last_name` varchar(255) NOT NULL,
                         `email` varchar(255) NOT NULL,
                         `index_number` varchar(255) NOT NULL,
                         `activated` tinyint(1) NOT NULL,
                         `role_id` bigint(20) NOT NULL,
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `UNIQUE` (`username`),
                         UNIQUE KEY `UNIQUE` (`email`),
                         UNIQUE KEY `UNIQUE` (`index_number`),
                         KEY `fk_users_role` (`role_id`),
                         CONSTRAINT `fk_user_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `sectionfieldtype` (
                        `id` bigint(20) NOT NULL AUTO_INCREMENT,
                        `name` varchar(255) NOT NULL,
                        `description` varchar(255) NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `sectionfield` (
                                    `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                    `name` varchar(255) NOT NULL,
                                    `description` varchar(255) NULL,
                                    `section_field_type_id` bigint(20) NOT NULL,
                                    PRIMARY KEY (`id`),
                                    UNIQUE KEY `UNIQUE` (`name`),
                                    KEY `fk_sectionfield_sectionfieldtype` (`section_field_type_id`),
                                    CONSTRAINT `fk_sectionfield_sectionfieldtype` FOREIGN KEY (`section_field_type_id`) REFERENCES `sectionfieldtype` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `section` (
                                    `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                    `name` varchar(255) NOT NULL,
                                    `description` varchar(255) NULL,
                                    PRIMARY KEY (`id`),
                                    UNIQUE KEY `UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `sectionsectionfield` (
                                `section_id` bigint(20) NOT NULL,
                                `section_field_id` bigint(20) NOT NULL,
                                `order_number` int NOT NULL,
                                PRIMARY KEY (`section_id`, `section_field_id`),
                                KEY `fk_sectionsectionfield_section` (`section_id`),
                                KEY `fk_sectionsectionfield_sectionfield` (`section_field_id`),
                                CONSTRAINT `fk_sectionsectionfield_section` FOREIGN KEY (`section_id`) REFERENCES `section` (`id`) ON UPDATE CASCADE ON DELETE CASCADE ,
                                CONSTRAINT `fk_sectionsectionfield_sectionfield` FOREIGN KEY (`section_field_id`) REFERENCES `sectionfield` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `template` (
                                       `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                       `name` varchar(255) NOT NULL,
                                       `description` varchar(255) NULL,
                                       `private` tinyint(1) NOT NULL,
                                       `user_id` bigint(20) NOT NULL,
                                       PRIMARY KEY (`id`),
                                       KEY `fk_template_user` (`user_id`),
                                       CONSTRAINT `fk_template_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `templatesection` (
                                       `template_id` bigint(20) NOT NULL,
                                       `section_id` bigint(20) NOT NULL,
                                       `repeatable` tinyint(1) NOT NULL,
                                       PRIMARY KEY (`template_id`, `section_id`),
                                       KEY `fk_templatesection_template` (`template_id`),
                                       KEY `fk_templatesection_section` (`section_id`),
                                       CONSTRAINT `fk_templatesection_template` FOREIGN KEY (`template_id`) REFERENCES `template` (`id`) ON UPDATE CASCADE ON DELETE CASCADE,
                                       CONSTRAINT `fk_templatesection_section` FOREIGN KEY (`section_id`) REFERENCES `section` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `cv` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT,
                            `name` varchar(255) NOT NULL,
                            `description` varchar(255) NULL,
                            `date_created` datetime NOT NULL,
                            `date_edited` datetime NULL,
                            `template_id` bigint(20) NOT NULL,
                            `user_id` bigint(20) NOT NULL,
                            PRIMARY KEY (`id`),
                            KEY `fk_cv_user` (`user_id`),
                            CONSTRAINT `fk_cv_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `cvsection` (
                                   `cv_id` bigint(20) NOT NULL,
                                   `section_id` bigint(20) NOT NULL,
                                   `order_number` int NOT NULL,
                                   PRIMARY KEY (`cv_id`, `section_id`),
                                   KEY `fk_cvsection_cv` (`cv_id`),
                                   KEY `fk_cvsection_section` (`section_id`),
                                   CONSTRAINT `fk_cvsection_cv` FOREIGN KEY (`cv_id`) REFERENCES `cv` (`id`) ON UPDATE CASCADE ON DELETE CASCADE,
                                   CONSTRAINT `fk_cvsection_section` FOREIGN KEY (`section_id`) REFERENCES `section` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `cvsectionsectionfield` (
                             `cv_id` bigint(20) NOT NULL,
                             `section_id` bigint(20) NOT NULL,
                             `section_field_id` bigint(20) NOT NULL,
                             `order_number` int NOT NULL,
                             `string_value` varchar(10000) NOT NULL,
                             `number_value` bigint NOT NULL,
                             `double_value` double NOT NULL,
                             `date_value` datetime NOT NULL,
                             `blob_value` blob NOT NULL,
                             PRIMARY KEY (`cv_id`, `section_id`, `section_field_id`),
                             KEY `fk_cvsectionsectionfield_cvsection` (`cv_id`),
                             KEY `fk_cvsectionsectionfield_cvsection` (`section_id`),
                             KEY `fk_cvsectionsectionfield_sectionfield` (`section_field_id`),
                             CONSTRAINT `fk_cvsectionsectionfield_cvsection` FOREIGN KEY (`cv_id`) REFERENCES `cvsection` (`cv_id`) ON UPDATE CASCADE ON DELETE CASCADE,
                             CONSTRAINT `fk_cvsectionsectionfield_cvsection` FOREIGN KEY (`section_id`) REFERENCES `cvsection` (`section_id`) ON UPDATE CASCADE ON DELETE CASCADE ,
                             CONSTRAINT `fk_cvsectionsectionfield_sectionfield` FOREIGN KEY (`section_field_id`) REFERENCES `sectionfield` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;