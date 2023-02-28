package com.example.mobiletestapp;

import static org.junit.Assert.assertEquals;

import com.example.mobiletestapp.Model.Product;

import org.junit.Test;

public class ProductTest {
    Product product = new Product("1", "Book", "100.129", "3596227959", "https://i.pinimg.com/originals/60/38/7b/60387bfc9f91172d2d456286b4022991.png");

    /**
     * Тест на разделение числа на целую и дробную части
     */
    @Test
    public void SeparationPriceTest() {
        product.SeparationPrice("100.129");

        assertEquals(100, product.getWholePartPrice());
        assertEquals(129, product.getFractionalPartPrice());
    }

    /**
     * Тест на разделение цены на разряды
     */
    @Test
    public void DivisionPriceTest() {
        product.DivisionPrice(100000);
        assertEquals("100 000", product.getRankPrice());
    }
}
