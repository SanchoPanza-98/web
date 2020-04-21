package ru.omsu.imit.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import ru.omsu.imit.dto.request.ProductRequest;
import ru.omsu.imit.dto.request.PurchaseRequest;
import ru.omsu.imit.dto.request.buyer.BuyerRequest;
import ru.omsu.imit.dto.request.selectedProduct.SelectedProductInPurchaseRequest;
import ru.omsu.imit.dto.response.ProductResponse;
import ru.omsu.imit.dto.response.selectedProduct.SelectedProductInPurchaseResponse;
import ru.omsu.imit.model.Payment;
import ru.omsu.imit.model.SelectedProductInPurchase;

import java.sql.Date;
import java.sql.Timestamp;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SelectedProductsInPurchaseTest extends BaseTest {

    @Test
    public void testCreateProduct() {
        ProductRequest dto1 = new ProductRequest(1,12500, "Tea");
        SelectedProductInPurchaseRequest dto = new SelectedProductInPurchaseRequest(1,
                new PurchaseRequest(1,
                        new BuyerRequest(6,"Петров", "Сидор", "Иванович",
                        Date.valueOf("1980-02-13"), "ivanov2@mail.ru", "petrov","0000","00000000013")
                        , Timestamp.valueOf("2019-12-15 00:00:01"), Payment.EWALLET.toString(),null),
                dto1,2);
        HttpEntity<SelectedProductInPurchaseRequest> request = new HttpEntity<>(dto);

        HttpEntity<String> response = template.exchange(urlPrefix + "/api/selectedProductsInPurchase",
                HttpMethod.POST, request, String.class);

        //ResponseEntity<ProductResponse> res = template.postForEntity(new URI(""+urlPrefix+"/api/product"),dto,ProductResponse.class);
        SelectedProductInPurchaseResponse dtoResponse = json.fromJson(response.getBody(),SelectedProductInPurchaseResponse.class);
        assert dtoResponse != null;
        System.out.println(dtoResponse);
        //assertEquals(dto.getProductName(), dtoResponse.getProductName());


    }
}
