CREATE TABLE `store_api`.`orders` (
  `id` BIGINT AUTO_INCREMENT NOT NULL,
  `customer_id` BIGINT NOT NULL,
  `status` VARCHAR(20) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT current_timestamp,
  `total_price` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `orders_users__fk_idx` (`customer_id` ASC) VISIBLE,
  CONSTRAINT `orders_users__fk`
    FOREIGN KEY (`customer_id`)
    REFERENCES `store_api`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
