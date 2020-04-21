package ru.omsu.imit.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import ru.omsu.imit.dto.request.BasketRequest;
import ru.omsu.imit.dto.request.ProductRequest;
import ru.omsu.imit.dto.request.PurchaseRequest;
import ru.omsu.imit.dto.request.buyer.BuyerRequest;
import ru.omsu.imit.dto.request.selectedProduct.SelectedProductInBasketRequest;
import ru.omsu.imit.dto.request.selectedProduct.SelectedProductInPurchaseRequest;
import ru.omsu.imit.dto.response.selectedProduct.SelectedProductInBasketResponse;
import ru.omsu.imit.dto.response.selectedProduct.SelectedProductInPurchaseResponse;
import ru.omsu.imit.model.Payment;
import ru.omsu.imit.spring.BaseTest;

import java.sql.Date;
import java.sql.Timestamp;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SelectedProductInBasketTest extends BaseTest {

    @Test
    public void testAddProductInBasket() {
        ProductRequest dto1 = new ProductRequest(1,200000, "Computer");
        SelectedProductInBasketRequest dto = new SelectedProductInBasketRequest(1,
                new BasketRequest(1,new BuyerRequest(1,"Иванов", "Иван", "Иванович",
                        Date.valueOf("1980-02-13"), "ivanov2@mail.ru","ivanov", "0000","00000000013")),dto1,2);
        HttpEntity<SelectedProductInBasketRequest> request = new HttpEntity<>(dto);

        HttpEntity<String> response = template.exchange(urlPrefix + "/api/selectedProductsInBasket",
                HttpMethod.POST, request, String.class);

        //ResponseEntity<ProductResponse> res = template.postForEntity(new URI(""+urlPrefix+"/api/product"),dto,ProductResponse.class);
        SelectedProductInBasketResponse dtoResponse = json.fromJson(response.getBody(),SelectedProductInBasketResponse.class);
        assert dtoResponse != null;
        System.out.println(dtoResponse);
        //assertEquals(dto.getProductName(), dtoResponse.getProductName());


    }

}