CREATE TABLE categories (
      id      BIGSERIAL PRIMARY KEY,
      title    VARCHAR(255) NOT NULL
);

CREATE TABLE products (
    id          BIGSERIAL PRIMARY KEY,
    title        VARCHAR(255) NOT NULL,
    price       NUMERIC NOT NULL,
    category_id BIGSERIAL NOT NULL,
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

INSERT INTO categories (id, title) VALUES
(1, 'Фрукты'),
(2, 'Мясо'),
(3, 'Напитки'),
(4, 'Гигиена'),
(5, 'Одежда'),
(6, 'Оружие');

INSERT INTO products (title, price, category_id) VALUES
('Яблоко', 5.40, 1),
('Апельсин', 12.50, 1),
('Хлеб', 5.40, 1),
('Арбуз', 15.40, 1),
('Говядина', 200.00, 2),
('Свинина', 190.50, 2),
('Курица', 160.20, 2),
('Кофе', 260.30, 3),
('Чай', 180.50, 3),
('Сок', 80.60, 3),
('Стиральный порошок', 50.13, 4),
('Мыло', 22.50, 4),
('Зубная паста', 25.40, 4),
('Зубная щетка', 15.10, 4),
('Футболка', 220.00, 5),
('Шорты', 180.30, 5),
('Штаны', 240.00, 5),
('Туфли', 260.80, 5),
('Кроссовки', 380.50, 5),
('BFG', 1180.20, 6);