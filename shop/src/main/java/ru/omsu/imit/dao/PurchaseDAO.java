package ru.omsu.imit.dao;

import ru.omsu.imit.model.*;
import java.sql.Timestamp;
import java.util.List;

public interface PurchaseDAO {

    Purchase insert(Purchase purchase);
    Purchase getById(int id);
    void deleteAll();
    int getSumPurchase(Purchase purchase);
    Purchase updateSum(Purchase purchase, int sum);
    List<Purchase> getByBuyer(Buyer buyer);
    List<Purchase> getByPurchaseDate(Timestamp purchaseDate);
    List<Purchase> getByPurchaseDateAndBuyer(Timestamp purchaseDate, Buyer buyer);
    List<Purchase> getByBuyerAndPayment(Buyer buyer , Payment payment);
    List<SelectedProductInPurchase> getProductsInPurchase(Integer buyerId);
}
