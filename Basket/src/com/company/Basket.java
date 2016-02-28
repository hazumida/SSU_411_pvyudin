package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by UdinPV on 26.02.2016.
 */
public class Basket implements IBasket {
    Map<String, Integer> basket = new HashMap<String, Integer>();

    @Override
    public void addProduct(String product, int quantity) {
        basket.put(product, quantity);
    }

    @Override
    public void removeProduct(String product) {
        basket.remove(product);
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        basket.replace(product, quantity);
    }

    @Override
    public void clear() {
        basket.clear();
    }

    @Override
    public List<String> getProducts() {
        for (String key : basket.keySet()) {
            System.out.println(key);
        }
        if (basket.size()  == 0) {
            System.out.println("Корзина пуста");
        }
        return null;
    }

    @Override
    public int getProductQuantity(String product) {
        return basket.get(product);
    }
}
