drop table if exists cvsectionsectionfield;
drop table if exists cvsection;
drop table if exists cv;
drop table if exists templatesection;
drop table if exists sectionsectionfield;
drop table if exists template;
drop table if exists users;
drop table if exists role;
drop table if exists section;
drop table if exists sectionfield;
drop table if exists sectionfieldtype;

/*DDL*/

CREATE TABLE `role` (
                        `id` bigint(20) NOT NULL AUTO_INCREMENT,
                        `name` varchar(255) NOT NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `UNIQUE_ROLE_NAME` (`name`)
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
                         UNIQUE KEY `UNIQUE_USER_USERNAME` (`username`),
                         UNIQUE KEY `UNIQUE_USER_EMAIL` (`email`),
                         UNIQUE KEY `UNIQUE_USER_INDEX_NUMBER` (`index_number`),
                         KEY `fk_users_role` (`role_id`),
                         CONSTRAINT `fk_user_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/* rastkomitrovic96 pass */
insert into users(username, password, first_name, last_name, email, index_number, activated, role_id) values ('rastko','$2a$12$CTHwiUMwN9.yc4th6ieXmeIkG0I4upyPjJcTW7Z.vS.YlLNINQOo.', 'Rastko', 'Mitrovic', 'rastkomitrovic@gmail.com','3718/21',1, (SELECT id from role where name='SUPER_ADMIN'));
/* peraperic96 pass */
insert into users(username, password, first_name, last_name, email, index_number, activated, role_id) values ('pera','$2a$12$/SbtE1zUh9XfSdaPWeOsT.tRwE6noOaHIyID/WnAwiM.HuZtVc/xy', 'Pera', 'Peric', 'peraperic@gmail.com','3719/21',1, (SELECT id from role where name='ADMIN'));
/* mikamikic96 pass */
insert into users(username, password, first_name, last_name, email, index_number, activated, role_id) values ('mika','$2a$12$olJQvQPSM6PoEPKBaoPoSOJDwluYeU6SJaCmZUdO1ADTlZzx/8Z8a', 'Mika', 'Mikic', 'mikamikic@gmail.com','3720/21',0, (SELECT id from role where name='USER'));
/* zikazikic96 pass */
insert into users(username, password, first_name, last_name, email, index_number, activated, role_id) values ('zika','$2a$12$XdmdTpxsw9sJOwv8fbuEWubjxwTmdmzU.m89En0ogt8PcHhvPiG/e', 'Zika', 'Zikic', 'zikazikic@gmail.com','3721/21',0, (SELECT id from role where name='ADMIN'));


CREATE TABLE `sectionfieldtype` (
                                    `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                    `name` varchar(255) NOT NULL,
                                    `key_value` varchar(255) NOT NULL,
                                    `description` varchar(255) NULL,
                                    PRIMARY KEY (`id`),
                                    UNIQUE KEY `UNIQUE_SECTIONFIELDTYPE_NAME` (`name`),
                                    UNIQUE KEY `UNIQUE_SECTIONFIELDTYPE_KEY` (`key_value`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into sectionfieldtype(name, key_value, description)  values ('Datum','DATE','Datum bez vremena');
insert into sectionfieldtype(name, key_value, description)  values ('Datum i vreme','DATE_TIME','Datum sa vremenom');
insert into sectionfieldtype(name, key_value, description)  values ('Kratak tekst','SHORT_TEXT','Kratko tekstualno polje');
insert into sectionfieldtype(name, key_value, description)  values ('Dugacak tekst','LONG_TEXT','Dugacko tekstualno polje namenjeno za dugacke sekcije');
insert into sectionfieldtype(name, key_value)  values ('Celi broj','INTEGER');
insert into sectionfieldtype(name, key_value)  values ('Decimalni broj','DOUBLE');
insert into sectionfieldtype(name, key_value, description)  values ('Slika','IMAGE','Slika(maksimalna velicina 15 MB)');
insert into sectionfieldtype(name, key_value, description)  values ('Fajl','FILE','Fajl(maksimalna velicina 15 MB)');

CREATE TABLE `sectionfield` (
                                `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                `name` varchar(255) NOT NULL,
                                `description` varchar(255) NULL,
                                `section_field_type_id` bigint(20) NOT NULL,
                                PRIMARY KEY (`id`),
                                UNIQUE KEY `UNIQUE_SECTIONFIELD_NAME` (`name`),
                                KEY `fk_sectionfield_sectionfieldtype` (`section_field_type_id`),
                                CONSTRAINT `fk_sectionfield_sectionfieldtype` FOREIGN KEY (`section_field_type_id`) REFERENCES `sectionfieldtype` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `section` (
                           `id` bigint(20) NOT NULL AUTO_INCREMENT,
                           `name` varchar(255) NOT NULL,
                           `description` varchar(255) NULL,
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `UNIQUE_SECTION_NAME` (`name`)
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
                                         `string_value` varchar(10000) NULL,
                                         `number_value` bigint NULL,
                                         `double_value` double NULL,
                                         `date_value` datetime NULL,
                                         `blob_value` mediumblob NULL,
                                         PRIMARY KEY (`cv_id`, `section_id`, `section_field_id`),
                                         KEY `fk_cvsectionsectionfield_cvsection_cv_id` (`cv_id`),
                                         KEY `fk_cvsectionsectionfield_cvsection_section_id` (`section_id`),
                                         KEY `fk_cvsectionsectionfield_sectionfield` (`section_field_id`),
                                         CONSTRAINT `fk_cvsectionsectionfield_cvsection_cv_id` FOREIGN KEY (`cv_id`) REFERENCES `cvsection` (`cv_id`) ON UPDATE CASCADE ON DELETE CASCADE,
                                         CONSTRAINT `fk_cvsectionsectionfield_cvsection_section_id` FOREIGN KEY (`section_id`) REFERENCES `cvsection` (`section_id`) ON UPDATE CASCADE ON DELETE CASCADE ,
                                         CONSTRAINT `fk_cvsectionsectionfield_sectionfield` FOREIGN KEY (`section_field_id`) REFERENCES `sectionfield` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;