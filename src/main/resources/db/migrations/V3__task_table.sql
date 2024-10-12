-- Create table Task
CREATE TABLE IF NOT EXISTS todo.task
(
    id          bigserial PRIMARY KEY,
    created_at  timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "version"   int8         NOT NULL DEFAULT 0,
    name        varchar(255) NOT NULL,
    description text         NULL,
    status      varchar(50)  NOT NULL,
    user_id     int8         NOT NULL
)
