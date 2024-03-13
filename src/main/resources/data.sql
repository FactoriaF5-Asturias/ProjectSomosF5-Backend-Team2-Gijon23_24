/*Categories*/

INSERT INTO categories (id_category, category_name) VALUES (default, 'Para hogar');
INSERT INTO categories (id_category, category_name) VALUES (default, 'Zona Geek');
INSERT INTO categories (id_category, category_name) VALUES (default, 'Litofonías');

/*Products*/
/*Las ideas de productos: https://all3dp.com/es/1/objetos-3d-utiles-ideas-imprimir-3d */
INSERT INTO products (id_product, product_name, product_description, product_image, price) VALUES (default, 'Tope de puerta flexible', 'Esta es una alternativa al tope de puerta tradicional que utiliza la flexibilidad del plástico para su buen funcionamiento.', 'tope-de-puerta.jpg', 9.99);
INSERT INTO products (id_product, product_name, product_description, product_image, price) VALUES (default, 'Papelera de sobremesa', 'Con esta impresión en tres partes (cubo inferior, parte superior y tapa), tendrás un lugar para todos esos viejos adhesivos, envoltorios de chocolatinas y restos de sacapuntas.', 'papelera-sobremesa.jpg', 11.99);
INSERT INTO products (id_product, product_name, product_description, product_image, price) VALUES (default, 'Tiburón marcapáginas', 'Este es, sin duda, el marcapáginas perfecto para leer la novela «Tiburón», de Peter Benchley.', 'tiburon-marcapaginas.jpg', 7.99);
INSERT INTO products (id_product, product_name, product_description, product_image, price) VALUES (default, 'Soporte para auriculares', 'Este soporte para auriculares se adapta a cualquier tablero de mesa de hasta 25 mm de grosor y admite un ancho de diadema de 45 mm.', 'soporte-auriculares.jpg', 11.99);
INSERT INTO products (id_product, product_name, product_description, product_image, price) VALUES (default, 'Portarollos para papel higiénico', 'Este modelo de la oveja Shawn tiene capacidad para un rollo, es fácil de montar, y su esponjoso resultado visual es de lo más divertido.', 'portarollos-oveja.jpg', 12.99);


INSERT INTO products (id_product, product_name, product_description, product_image, price) VALUES (default, 'Estatua de Son Goku', 'Una estatua de Son Goku. El material es el plástico ecológico. Pintada a mano.', 'goku-statue.jpg', 29.99);
INSERT INTO products (id_product, product_name, product_description, product_image, price) VALUES (default, 'Estatua de Superman', 'Una estatua de Bulma. El material es el plástico ecológico. Pintada a mano.', 'bulma-statue.jpg', 39.99);
INSERT INTO products (id_product, product_name, product_description, product_image, price) VALUES (default, 'Estatua de Krillin', 'Una estatua de Krillin. El material es el plástico ecológico. Pintada a mano.', 'krillin-statue.jpg', 19.99);
INSERT INTO products (id_product, product_name, product_description, product_image, price) VALUES (default, 'Estatua de Piccolo', 'Una estatua de Piccolo. El material es el plástico ecológico. Pintada a mano.', 'piccolo-statue.jpg', 24.99);
INSERT INTO products (id_product, product_name, product_description, product_image, price) VALUES (default, 'Estatua de Son Gohan', 'Una estatua de Son Gohan. El material es el plástico ecológico. Pintada a mano.', 'son-gohan-statue.jpg', 34.99);

/*Categories-Products*/

INSERT INTO categories_products (product_id, category_id) VALUES (1, 1);
INSERT INTO categories_products (product_id, category_id) VALUES (2, 1);
INSERT INTO categories_products (product_id, category_id) VALUES (3, 1);
INSERT INTO categories_products (product_id, category_id) VALUES (4, 1);
INSERT INTO categories_products (product_id, category_id) VALUES (5, 1);

INSERT INTO categories_products (product_id, category_id) VALUES (6, 2);
INSERT INTO categories_products (product_id, category_id) VALUES (7, 2);
INSERT INTO categories_products (product_id, category_id) VALUES (8, 2);
INSERT INTO categories_products (product_id, category_id) VALUES (9, 2);
INSERT INTO categories_products (product_id, category_id) VALUES (10, 2);