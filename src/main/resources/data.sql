/*Login roles*/
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_ADMIN');
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_USER');
 
 /*Users*/
INSERT INTO users(id_user, username, password) VALUES (default, 'admin', '$2a$12$xOx5K0CaHRWkRgaZBRHvZ.tcrVC/AeA3sIjCySnHKk6ZEM9kmuIyO');

INSERT INTO users(id_user, username, password) VALUES (default, 'user1', '$2a$12$xOx5K0CaHRWkRgaZBRHvZ.tcrVC/AeA3sIjCySnHKk6ZEM9kmuIyO');

INSERT INTO users(id_user, username, password) VALUES (default, 'user2', '$2a$12$xOx5K0CaHRWkRgaZBRHvZ.tcrVC/AeA3sIjCySnHKk6ZEM9kmuIyO');

/*Vinculed roles and user*/
INSERT INTO role_users (role_id, user_id) VALUES (1, 1);
INSERT INTO role_users (role_id, user_id) VALUES (2, 2);
INSERT INTO role_users (role_id, user_id) VALUES (2, 3);

/*Profile default*/
INSERT INTO profiles(id_profile, user_id, email, first_Name, last_Name, address, postal_Code, number_Phone) VALUES(default, 1, 'admin', 'Juan', 'apellidos1', 'direccion1', '88888', '12312323');

INSERT INTO profiles(id_profile, user_id, email, first_Name, last_Name, address, postal_Code, number_Phone) VALUES(default, 2, 'user1', 'Mark', 'apellidos2', 'direccion2', '11111', '32132132');

INSERT INTO profiles(id_profile, user_id, email, first_Name, last_Name, address, postal_Code, number_Phone) VALUES(default, 3, 'user2', 'Nico', 'apellidos3', 'direccion3', '22222', '21212111');

/*Categories*/

INSERT INTO categories (id_category, category_name) VALUES (default, 'Para hogar');
INSERT INTO categories (id_category, category_name) VALUES (default, 'Zona Geek');
INSERT INTO categories (id_category, category_name) VALUES (default, 'Litofanías');

/*Products*/
/*Las ideas de productos: https://all3dp.com/es/1/objetos-3d-utiles-ideas-imprimir-3d */
/*Category 1*/
INSERT INTO products (id_product, product_name, product_description, price) VALUES (default, 'Tope de puerta flexible', 'Esta es una alternativa al tope de puerta tradicional que utiliza la flexibilidad del plástico para su buen funcionamiento.', 9.99);
INSERT INTO products (id_product, product_name, product_description, price) VALUES (default, 'Papelera de sobremesa', 'Con esta impresión en tres partes (cubo inferior, parte superior y tapa), tendrás un lugar para todos esos viejos adhesivos, envoltorios de chocolatinas y restos de sacapuntas.', 11.99);
INSERT INTO products (id_product, product_name, product_description, price) VALUES (default, 'Tiburón marcapáginas', 'Este es, sin duda, el marcapáginas perfecto para leer la novela «Tiburón», de Peter Benchley.', 7.99);
INSERT INTO products (id_product, product_name, product_description, price) VALUES (default, 'Soporte para auriculares', 'Este soporte para auriculares se adapta a cualquier tablero de mesa de hasta 25 mm de grosor y admite un ancho de diadema de 45 mm.', 11.99);
INSERT INTO products (id_product, product_name, product_description, price) VALUES (default, 'Portarollos para papel higiénico', 'Este modelo de la oveja Shawn tiene capacidad para un rollo, es fácil de montar, y su esponjoso resultado visual es de lo más divertido.', 12.99);

/*Category 2*/
/* https://www.3dspartanshop.com/wp-content/uploads/2020/11/goku-ssj3-statue-5.jpg */
INSERT INTO products (id_product, product_name, product_description, price) VALUES (default, 'Estatua de Son Goku', 'Una estatua de Son Goku. El material es el plástico ecológico. Pintada a mano.', 29.99);
/* https://img2.cgtrader.com/items/3233997/c319458483/large/bulma-3d-model-max-obj-3ds-fbx-c4d-ma.jpg */
INSERT INTO products (id_product, product_name, product_description, price) VALUES (default, 'Estatua de Bulma', 'Una estatua de Bulma. El material es el plástico ecológico. Pintada a mano.', 39.99);
/* https://img-new.cgtrader.com/items/3203986/c316a94197/large/krillin-statue-3d-model-low-poly-max-obj-3ds-fbx-c4d-ma.jpg */
INSERT INTO products (id_product, product_name, product_description, price) VALUES (default, 'Estatua de Krillin', 'Una estatua de Krillin. El material es el plástico ecológico. Pintada a mano.', 19.99);
/* https://www.3dspartanshop.com/wp-content/uploads/2023/04/piccolo-diorama-statue-3-poses.jpg */
INSERT INTO products (id_product, product_name, product_description, price) VALUES (default, 'Estatua de Piccolo', 'Una estatua de Piccolo. El material es el plástico ecológico. Pintada a mano.', 24.99);
/* https://www.3dspartanshop.com/wp-content/uploads/2021/04/gohan-samurai-diorama-statue-2.jpg */
INSERT INTO products (id_product, product_name, product_description, price) VALUES (default, 'Estatua de Son Gohan', 'Una estatua de Son Gohan. El material es el plástico ecológico. Pintada a mano.', 34.99);

/*Category 3*/
/* https://www.etsy.com/listing/1306615109/personalized-litofania-with-your-photo?ga_order=most_relevant&ga_search_type=all&ga_view_type=gallery&ga_search_query=litofania+personalizado&ref=sr_gallery-1-2&frs=1&organic_search_click=1 */
INSERT INTO products (id_product, product_name, product_description, price) VALUES (default, 'Litofanía de un perro', 'Litofanía de un perro y escrito de Eren 2015', 29.99);
/* https://www.etsy.com/listing/1018490312/custom-litofanias?ga_order=most_relevant&ga_search_type=all&ga_view_type=gallery&ga_search_query=litofania+personalizado&ref=sr_gallery-1-7&frs=1&organic_search_click=1 */
INSERT INTO products (id_product, product_name, product_description, price) VALUES (default, 'Litofanía Amor para simpre', 'Litofanía de una pareja feliz.', 39.99);
/* https://www.etsy.com/listing/1658428405/star-lithophany?ga_order=most_relevant&ga_search_type=all&ga_view_type=gallery&ga_search_query=litofania+personalizado&ref=sr_gallery-1-11&frs=1&organic_search_click=1 */
INSERT INTO products (id_product, product_name, product_description, price) VALUES (default, 'Litofanía Estrella Con Un Bebé', 'Litofanía en forma de una estrella con un bebé', 19.99);
/* https://www.etsy.com/listing/819391996/3d-printed-lithophane-lightbox?ga_order=most_relevant&ga_search_type=all&ga_view_type=gallery&ga_search_query=litofania+personalizado&ref=sc_gallery-3-7&plkey=01203bb24d8064fad683bda50a142f11bba97ee1%3A819391996 */
INSERT INTO products (id_product, product_name, product_description, price) VALUES (default, 'Litofanía Prince', 'Una litofonía en forma de cubo con imagenes de Prince', 24.99);
/* https://www.etsy.com/listing/963042341/custom-nightlight-your-picture-made-into?ga_order=most_relevant&ga_search_type=all&ga_view_type=gallery&ga_search_query=litofonia&ref=sc_gallery-2-7&sts=1&search_preloaded_img=1&plkey=cfddcd828e489a4399fc2e80655594158df225bc%3A963042341 */
INSERT INTO products (id_product, product_name, product_description, price) VALUES (default, 'Litofanía Gato', 'Litofanía de un gato', 34.99);

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

INSERT INTO categories_products (product_id, category_id) VALUES (11, 3);
INSERT INTO categories_products (product_id, category_id) VALUES (12, 3);
INSERT INTO categories_products (product_id, category_id) VALUES (13, 3);
INSERT INTO categories_products (product_id, category_id) VALUES (14, 3);
INSERT INTO categories_products (product_id, category_id) VALUES (15, 3);

/*Images*/

/*Category 1*/
INSERT INTO images (id_image, image_name, is_main_image, product_id) VALUES (default, 'tope-de-puerta.jpg', true, 1);
INSERT INTO images (id_image, image_name, is_main_image, product_id) VALUES (default, 'papelera-sobremesa.jpg', true, 2);
INSERT INTO images (id_image, image_name, is_main_image, product_id) VALUES (default, 'tiburon-marcapaginas.jpg', true, 3);
INSERT INTO images (id_image, image_name, is_main_image, product_id) VALUES (default, 'soporte-auriculares.jpg', true, 4);
INSERT INTO images (id_image, image_name, is_main_image, product_id) VALUES (default, 'portarollos-oveja.jpg', true, 5);
/*Category 2*/
INSERT INTO images (id_image, image_name, is_main_image, product_id) VALUES (default, 'goku-statue.jpg', true, 6);
INSERT INTO images (id_image, image_name, is_main_image, product_id) VALUES (default, 'bulma-statue.jpg', true, 7);
INSERT INTO images (id_image, image_name, is_main_image, product_id) VALUES (default, 'krillin-statue.jpg', true, 8);
INSERT INTO images (id_image, image_name, is_main_image, product_id) VALUES (default, 'piccolo-statue.jpg', true, 9);
INSERT INTO images (id_image, image_name, is_main_image, product_id) VALUES (default, 'son-gohan-statue.jpg', true, 10);
/*Category 3*/
INSERT INTO images (id_image, image_name, is_main_image, product_id) VALUES (default, 'litofania-perro.jpg', true, 11);
INSERT INTO images (id_image, image_name, is_main_image, product_id) VALUES (default, 'litofania-pareja.jpg', true, 12);
INSERT INTO images (id_image, image_name, is_main_image, product_id) VALUES (default, 'litofania-estrella-bebe.jpg', true, 13);
INSERT INTO images (id_image, image_name, is_main_image, product_id) VALUES (default, 'litofania-prince.jpg', true, 14);
INSERT INTO images (id_image, image_name, is_main_image, product_id) VALUES (default, 'litofania-gato.jpg', true, 15);

/*Favoritos*/

INSERT INTO fav_products_profiles (product_id, profile_id) VALUES (1, 1);