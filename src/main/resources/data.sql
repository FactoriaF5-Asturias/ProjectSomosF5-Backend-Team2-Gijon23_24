INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_ADMIN');
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_USER');

INSERT INTO users(id_user, username, password) VALUES (default, 'admin', '$2a$12$xOx5K0CaHRWkRgaZBRHvZ.tcrVC/AeA3sIjCySnHKk6ZEM9kmuIyO');

INSERT INTO users(id_user, username, password) VALUES (default, 'user1', '$2a$12$xOx5K0CaHRWkRgaZBRHvZ.tcrVC/AeA3sIjCySnHKk6ZEM9kmuIyO');
INSERT INTO users(id_user, username, password) VALUES (default, 'user2', '$2a$12$xOx5K0CaHRWkRgaZBRHvZ.tcrVC/AeA3sIjCySnHKk6ZEM9kmuIyO');

INSERT INTO role_users (role_id, user_id) VALUES (1, 1);
INSERT INTO role_users (role_id, user_id) VALUES (2, 2);
INSERT INTO role_users (role_id, user_id) VALUES (2, 3);