package ru.omsu.imit.spring_service;

import ru.omsu.imit.dao.*;
import ru.omsu.imit.daoImplements.*;

public class BaseService {
    protected ProductDAO productDAO = new ProductDAOImpl();
    protected BuyerDAO buyerDAO = new BuyerImpl();
    protected BasketDAO basketDAO = new BasketDAOImpl();
    protected PurchaseDAO purchaseDAO =  new PurchaseDAOImpl();
    protected SelectedProductInPurchaseDAO productInPurchaseDAO =  new SelectedProductInPurchaseDAOImpl();
    protected SelectedProductInBasketDAO productInBasketDAO = new SelectedProductInBasketDAOImpl();
    protected UserDao userDao = new UserDao();
}
