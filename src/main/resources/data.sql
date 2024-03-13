INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_ADMIN');
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_USER');

INSERT INTO users(id_user, username, password) VALUES (default, 'administrador', 'contraseña');

INSERT INTO role_users (role_id, user_id) VALUES (1, 1)