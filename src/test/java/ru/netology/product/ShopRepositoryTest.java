package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test
    public void removeWhenProductExistTest() {
        ShopRepository shopRepository = new ShopRepository();
        Product product1 = new Product(1, "Телефон", 30_000);
        Product product2 = new Product(2, "Ноутбук", 70_000);
        Product product3 = new Product(3, "Мышка", 800);

        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);
        shopRepository.remove(1);
        Product[] expected = {product2, product3};
        Product[] actual = shopRepository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeWhenProductNotExistTest() {
        ShopRepository shopRepository = new ShopRepository();
        Product product1 = new Product(1, "Телефон", 30_000);
        Product product2 = new Product(2, "Ноутбук", 70_000);
        Product product3 = new Product(3, "Мышка", 800);

        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> shopRepository.remove(5)
        );
    }
}