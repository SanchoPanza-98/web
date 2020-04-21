package ru.omsu.imit.dao;

import ru.omsu.imit.model.Basket;
import ru.omsu.imit.model.Buyer;
import ru.omsu.imit.model.SelectedProductInBasket;

import java.util.List;

public interface BasketDAO {

    Basket insert(Basket basket);
    Basket getById(int id);
    Basket getByBuyer(int buyerId);
    Basket deleteBasket(Basket basket);
    List<SelectedProductInBasket> getProductsInBasket(Integer buyerId);
    void deleteAll();
}
