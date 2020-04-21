package ru.omsu.imit.myBatisTests;

import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import ru.omsu.imit.dao.*;
import ru.omsu.imit.daoImplements.*;
import ru.omsu.imit.model.*;
import ru.omsu.imit.utils.MyBatisUtils;


import static org.junit.Assert.assertEquals;

public class BaseDAOTests {
	protected CommonDAO commonDAO = new CommonDAOImpl();
	protected BuyerDAO buyerDAO = new BuyerImpl();
	protected BasketDAO basketDAO = new BasketDAOImpl();
	protected ProductDAO productDAO = new ProductDAOImpl();
	protected PurchaseDAO purchaseDAO = new PurchaseDAOImpl();
	protected SelectedProductInBasketDAO productsListDAO = new SelectedProductInBasketDAOImpl();



	@BeforeClass()
	public static void init() {
		Assume.assumeTrue(MyBatisUtils.initSqlSessionFactory());
	}

	@Before()
	public void clearDatabase() {
		buyerDAO.deleteAll();
		basketDAO.deleteAll();
		productDAO.deleteAll();
		purchaseDAO.deleteAll();
		productsListDAO.deleteAll();

	}


	protected void checkBuyerFields(Buyer buyer1, Buyer buyer2) {
		assertEquals(buyer1.getFirstName(), buyer2.getFirstName());
		assertEquals(buyer1.getSecondName(), buyer2.getSecondName());
		assertEquals(buyer1.getPatronymic(), buyer2.getPatronymic());
		//assertEquals(buyer1.getBirthDate(), buyer2.getBirthDate());
	}

	protected void checkBasketFields(Basket basket1,Basket basket2){
		//assertEquals(basket1.getId(),basket2.getId());
		assertEquals(basket1.getBuyer(),basket2.getBuyer());

	}
	protected void checkProductFields(Product product1, Product product2){
		//assertEquals(basket1.getId(),basket2.getId());
		assertEquals(product1.getCost(),product2.getCost());
		assertEquals(product1.getProductName(),product2.getProductName());
	}

	protected void checkPurchaseFields(Purchase purchase1, Purchase purchase2){

		//assertEquals(purchase1.getId(),purchase2.getId());
		assertEquals(purchase1.getBuyer(),purchase2.getBuyer());
		assertEquals(purchase1.getPurchaseDate(),purchase2.getPurchaseDate());
		assertEquals(purchase1.getPayment(),purchase2.getPayment());

	}

	protected void checkProductsListFields(SelectedProductInBasket productsList1, SelectedProductInBasket productsList2) {
		assertEquals(productsList1.getBasket(),productsList2.getBasket());
		assertEquals(productsList1.getProduct(), productsList2.getProduct());
		assertEquals(productsList1.getQuantity(),productsList2.getQuantity());
	}

	/*
	protected void checkAuthorAddresses(Set<Address> addressesSet1, Set<Address> addressesSet2) {
		assertEquals(addressesSet1, addressesSet2);

	}*/


}
