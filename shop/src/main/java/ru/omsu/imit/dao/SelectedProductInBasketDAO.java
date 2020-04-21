package ru.omsu.imit.dao;

import ru.omsu.imit.model.Basket;
import ru.omsu.imit.model.Product;
import ru.omsu.imit.model.SelectedProductInBasket;
import java.util.List;

public interface SelectedProductInBasketDAO {

    SelectedProductInBasket insert(SelectedProductInBasket selectedProduct);
    SelectedProductInBasket getById(int id);
    void deleteAll();
    void deleteByBasket(Basket basket);
    SelectedProductInBasket deleteById(SelectedProductInBasket productInBasket);
    SelectedProductInBasket deleteByBasketAndProduct(Basket basket, Product product);
    List<SelectedProductInBasket> getByProduct(Product product);
    List<SelectedProductInBasket> getByBasket(Basket basket);

}
