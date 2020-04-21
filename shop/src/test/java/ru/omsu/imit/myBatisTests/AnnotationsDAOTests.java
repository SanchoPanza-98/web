package ru.omsu.imit.myBatisTests;

import org.junit.Test;
import ru.omsu.imit.model.*;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class AnnotationsDAOTests extends BaseDAOTests {
/*
	@Test
	public void testInsertBuyer() {
		Buyer buyer = new Buyer(1,"Иван", "Иванов", "Иванович",Date.valueOf("1960-7-1"),"ivan@gmail.com");
		buyerDAO.insert(buyer);
		Buyer buyerFromDB = buyerDAO.getById(buyer.getId());
		checkBuyerFields(buyer, buyerFromDB);
	}

	@Test(expected = RuntimeException.class)
	public void testInsertBuyerWithNullName() {
		Buyer buyer = new Buyer(1,null, "Иванов", "Иванович",Date.valueOf("1960-7-1"),"ivan@gmail.com");
		buyerDAO.insert(buyer);
	}

	@Test
	public void testInsertTwoBuyers() {
		Buyer buyer1 = new Buyer(1,"Иван", "Иванов", "Иванович", Date.valueOf("1960-7-1"),"ivan@gmail.com");
		Buyer buyer2 = new Buyer(2,"Петр", "Петров", "Петрович", Date.valueOf("1980-7-1"),"petrov@gmail.com");
		buyerDAO.insert(buyer1);
		buyerDAO.insert(buyer2);
		List<Buyer> buyersFromDB = buyerDAO.getAllLazy();
		assertEquals(2, buyersFromDB.size());
		Collections.sort(buyersFromDB, (p1, p2) -> Integer.compare(p1.getId(), p2.getId()));
		checkBuyerFields(buyer1, buyersFromDB.get(0));
		checkBuyerFields(buyer2, buyersFromDB.get(1));
	}

	@Test
	public void testDeleteBuyer() {
		Buyer buyer = new Buyer(1,"Иван", "Иванов", "Иванович",Date.valueOf("1960-7-1"),"ivan@gmail.com");
		buyerDAO.insert(buyer);
		Buyer buyerFromDB = buyerDAO.getById(buyer.getId());
		checkBuyerFields(buyer, buyerFromDB);
		buyerDAO.delete(buyer);
		buyerFromDB = buyerDAO.getById(buyer.getId());
		assertNull(buyerFromDB);
	}

	@Test
	public void testChangeAuthorFirstName() {
		Buyer buyer = new Buyer(1,"Иван", "Иванов", "Иванович",Date.valueOf("1960-7-1"),"ivan@gmail.com");
		buyerDAO.insert(buyer);
		Buyer buyerFromDB = buyerDAO.getById(buyer.getId());
		checkBuyerFields(buyer, buyerFromDB);
		buyerDAO.changeFirstName(buyer, "Василий");
		buyerFromDB = buyerDAO.getById(buyer.getId());
		assertEquals("Василий", buyerFromDB.getFirstName());
	}

	@Test
	public void testInsertBuyerWithBasket() {
		Buyer buyer = new Buyer(1,"Иван", "Иванов", "Иванович",Date.valueOf("1960-7-1"),"ivan@gmail.com");
		buyerDAO.insert(buyer);
		Buyer buyerFromDB = buyerDAO.getById(buyer.getId());
		Basket basket = new Basket(1,buyerFromDB.getId(),null);
		basketDAO.insert(buyer);

		Basket basketFromDB = basketDAO.getByBuyer(buyer);

		checkBasketFields(basket, basketFromDB);

	}

	@Test
	public void testInsertProduct(){
		Product product = new Product(1,20000,"Наушники");
		productDAO.insert(product);
		Product productFromDB=productDAO.getById(product.getId());
		checkProductFields(product,productFromDB);

	}

	@Test
	public void testInsertTwoProducts() {
		Product product1 = new Product(1,20000, "Стерео наушники");
		Product product2 = new Product(2,20000, "Чехол для наушников");
		productDAO.insert(product1);
		productDAO.insert(product2);
		List<Product> productsFromDB = productDAO.getByCost(20000);
		assertEquals(2, productsFromDB.size());
		Collections.sort(productsFromDB, (p1, p2) -> Integer.compare(p1.getId(), p2.getId()));
		checkProductFields(product1, productsFromDB.get(0));
		checkProductFields(product2, productsFromDB.get(1));
	}

	@Test
	public void testGetByProductName() {
		Product product1 = new Product(1,20000, "Наушники");
		Product product2 = new Product(2,30000, "Наушники");
		productDAO.insert(product1);
		productDAO.insert(product2);
		List<Product> productsFromDB = productDAO.getByProductName("Наушники");
		assertEquals(2, productsFromDB.size());
		Collections.sort(productsFromDB, (p1, p2) -> Integer.compare(p1.getId(), p2.getId()));
		checkProductFields(product1, productsFromDB.get(0));
		checkProductFields(product2, productsFromDB.get(1));
	}

	@Test
	public void testGetAllLazyProducts() {
		Product product1 = new Product(1,20000, "Наушники");
		Product product2 = new Product(2,40000, "Стерео наушники");

		productDAO.insert(product1);
		productDAO.insert(product2);

		List<Product> productsFromDB = productDAO.getAllLazy();
		assertEquals(2, productsFromDB.size());
		Collections.sort(productsFromDB, (p1, p2) -> Integer.compare(p1.getId(), p2.getId()));
		checkProductFields(product1, productsFromDB.get(0));
		checkProductFields(product2, productsFromDB.get(1));


	}

	@Test
	public void testDeleteProduct() {
		Product product = new Product(1,50000,  "Гарнитура");
		productDAO.insert(product);
		Product productFromDB = productDAO.getById(product.getId());
		checkProductFields(product, productFromDB);
		productDAO.delete(product);
		productFromDB = productDAO.getById(product.getId());
		assertNull(productFromDB);
	}

	/*@Test
	public void testInsertPurchase() {
		Buyer buyer = new Buyer(1,"Иван", "Иванов", "Иванович",Date.valueOf("1960-7-1"),"ivan@gmail.com");
		buyerDAO.insert(buyer);
		Buyer buyerFromDB = buyerDAO.getById(buyer.getId());
		checkBuyerFields(buyer,buyerFromDB);

		Product product = new Product(1,50000,  "Гарнитура");
		productDAO.insert(product);
		Product productFromDB = productDAO.getById(product.getId());
		checkProductFields(product, productFromDB);

		Purchase expected = new Purchase(1,buyer.getId(),Timestamp.valueOf("2019-9-2 00:00:00"), "BANKCARD",null);
		purchaseDAO.insert(buyer,Timestamp.valueOf("2019-9-2 00:00:00"), Payment.BANKCARD);
		List<Purchase> purchasesFromDB = purchaseDAO.getByBuyer(buyer);
		checkPurchaseFields(expected,purchasesFromDB.get(0));
	}





	@Test
	public void testGetPurchaseByPurchaseDate() {
		Buyer buyer1 = new Buyer(1,"Иван", "Иванов", "Иванович",Date.valueOf("1960-7-1"),"ivan@gmail.com");
		Buyer buyer2 = new Buyer(2,"Петр","Петров","Петрович",Date.valueOf("1970-6-2"),"petrov@mail.ru");
		buyerDAO.insert(buyer1);
		buyerDAO.insert(buyer2);


		Product product1 = new Product(1,50000,  "Гарнитура");
		Product product2 = new Product(2,24000,"Гарнитура");
		productDAO.insert(product1);
		productDAO.insert(product2);

		Purchase expected1 = new Purchase(1,buyer1.getId(),Timestamp.valueOf("2019-9-2 00:00:00"), "BANKCARD",null);
		Purchase expected2 = new Purchase(2,buyer2.getId(),Timestamp.valueOf("2019-9-3 00:00:00"), "BANKCARD",null);
		purchaseDAO.insert(buyer1,Timestamp.valueOf("2019-9-2 00:00:00"), Payment.BANKCARD);
		purchaseDAO.insert(buyer2,Timestamp.valueOf("2019-9-3 00:00:00"), Payment.BANKCARD);
		List<Purchase> purchasesFromDB = purchaseDAO.getByPurchaseDate(Timestamp.valueOf("2019-9-3 00:00:00"));
		checkPurchaseFields(expected2,purchasesFromDB.get(0));
	}

	@Test
	public void testGetPurchaseByPurchaseDatAndBuyer() {
		Buyer buyer1 = new Buyer(1,"Иван", "Иванов", "Иванович",Date.valueOf("1960-7-1"),"ivan@gmail.com");
		buyerDAO.insert(buyer1);

		Product product1 = new Product(1,50000,  "Гарнитура");
		Product product2 = new Product(2,24000,"Гарнитура");
		productDAO.insert(product1);
		productDAO.insert(product2);


		Purchase expected = new Purchase(2,buyer1.getId(),Timestamp.valueOf("2019-9-3 00:00:00"), "BANKCARD",null);
		purchaseDAO.insert(buyer1,Timestamp.valueOf("2019-9-2 00:00:00"), Payment.BANKCARD);
		purchaseDAO.insert(buyer1,Timestamp.valueOf("2019-9-3 00:00:00"), Payment.BANKCARD);
		List<Purchase> purchasesFromDB = purchaseDAO.getByPurchaseDateAndBuyer(Timestamp.valueOf("2019-9-3 00:00:00"),buyer1);
		checkPurchaseFields(expected,purchasesFromDB.get(0));
	}

	@Test
	public void testGetPurchaseByBuyerAndPayment() {
		Buyer buyer1 = new Buyer(1,"Иван", "Иванов", "Иванович",Date.valueOf("1960-7-1"),"ivan@gmail.com");
		//Buyer buyer2 = new Buyer(2,"Петр","Петров","Петрович",Date.valueOf("1970-6-2"),"petrov@mail.ru");
		buyerDAO.insert(buyer1);
		//buyerDAO.insert(buyer2);

		Product product1 = new Product(1,50000,  "Гарнитура");
		Product product2 = new Product(2,24000,"Чехол для телефона");
		productDAO.insert(product1);
		productDAO.insert(product2);


		Purchase expected = new Purchase(2,buyer1.getId(),Timestamp.valueOf("2019-9-3 00:00:00"), "BANKCARD",null);
		purchaseDAO.insert(buyer1,Timestamp.valueOf("2019-9-2 00:00:00"), Payment.eWallet);
		purchaseDAO.insert(buyer1,Timestamp.valueOf("2019-9-3 00:00:00"), Payment.BANKCARD);
		List<Purchase> purchasesFromDB = purchaseDAO.getByBuyerAndPayment(buyer1,Payment.BANKCARD);
		checkPurchaseFields(expected,purchasesFromDB.get(0));
	}

	@Test
	public void testInsertProductsList() {
		Buyer buyer1 = new Buyer(1,"Иван", "Иванов", "Иванович",Date.valueOf("1960-7-1"),"ivan@gmail.com");
		//Buyer buyer2 = new Buyer(2,"Петр","Петров","Петрович",Date.valueOf("1970-6-2"),"petrov@mail.ru");
		buyerDAO.insert(buyer1);
		//buyerDAO.insert(buyer2);

		Product product1 = new Product(1,50000,  "Гарнитура");
		productDAO.insert(product1);


		Basket basket1= new Basket(1,buyer1.getId(),null);
		basketDAO.insert(buyer1);
		Basket basketFromDB = basketDAO.getByBuyer(buyer1);

		purchaseDAO.insert(buyer1,Timestamp.valueOf("2019-9-2 00:00:00"), Payment.eWallet);
		List<Purchase> purchaseFromDB = purchaseDAO.getByBuyer(buyer1);

		productsListDAO.insert(basketFromDB,product1,purchaseFromDB.get(0),2);

		List<SelectedProductInBasket> productsListsFromDB = productsListDAO.getByProduct(product1);
		checkProductsListFields(
				new SelectedProductInBasket(1,basketFromDB.getId(),product1.getId(),purchaseFromDB.get(0).getId(),2,100000)
				,productsListsFromDB.get(0));

	}

	@Test
	public void testGetProductsInBasket() {
		Buyer buyer1 = new Buyer(1,"Иван", "Иванов", "Иванович",Date.valueOf("1960-7-1"),"ivan@gmail.com");
		buyerDAO.insert(buyer1);
		Buyer buyer2 = new Buyer(2,"Петр","Петров","Петрович",Date.valueOf("1960-7-2"),"petrov@gmail.com");
		buyerDAO.insert(buyer2);

		Product product1 = new Product(1,50000,  "Гарнитура");
		productDAO.insert(product1);
		Product product2 = new Product(2,80000,"USB-кабель");
		productDAO.insert(product2);
		Product product3 = new Product(3,45000,"Наушники");
		productDAO.insert(product3);

		Basket basket1= new Basket(1,buyer1.getId(),null);
		basketDAO.insert(buyer1);
		Basket basketFromDB = basketDAO.getByBuyer(buyer1);
		Basket basket2 = new Basket(2,buyer2.getId(),null);
		basketDAO.insert(buyer2);
		Basket basketFromDB2= basketDAO.getByBuyer(buyer2);

		purchaseDAO.insert(buyer1,Timestamp.valueOf("2019-9-2 00:00:00"), Payment.eWallet);
		purchaseDAO.insert(buyer2,Timestamp.valueOf("2019-9-2 00:00:00"), Payment.eWallet);
		List<Purchase> purchaseFromDB = purchaseDAO.getByBuyer(buyer1);
		List<Purchase> purchaseFromDB2 = purchaseDAO.getByBuyer(buyer2);

		productsListDAO.insert(basketFromDB,product1,null,2);
		productsListDAO.insert(basketFromDB2,product3,null,1);
		productsListDAO.insert(null,product2,purchaseFromDB.get(0),1);
		productsListDAO.insert(null,product3,purchaseFromDB2.get(0),1);

		List<SelectedProductInBasket> productsListsFromDB = productsListDAO.getByBasket(basketFromDB);
		List<SelectedProductInBasket> productsInBasket = basketDAO.getProductsInBasket(buyer1);
		assertEquals(productsListsFromDB,productsInBasket);

		List<SelectedProductInBasket> expectedProd = productsListDAO.getByPurchase(purchaseFromDB.get(0));
		//System.out.println(buyer1.getId());
		List<SelectedProductInBasket> selectedProducts = purchaseDAO.getProductsInPurchase(buyer1);
		assertEquals(expectedProd,selectedProducts);

	}
*/
}
