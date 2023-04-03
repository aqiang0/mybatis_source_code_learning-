create table user
(
    id        bigint       not null
        primary key,
    email     varchar(255) not null,
    nick_name varchar(255) null,
    pass_word varchar(255) not null,
    reg_time  varchar(255) not null,
    user_name varchar(255) not null,
    constraint UK_d2ia11oqhsynodbsi46m80vfc
        unique (nick_name),
    constraint UK_lqjrcobrh9jc8wpcar64q1bfh
        unique (user_name),
    constraint UK_ob8kqyqqgmefl0aco34akdtpe
        unique (email)
);

INSERT INTO test.user (id, email, nick_name, pass_word, reg_time, user_name) VALUES (1, 'abc.com', 'abc', 'passabc', '2022-09-26 18:14:23', 'abc');
INSERT INTO test.user (id, email, nick_name, pass_word, reg_time, user_name) VALUES (2, 'abc2.com', 'abc2', 'passabc', '2022-09-24', 'abc2');
INSERT INTO test.user (id, email, nick_name, pass_word, reg_time, user_name) VALUES (3, 'abc3.com', 'abc3', 'passabc', '2022-09-24', 'abc3');
