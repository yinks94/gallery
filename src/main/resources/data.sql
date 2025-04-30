INSERT INTO items (name, img_path, price, discount_per, created)
VALUES ('Starry', '/img/001.jpg', 10000000, 5, CURRENT_TIMESTAMP),
       ('Seascape', '/img/002.jpg', 20000000, 10, CURRENT_TIMESTAMP),
       ('Arles', '/img/003.jpg', 30000000, 15, CURRENT_TIMESTAMP),
       ('Mountain', '/img/004.jpg', 40000000, 20, CURRENT_TIMESTAMP),
       ('Provence', '/img/005.jpg', 50000000, 25, CURRENT_TIMESTAMP),
       ('Houses', '/img/006.jpg', 60000000, 30, CURRENT_TIMESTAMP);

INSERT INTO members (name, login_id, login_pw)
VALUES ('알파', 'alpha@example.com', 'password111');