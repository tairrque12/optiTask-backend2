CREATE TABLE robots (
                        id          BIGSERIAL PRIMARY KEY,
                        name        VARCHAR(100) NOT NULL,
                        description TEXT
);

CREATE TABLE customers (
                           id         BIGSERIAL PRIMARY KEY,
                           first_name VARCHAR(100) NOT NULL,
                           last_name  VARCHAR(100) NOT NULL,
                           email      VARCHAR(150) NOT NULL UNIQUE
);

CREATE TABLE tasks (
                       id         BIGSERIAL PRIMARY KEY,
                       name       VARCHAR(100) NOT NULL,
                       base_price NUMERIC(10,2) NOT NULL,
                       robot_id   BIGINT NOT NULL REFERENCES robots(id)
);

CREATE TABLE reservations (
                              id          BIGSERIAL PRIMARY KEY,
                              customer_id BIGINT NOT NULL REFERENCES customers(id),
                              task_id     BIGINT NOT NULL REFERENCES tasks(id),
                              location    VARCHAR(255) NOT NULL,
                              duration    INTEGER NOT NULL,
                              total_price NUMERIC(10,2) NOT NULL,
                              created_at  TIMESTAMP DEFAULT NOW()
);