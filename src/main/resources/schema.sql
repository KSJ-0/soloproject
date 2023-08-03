CREATE TABLE IF NOT EXISTS TASK (
    task_id bigint NOT NULL AUTO_INCREMENT,
    title varchar(100) NOT NULL,
    todoOrder int NOT NULL,
    completed bit NOT NULL,
    PRIMARY KEY (task_id)
    );