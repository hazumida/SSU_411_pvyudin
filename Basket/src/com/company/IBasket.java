package com.company;

import java.util.List;

/**
 * Created by Павел on 26.02.2016.
 */

public interface IBasket {
    void addProduct(String product, int quantity);
    void removeProduct(String product);
    void updateProductQuantity(String product, int quantity);
    void clear();
    List<String> getProducts();
    int getProductQuantity(String product);
}
