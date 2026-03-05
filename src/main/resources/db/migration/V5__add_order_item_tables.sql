CREATE TABLE `store_api`.`order_items` (
  `id` BIGINT AUTO_INCREMENT NOT NULL,
  `order_id` BIGINT NOT NULL,
  `product_id` BIGINT NOT NULL,
  `unit_price` DECIMAL(10,2) NOT NULL,
  `quantity` INT NOT NULL,
  `total_price` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `order_items_order__fk_idx` (`order_id` ASC) VISIBLE,
  INDEX `order_items_products_id_fk_idx` (`product_id` ASC) VISIBLE,
  CONSTRAINT `order_items_orders_id_fk`
    FOREIGN KEY (`order_id`)
    REFERENCES `store_api`.`orders` (`id`),
  CONSTRAINT `order_items_products_id_fk`
    FOREIGN KEY (`product_id`)
    REFERENCES `store_api`.`products` (`id`));
