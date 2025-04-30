CREATE TABLE items
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    name         VARCHAR(50)                         NOT NULL,
    img_path     VARCHAR(100)                        NOT NULL,
    price        INT                                 NOT NULL,
    discount_per INT                                 NOT NULL,
    created      TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE members
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(50)                         NOT NULL,
    login_id VARCHAR(50)                         NOT NULL,
    login_pw VARCHAR(100)                        NOT NULL,
    created  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT members_uk UNIQUE (login_id)
);

CREATE TABLE carts
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    member_id INT                                 NOT NULL,
    item_id   INT                                 NOT NULL,
    created   TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE orders
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    member_id   INT                                 NOT NULL,
    name        VARCHAR(50)                         NOT NULL,
    address     VARCHAR(500)                        NOT NULL,
    payment     VARCHAR(10)                         NOT NULL,
    card_number VARCHAR(16), -- 카드 번호는 NULL 가능
    amount      BIGINT                              NOT NULL,
    created     TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE order_items
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT                                 NOT NULL,
    item_id  INT                                 NOT NULL,
    created  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

ALTER TABLE orders
    ADD CONSTRAINT fk_orders_member
        FOREIGN KEY (member_id) REFERENCES members (id);

ALTER TABLE order_items
    ADD CONSTRAINT fk_order_items_order
        FOREIGN KEY (order_id) REFERENCES orders (id);

ALTER TABLE order_items
    ADD CONSTRAINT fk_order_items_item
        FOREIGN KEY (item_id) REFERENCES items (id);
