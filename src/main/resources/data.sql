/*Categories*/

INSERT INTO categories (id_category, category_name) VALUES (default, 'Para hogar');
INSERT INTO categories (id_category, category_name) VALUES (default, 'Zona Geek');
INSERT INTO categories (id_category, category_name) VALUES (default, 'Litofonías');

/*Products*/

INSERT INTO products (id_product, product_name, product_description, product_image, price) VALUES (default, 'Estatua de Batman', 'Una estatua de Batman en 3D', 'batman-statue.jpg', 29.99);

/*Categories-Products*/

INSERT INTO categories_products (product_id, category_id) VALUES (1, 2);