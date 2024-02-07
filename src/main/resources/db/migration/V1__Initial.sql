CREATE TABLE IF NOT EXISTS developer (
    `id` BIGINT AUTO_INCREMENT,
    name VARCHAR(255),
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS skill (
    id BIGINT AUTO_INCREMENT,
    title VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE rel_developer_skill (
    id BIGINT AUTO_INCREMENT,
    developer_id BIGINT,
    skill_id BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (developer_id) REFERENCES developer(id),
    FOREIGN KEY (skill_id) REFERENCES skill(id)
);