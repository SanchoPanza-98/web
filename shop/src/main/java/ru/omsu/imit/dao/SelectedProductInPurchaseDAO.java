package ru.omsu.imit.dao;

import ru.omsu.imit.model.Purchase;
import ru.omsu.imit.model.SelectedProductInPurchase;

public interface SelectedProductInPurchaseDAO {

    SelectedProductInPurchase insert(SelectedProductInPurchase selectedProduct);
    SelectedProductInPurchase getById(int id);
    void deleteAll();
    void deleteByPurchase(Purchase purchase);
}
