CREATE TABLE streams
(
    id             BIGINT PRIMARY KEY AUTO_INCREMENT,
    title          VARCHAR(255)        NOT NULL,
    classroom_link VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE educators
(
    id        BIGINT PRIMARY KEY AUTO_INCREMENT,
    login     VARCHAR(100) UNIQUE NOT NULL,
    password  VARCHAR(100)        NOT NULL,
    full_name VARCHAR(100)        NOT NULL
);

CREATE TABLE students
(
    id              BIGINT PRIMARY KEY AUTO_INCREMENT,
    full_name       VARCHAR(100)        NOT NULL,
    github_nickname VARCHAR(200) UNIQUE NOT NULL,
    stream_id       BIGINT              NOT NULL,
    FOREIGN KEY (stream_id) REFERENCES streams (id) ON DELETE CASCADE
);

CREATE TABLE courses
(
    id          BIGINT PRIMARY KEY AUTO_INCREMENT,
    stream_id   BIGINT       NOT NULL,
    title       VARCHAR(255) NOT NULL,
    educator_id BIGINT       NOT NULL,
    FOREIGN KEY (stream_id) REFERENCES streams (id) ON DELETE CASCADE
);

CREATE TABLE tasks
(
    id            BIGINT PRIMARY KEY AUTO_INCREMENT,
    course_id     BIGINT      NOT NULL,
    stream_id     BIGINT      NOT NULL,
    date_created  BIGINT      NOT NULL,
    date_deadline BIGINT      NOT NULL,
    title         VARCHAR(40) NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses (id) ON DELETE CASCADE,
    FOREIGN KEY (stream_id) REFERENCES streams (id) ON DELETE CASCADE
);

CREATE TABLE solutions
(
    id              BIGINT PRIMARY KEY AUTO_INCREMENT,
    task_id         BIGINT       NOT NULL,
    student_id      BIGINT       NOT NULL,
    status          VARCHAR(20) DEFAULT 'N/A',
    repository_link VARCHAR(150) NOT NULL,
    updates         TEXT,
    FOREIGN KEY (task_id) REFERENCES tasks (id) ON DELETE CASCADE,
    FOREIGN KEY (student_id) REFERENCES students (id) ON DELETE CASCADE,
    UNIQUE (task_id, student_id)
);