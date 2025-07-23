DROP TABLE IF EXISTS posts;
CREATE TABLE posts(
    post_id INT NOT NULL,
    thread_id INT NOT NULL,
    board varchar(15) NOT NULL,
    post_time BIGINT(255) UNSIGNED NOT NULL,
    content varchar(1023),
    img_url varchar(127),
    bump_index INT UNSIGNED NOT NULL,
    PRIMARY KEY(post_id, thread_id)
);